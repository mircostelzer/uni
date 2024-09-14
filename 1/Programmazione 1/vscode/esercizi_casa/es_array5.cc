#include <iostream>
#include <cstdlib>
using namespace std;

/*Scrivere un programma che dichiari e poi inizializzi (con valori random) un array di 10 interi, lo stampi
a video, lo inverta tramite funzione ricorsiva e poi stampi l’array invertito. Si puo utilizzare la funzione `
rand della libreria <cstdlib>. */

int dim = 10;

void def_array(int a[], int n) {
    srand(time(NULL));
    for (int i=0; i<n; i++) {
        a[i] = rand()%10;
    }
}

void print(const int a[], int n) {
    for (int i=0;i<n;i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

void inverti(int a[], int n, int i=0, int tmp=0) {
    if (i==n || i<0) {
        return;
    }
    else {
        tmp = a[i];
        a[i] = a[n-1];
        a[n-1] = tmp;
        inverti(a, n-1, i+1);
    }
}

int main()
{
    int a[dim];
    def_array(a, dim);
    print(a, dim);
    inverti(a, dim);
    print(a, dim);
}
