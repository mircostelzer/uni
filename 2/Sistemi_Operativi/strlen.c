#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
    if (argc < 2) {
        printf("%s\n", "Inserire un argomento");
        exit(1);
    }

    char *str = argv[1];

    int length = 0;
    while (*str != '\0') {
        length++;
        str++;
    }

    printf("%d\n", length);

    return 0;
}