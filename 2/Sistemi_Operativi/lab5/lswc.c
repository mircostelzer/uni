#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    int fd = open("/tmp/tmp.txt", O_RDWR | O_CREAT, S_IRUSR | S_IWUSR);
    dup2(fd, 1);
    int pid;

    if (argc != 3) {
        fprintf(stderr, "%s\n", "You have to specify two arguments");
        exit(1);
    }

    pid = fork();
    if (pid == 0) {
        execlp(argv[1], NULL);
    } else {
        wait(NULL);
        lseek(fd, 0, SEEK_SET);
        dup2(fd, 0);
        execlp(argv[2], NULL);
    }

    return 0;
}