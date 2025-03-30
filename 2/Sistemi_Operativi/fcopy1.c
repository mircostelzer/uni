#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <sys/stat.h>

int main(int argc, char **argv)
{
    if (argc < 2) {
        fprintf(stderr, "%s\n", "Illegal argument value\nUsage: ./fcopy <file_name>");
        exit(1);
    }

    int str = open(argv[1], O_RDONLY);
    if (str < 3) {
        fprintf(stderr, "%s\n", "File not found");
        exit(1);
    }

    FILE *fcopy = fopen("copy", "w+");
    if (fcopy == NULL) {
        fprintf(stderr, "%s\n", "Failed to open the file for writing");
        close(str);
        exit(1);
    }

    char *ch = malloc(sizeof(char));
    int bytes_read;

    while ((bytes_read = read(str, ch, sizeof(char))) > 0) {
        fputc(*ch, fcopy);
    }

    free(ch);
    fclose(fcopy);
    close(str);

    return 0;
}