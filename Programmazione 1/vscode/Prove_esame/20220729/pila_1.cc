#include <iostream>
#include "pila_1.h"
using namespace std;

static int *p;
static int dimensione;
static int Ip1;
static int Ip2;

void init(int dim) {
    dimensione = dim;
    p = new int[dim];
    Ip1 = -1;
    Ip2 = dimensione;
}

bool pushP1(int valore) {
    if (Ip1+1==Ip2) {
        return false;
    }
    else {
        Ip1++;
        p[Ip1] = valore;
        return true;
    }
}

bool pushP2(int valore) {
    if (Ip1+1==Ip2) {
        return false;
    }
    else {
        Ip2--;
        p[Ip2] = valore;
        return true;
    }
}

bool topP1(int &n) {
    if (Ip1==-1) {
        return false;
    }
    else {
        n = p[Ip1+1];
        return true;
    }
}

bool topP2(int &n) {
    if (Ip2==dimensione) {
        return false;
    }
    else {
        n = p[Ip1-1];
        return true;
    }
}

bool popP1() {
    if (Ip1==-1) {
        return false;
    }
    else {
        Ip1--;
        return true;
    }
}

bool popP2() {
    if (Ip2==dimensione) {
        return false;
    }
    else {
        Ip2++;
        return true;
    }
}

void deinit() {
    delete[] p;
}

void print() {
    if (Ip1==-1) {
        cout << "P1 vuota\n";
    }
    else {
        for (int i=0; i<=Ip1; i++) {
            cout << p[i] << " ";
        }
        cout << '\n';
    }
    if (Ip2==dimensione) {
        cout << "P2 vuota\n";
    }
    else {
        for (int i=dimensione-1; i>=Ip2; i--) {
            cout << p[i] << " ";
        }
        cout << '\n';
    }
}