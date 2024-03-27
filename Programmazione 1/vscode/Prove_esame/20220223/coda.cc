// Inserisci qui il codice implementazione delle funzioni in coda.h
#include "coda.h"
#include <iostream>

const int MAX_DIM = 11;

struct queue {
    int q[MAX_DIM] = {0};
    int s1;
    int s2;
};

static queue coda;

void init() {
    coda.s1 = -1;
    coda.s2 = -1;
}

bool enqueue(int n) {
    bool res;
    if ((coda.s1+coda.s2+2) >= 11) {
        res = false;
    }
    else if (coda.s1>coda.s2) {
        coda.s2++;
        coda.q[MAX_DIM-coda.s2-1] = n;
        res = true;
    }
    else {
        coda.s1++;
        coda.q[coda.s1] = n;
        res = true;
    }

    return res;
}

bool firstS1(int& n) {
    bool res;
    if (coda.s1==-1) {
        res = false;
    }
    else {
        n = coda.q[0];
        res = true;
    }

    return res;
}

bool firstS2(int& n) {
    bool res;
    if (coda.s2==-1) {
        res = false;
    }
    else {
        n = coda.q[MAX_DIM-1];
        res = true;
    }

    return res;
}

bool dequeueS1() {
    bool res;
    if (coda.s1==-1) {
        res = false;
    }
    else {
        for (int i=0; i<=coda.s1; i++) {
            coda.q[i] = coda.q[i+1];
        }
        coda.q[coda.s1] = 0;
        coda.s1--;
        res = true;
    }

    return res;
}

bool dequeueS2() {
    bool res;
    if (coda.s2==-1) {
        res = false;
    }
    else {
        for (int i=0; i<=coda.s2; i++) {
            coda.q[MAX_DIM-1-i] = coda.q[MAX_DIM-i-2];
        }
        coda.q[MAX_DIM-1-coda.s2] = 0;
        coda.s2--;
        res = true;
    }

    return res;
}

void deinit() {

}

void print() {

    std::cout << "S1: ";
    for (int i=0; i<=coda.s1; i++) {
        std::cout << coda.q[i] << " ";
    }
    std::cout << '\n';

    std::cout << "S2: ";
    for (int i=0; i<=coda.s2; i++) {
        std::cout << coda.q[MAX_DIM-1-i] << " ";
    }
    std::cout << '\n';

}