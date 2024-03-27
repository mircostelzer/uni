#include <iostream>
using namespace std;

const int dim = 5;

void printArray(const char a[]) {
    for (int i=0; i<dim; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

char *rotate(char *a, char v[], int j) {
    for (int i=0; i<dim; i++, j++) {
        a[i] = v[j%dim];
    }
    return a;
}

int main()
{
    char v[dim] = {'A','B','C', 'D','E'};
    int j;
    char *rot = new char [dim];
    printArray(v);
    cin >> j;
    rot = rotate(rot, v, j);
    printArray(rot);
    delete[] rot;
}