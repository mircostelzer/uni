#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <errno.h>
#include <stdio.h>
#include <unistd.h>

#define READ 0
#define WRITE 1

int main()
{
    int p1[2], p2[2];
    char buf[50];
    int bytes;
    if ((pipe(p1) != 0) || (pipe(p2) != 0)) {
        perror("Error");
        exit(1);
    }

    int proc2 = !fork();
    if (proc2) {
        close(p1[WRITE]);
        close(p2[READ]);
        bytes = read(p1[READ], &buf, 50);
        if (bytes == -1) {
            perror("Error");
        }
        printf("P2 read %d bytes\n", bytes);
        bytes = write(p2[WRITE], "Writing", sizeof("Writing"));
        if (bytes == -1) {
            perror("Error");
        }
        bytes = read(p1[READ], &buf, 50);
        if (bytes == -1) {
            perror("Error");
        }
        printf("P2 read %d bytes\n", bytes);
        bytes = write(p2[WRITE], "Writing", sizeof("Writing"));
        if (bytes == -1) {
            perror("Error");
        }
        close(p1[READ]);
        close(p2[WRITE]);
    } else {
        close(p1[READ]);
        close(p2[WRITE]);
        bytes = write(p1[WRITE], "Writing1", sizeof("Writing1"));
        if (bytes == -1) {
            perror("Error");
        }
        bytes = read(p2[READ], &buf, 50);
        if (bytes == -1) {
            perror("Error");
        }
        printf("P1 read %d bytes\n", bytes);
        bytes = write(p1[WRITE], "Writing1", sizeof("Writing1"));
        if (bytes == -1) {
            perror("Error");
        }
        bytes = read(p2[READ], &buf, 50);
        if (bytes == -1) {
            perror("Error");
        }
        printf("P1 read %d bytes\n", bytes);
        close(p1[WRITE]);
        close(p2[READ]);
    }
    while(wait(NULL)>0);

    return 0;
}