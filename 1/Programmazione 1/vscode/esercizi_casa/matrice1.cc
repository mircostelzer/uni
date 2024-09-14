#include <iostream>
#include <cstdlib>
using namespace std;

const int dim=3;

void def_array(int a[][dim], int n)
{
    srand(time(NULL));
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
        a[i][j] = rand()%10;
    }
    }
}

int somma(int a[][dim], int n) {
    int res=0;
    for (int i=0; i<n; i++) {
        for (int j=n-1; j>=i; j--) {
            res+=a[i][j];
    }
    }
    return res;
}

void print_array(const int a[][dim],int n) {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
        cout << a[i][j] << " ";
    }
    cout << endl;
    }
}

int main()
{
    int a[dim][dim];
    def_array(a, dim);
    print_array(a, dim);
    cout << endl;
    cout << somma(a, dim) << endl;
}