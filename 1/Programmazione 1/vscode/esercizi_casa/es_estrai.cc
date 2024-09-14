#include <iostream>
#include "es_estrai.h"
using namespace std;

void estrai_lettera(char stringa[], int i, char res[], int j) {
    if (stringa[i]=='\0') {
        res[j]='\0';
    }
    else {
        if ((stringa[i]>= 'A') && (stringa[i]<='Z')) {
        res[j] = stringa[i];
        j++;
    }
    estrai_lettera(stringa, i+1, res, j);
    }
}

char *estrai_stringa(char stringa[]) {
    char *res = new char[MAX_DIM];
    estrai_lettera(stringa, 0, res, 0);
    return res;
}