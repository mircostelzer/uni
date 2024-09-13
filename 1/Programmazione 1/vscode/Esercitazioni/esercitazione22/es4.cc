#include <iostream>
#include <cstdlib>
using namespace std;

/* Scrivere un programma che, dato un intero positivo N, crei
dinamicamente e stampi un array contenente i primi N numeri
esagonali, partendo da 0.
L’i-esimo numero esagonale è uguale a E(i)=i(2i-1)
Nota: non si possono usare cicli */

void esa(int *a, int n) {
    int i = n-1;
    if (n==1) {
        a[i] = 0;    
    }
    else {
        a[i] = i*((2*i)-1);
        esa(a, n-1);
    }
}

void printArray(const int *a, int n, int i=0) {
    if (i == n) {
        cout << endl;
    }
    else {
        cout << a[i] << " ";
        printArray(a, n, i+1);
    }
}

int main()
{
    int n;
    cout << "N: ";
    cin >> n;
    int *esagonali = new int [n];
    esa(esagonali, n);
    printArray(esagonali, n);
    
    return 0;
}