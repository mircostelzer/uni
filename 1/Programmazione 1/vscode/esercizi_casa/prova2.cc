#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    int **a = new int *[n];
    for (int i=0; i<n; i++) {
        a[i] = new int [n];
    }
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cin >> a[i][j];
        }
    }
    for (int i=0; i<n; i++) {
        for (int j=0; j<n; j++) {
            cout << a[i][j];
        }
    }
    for (int i=0; i<n; i++) {
        delete [] a[i];
        }
    delete [] a;
}