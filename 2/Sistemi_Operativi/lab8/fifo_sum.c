#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <errno.h>
#include <time.h>

int main(int argc, char **argv)
{
    if (argc < 2) {
        fprintf(stderr, "You have to specify the number of children to create\n");
        exit(1);
    }

    char *fifo = "/tmp/fifo";
    if (mkfifo(fifo, S_IRUSR | S_IWUSR) == -1 && errno != EEXIST) {
        perror("mkfifo failed");
        exit(1);
    }

    int children = atoi(argv[1]);

    for (int i = 0; i < children; i++) {
        pid_t pid = fork();
        if (pid == 0) {
            // Child process
            srand(time(NULL) ^ getpid());
            int num = rand() % 100;
            printf("Child %d: %d\n", getpid(), num);

            int fd = open(fifo, O_WRONLY);
            if (fd < 0) {
                perror("Child open fifo");
                exit(1);
            }
            if (write(fd, &num, sizeof(num)) != sizeof(num)) {
                perror("Child write");
                close(fd);
                exit(1);
            }
            close(fd);
            exit(0);
        }
    }

    // Parent process
    int sum = 0;
    int num;
    int fd = open(fifo, O_RDONLY);
    if (fd < 0) {
        perror("Parent open fifo");
        exit(1);
    }

    while(wait(NULL)>0);

    for (int i = 0; i < children; i++) {
        if (read(fd, &num, sizeof(num)) != sizeof(num)) {
            perror("Parent read");
        } else {
            sum += num;
        }
    }

    close(fd);

    // Wait for all children
    

    printf("Total sum: %d\n", sum);

    unlink(fifo);  // Clean up FIFO
    return 0;
}