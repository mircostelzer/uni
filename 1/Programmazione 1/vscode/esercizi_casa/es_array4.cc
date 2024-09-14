#include <iostream>
using namespace std;

/* scrivere una procedura che prenda un vettore v e la sua dimensione
  d, un elemento x, ed elimina tutte le occorrenze di x (diminuemdo la
  dimensione d del vettore) */

int def_array(int a[], int n)
{
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }
    return a[n];
}

void del(int a[], int &n, int x) {
    for (int i=0; i<n; i++) {
        if (a[i] == x) {
            for (int j=i; j<n; j++) {
                a[j] = a[j+1];
            }
            n--;
        }
    }
}

int main()
{
    int n;
    cin >> n;
    int a[n], x;
    def_array(a, n);
    for (int i=0; i<n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
    cin >> x;
    del(a,n,x);
    for (int i=0; i<n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}