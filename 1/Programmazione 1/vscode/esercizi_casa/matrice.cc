#include <iostream>
#include <cstdlib>
using namespace std;

const int dim=5;
const int dim1=3;

void def_array(int a[dim][dim1])
{
    srand(time(NULL));
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim1; j++) {
        a[i][j] = rand()%10;
    }
    }
}

void trasposta(const int a[dim][dim1], int b[dim1][dim]) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim1; j++) {
            b[j][i] = a[i][j];
    }
    }
}

void print_array(const int a[dim][dim1]) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim1; j++) {
        cout << a[i][j] << " ";
    }
    cout << endl;
    }
}

void print_array1(const int a[dim1][dim]) {
    for (int i=0; i<dim1; i++) {
        for (int j=0; j<dim; j++) {
        cout << a[i][j] << " ";
    }
    cout << endl;
    }
}

int main()
{
    int a[dim][dim1], b[dim1][dim];
    def_array(a);
    print_array(a);
    cout << endl;
    trasposta(a, b);
    print_array1(b);
}