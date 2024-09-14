#include <iostream>
#include <cstdlib>
using namespace std;

const int dim=3;

void def_array(int a[][dim])
{
    srand(time(NULL));
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim; j++) {
        a[i][j] = rand()%10;
    }
    }
}

void filter(const int a[][dim],int b[][dim]) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim; j++) {
            int somma=0, n=0;
            if (j-1>=0) {
                somma+=a[i][j-1];
                n++;
            }
            if (j<dim-1) {
                somma+=a[i][j+1];
                n++;
            }
            if (i-1>=0) {
                somma+=a[i-1][j];
                n++;
            }
            if (i<dim-1) {
                somma+=a[i+1][j];
                n++;
            }
            b[i][j]=(somma/n);
        }
    }
}

void print_array(const int a[][dim]) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim; j++) {
        cout << a[i][j] << " ";
    }
    cout << endl;
    }
}

int main()
{
    int a[dim][dim], b[dim][dim];
    def_array(a);
    print_array(a);
    cout << endl;
    filter (a, b);
    print_array(b);
}