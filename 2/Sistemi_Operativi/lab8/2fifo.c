#include <stdlib.h>
#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/stat.h>
#include <string.h>

int main(int argc, char **argv)
{
    char buff[50];
    char *fifo = "/tmp/fifo";
    mkfifo(fifo, S_IRUSR | S_IWUSR);

    int fd;
    int bytes;
    int p2 = !fork();
    if (p2) {
        fd = open(fifo, O_RDONLY);
        if (fd < 0) {
            perror("Error while opening fifo");
            exit(1);
        }
        bytes = read(fd, buff, 50);
        if (bytes < 0) {
            perror("Error in reading fifo");
            exit(1);
        }
        printf("P2 read %d bytes\n", bytes);
        close(fd);

        fd = open(fifo, O_WRONLY);
        if (fd < 0) {
            perror("Error while opening fifo");
            exit(1);
        }
        bytes = write(fd, "buff", strlen("buff") + 1);
        if (bytes < 0) {
            perror("Error in writing fifo");
            exit(1);
        }
        close(fd);

        fd = open(fifo, O_RDONLY);
        if (fd < 0) {
            perror("Error while opening fifo");
            exit(1);
        }
        bytes = read(fd, buff, 50);
        if (bytes < 0) {
            perror("Error in reading fifo");
            exit(1);
        }
        printf("P2 read %d bytes\n", bytes);
        close(fd);

        fd = open(fifo, O_WRONLY);
        if (fd < 0) {
            perror("Error while opening fifo");
            exit(1);
        }
        bytes = write(fd, "buff", strlen("buff") + 1);
        if (bytes < 0) {
            perror("Error in writing fifo");
            exit(1);
        }
        close(fd);



    } else {
        fd = open(fifo, O_WRONLY);
        if (fd < 0) {
            perror("Error while opening fifo");
            exit(1);
        }
        bytes = write(fd, "Writing", strlen("Writing") + 1);
        if (bytes < 0) {
            perror("Error in writing fifo");
            exit(1);
        }
        close(fd);
        
        fd = open(fifo, O_RDONLY);
        if (fd < 0) {
            perror("Error while opening fifo");
            exit(1);
        }
        bytes = read(fd, buff, 50);
        if (bytes < 0) {
            perror("Error in reading fifo");
            exit(1);
        }
        printf("P1 read %d bytes\n", bytes);
        close(fd);

        fd = open(fifo, O_WRONLY);
        if (fd < 0) {
            perror("Error while opening fifo");
            exit(1);
        }
        bytes = write(fd, "Writing", strlen("Writing") + 1);
        if (bytes < 0) {
            perror("Error in writing fifo");
            exit(1);
        }
        close(fd);

        fd = open(fifo, O_RDONLY);
        if (fd < 0) {
            perror("Error while opening fifo");
            exit(1);
        }
        bytes = read(fd, buff, 50);
        if (bytes < 0) {
            perror("Error in reading fifo");
            exit(1);
        }
        printf("P1 read %d bytes\n", bytes);
        close(fd);
    }
    while (wait(NULL)>0);


    return 0;
}