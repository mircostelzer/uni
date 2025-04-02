#include <stdio.h>
#include <stdlib.h>

int strlen(char *str) {
    int length = 0;
    while (*str != '\0') {
        length++;
        str++;
    }

    return length;
}

char *stringrev(char *src) {
    int l = strlen(src);
    char *rev = (char *)malloc(sizeof(char)*(l+1));

    for (int i = 0; i < l; i++)
    {
        rev[i] = src[l-i-1];
    }
    
    rev[l] = '\0';
    return rev;
}

int stringpos(char *str, char c) {
    for (int i = 0; str[i] != '\0'; i++)
    {
        if (str[i] == c) {
            return i;
        }
    }
    
    return -1;
}

int main(int argc, char **argv)
{
    char *str = "Ciao";

    char *rev = stringrev(str);
    int i = stringpos(str, 'a');

    printf("%s\n%d\n", rev, i);

    return 0;
}