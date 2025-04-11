#include <stdio.h>

int main() {
    char buffer[1024];
    int lines = 0;
    while (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        lines++;
    }
    printf("Read %d lines \n", lines);
    return 0;
}