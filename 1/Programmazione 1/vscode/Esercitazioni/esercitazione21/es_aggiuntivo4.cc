#include <iostream>
#include <cstdlib> 
using namespace std;

void printArray(const char a[], int dim) {
    for (int i=0; i<dim; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

void fillArray(char *v, int n) {
    srand(time(NULL));
    for (int i=0; i<n; i++) {
        v[i] = char(rand()%26+'A');
    }
}

void rotation(char *a, char *res, int j, int dim, int i) {
    if (i == dim) {
    }
    else {
        res[i] = a[j%dim];
        rotation(a, res, j+1, dim, i+1);
    }
}

char *rotate(char *a, int j, int dim) {
    char *res = new char [dim];
    rotation(a, res, j, dim, 0);
    return res;
}

int main()
{
    int j, n;
    cin >> n;
    char *v = new char [n];
    fillArray(v, n);
    printArray(v, n);
    cin >> j;
    char *rot;
    rot = rotate(v, j, n);
    printArray(rot, n);
    delete[] rot;
    delete[] v;
}