#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    int fd = open("/tmp/tmp.txt", O_RDWR | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR);
    if (fd == -1) {
        perror("Error opening file");
        close(fd);
        exit(1);
    }

    int dup1;
    if ((dup1 = dup(STDOUT_FILENO)) == -1) {
        fprintf(stderr, "%s\n", "Error duplicating stdout");
        exit(1);
    }
    if (dup2(fd, STDOUT_FILENO) == -1) {
        fprintf(stderr, "%s\n", "Error duplicating stdout");
        close(dup1);
        close(fd);
        exit(1);
    }
    
    if (argc != 3) {
        fprintf(stderr, "Usage: %s <command1> <command2>\n", argv[0]);
        close(dup1);
        close(fd);
        exit(1);
    }
    
    int pid;
    if ((pid = fork()) < 0) {
        fprintf(stderr, "%s\n", "Error forking");
        exit(1);
    } else if (pid == 0) {
        if (execlp(argv[1], argv[1], NULL) == -1) {
            execl(argv[1], argv[1], NULL);
        }
    } else {
        wait(NULL);
        lseek(fd, 0, SEEK_SET);

        if (dup2(fd, 0) == -1) {
            fprintf(stderr, "%s\n", "Error duplicating stdout");
            close(fd);
            close(dup1);
            exit(1);
        }
        close(fd);
        if (dup2(dup1, 1) == -1) {
            fprintf(stderr, "%s\n", "Error duplicating stdout");
            close(dup1);
            exit(1);
        }
        close(dup1);
        if (execlp(argv[2], argv[2], NULL) == -1) {
            execl(argv[2], argv[2], NULL);
        }
    }

    return 0;
}