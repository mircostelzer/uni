#include <iostream>
using namespace std;

int def_array(int a[], int n) {
    for ( int i=0; i<n; i++) {
        cin >> a[i];
    }
    return a[n];
}

void add(int a[], int &dim,int x,int i) {
    for (int j=dim; j>i; j--) {
        a[j] = a[j-1];
    }
    a[i] = x;
    dim++;
}

int main()
{
    int dim;
    cin >> dim;
    int a[dim], x, i;
    def_array(a, dim);
    cin >> x >> i;
    for (int j = 0; j< dim; j++) {
        cout << a[j];
    }
    cout << endl;
    add(a, dim, x, i);
    for (int j = 0; j< dim; j++) {
        cout << a[j];
    }
    cout << endl;
}