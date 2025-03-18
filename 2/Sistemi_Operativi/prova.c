#include <stdio.h>

union Val {
    int uno;
    float due;
};

int main()
{

    union Val var[4] = {1, 2.2, 3, 4};

    for (int i=0; i<4; i++) {
        printf("%f\t", var[i]);
    }

    return 0;
}