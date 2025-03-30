#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>

#define MAX_BUFF 4096 

int main(int argc, char **argv)
{
    if (argc < 2) {
        fprintf(stderr, "%s\n", "Illegal argument value\nUsage: ./fcopy <file_name>");
        exit(1);
    }

    FILE *str = fopen(argv[1], "r");
    if (str == NULL) {
        fprintf(stderr, "%s\n", "File not found");
        exit(1);
    }

    int fd_copy = open("copy", O_RDWR | O_CREAT, S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH);

    char buff[MAX_BUFF];

    while (!feof(str)) {
        fgets(buff, MAX_BUFF, str);
        write(fd_copy, buff, strlen(buff));
    }

    fclose(str);
    close(fd_copy);

    return 0;
}