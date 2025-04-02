#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <sys/stat.h>

int main(int argc, char **argv)
{
    int fd = open("/tmp/log.txt", O_RDWR | O_CREAT, S_IRUSR | S_IWUSR);
    dup2(fd, 1);
    dup2(fd, 2);
    int pid;
    for (int i=1; i<argc; i++) {
        pid = fork();
        if (pid == 0) { //child
            execl(argv[i], NULL);
            return 0;
        }
        else { //parent
            wait(NULL);
        }
    }

    if (pid != 0) {
        printf("%s\n", "All processes finished");
        close(fd);
    }

    return 0;
}