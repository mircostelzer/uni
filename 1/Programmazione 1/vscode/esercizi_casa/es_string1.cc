#include <iostream>
#include <cmath>
#include "es_string1.h"
using namespace std;

static void upToLow(char c[]) {
        for (int i=0; c[i]!='\0'; i++) {
        if (c[i]>='A' && c[i]<='Z') {
            c[i]+= ('a'-'A');
        }
    }
}

bool checkAlpha(char c[]) {
    for (int i=0; c[i]!='\0'; i++) {
        if ((c[i]>='A' && c[i]<='Z')) {
            upToLow(c);
        }
        else if (c[i]< 'a' || c[i] > 'z') {
            return false;
        }
    }
    return true;
}

int punteggio(const char c[]) {
    int res=0;
    for (int i=1; c[i]!='\0'; i++) {
       res+= abs(c[i-1]-c[i]);
    }
    return res;
}