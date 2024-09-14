#include <iostream>
#include <fstream>
using namespace std;

/* Scrivere un programma che, dato un file in input da linea di comando
contenente diverse temperature. Il file è costituito da una sola colonna
e le temperature sono rappresentate come numeri reali. Il programma
salvi queste temperature in un array dinamico e stampi a video le
prime N temperature più alte. Il valore N viene specificato dall’utente
da linea di comando. Il programma accetta anche un intero M che
indica quante temperature al massimo sono presenti nel file. */

int getDim(fstream &input) {
    int count=0;
    float a;
    while (!input.fail() && !input.eof()) {
        input >> a;
        count++;
    }
    return count;
}

float * fillArray(float *a, int dim, fstream &input) {
    float temp;
    for (int i=0; i<dim; i++) {
        input >> temp;
        a[i] = temp;
    }
    return a;
}

float * sort(float *a, int dim) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<(dim-1); j++) {
            if (a[j]<a[j+1]) {
                int tmp;
                tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
            }
        }
    }
    return a;
}

void printTemp(float *a, int &n) {
    for (int i=0; i<n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

int main(int argc, char *argv[])
{
    if (argc != 3) {
        cerr << "Error!" << endl;
        cerr << "Usage: ./a.out file N" << endl;
        exit (0);
    }
    fstream input;
    int n = atoi(argv[2]);
    input.open(argv[1], ios::in);
    int dim = getDim(input);
    input.close();
    float *temp = new float [dim];
    input.open(argv[1], ios::in);
    fillArray(temp, dim, input);
    input.close();
    sort(temp, dim);
    printTemp(temp, n);
    cout << dim << endl;
    delete[] temp;

    return 0;
}

