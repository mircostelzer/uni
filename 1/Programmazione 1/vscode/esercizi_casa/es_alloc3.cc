#include <iostream>
using namespace std;

int * sort(int *a, int dim) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<(dim-1); j++) {
            if (a[j]>a[j+1]) {
                int tmp;
                tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
            }
        }
    }
    return a;
}

int * append(int *a, int *b, int dim1, int dim2) {
    int dim3 = dim1+dim2;
    int *c = new int [dim3];
    for (int i=0; i<dim1; i++) {
        c[i] = a[i];
    }
    for (int i=0, j=dim1; j<dim3; i++, j++) {
        c[j] = b[i];
    }
    sort(c, dim3);
    return c;
}

int * fillArray(int n) {
    int *a = new int [n];
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }
    return a;
}

void printArray(int *a, int n) {
    for (int i=0; i<n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

int main()
{
    int nx, ny;
    cin >> nx >> ny;
    int dim3 = nx+ny;
    int *a = fillArray(nx);
    sort(a, nx);
    printArray(a, nx);
    int *b = fillArray(ny);
    printArray(b, ny);
    sort(b, ny);
    int *c = append(a, b, nx, ny);
    printArray(c, dim3);
    delete[] a;
    delete[] b;
    delete[] c;
    return 0;
}