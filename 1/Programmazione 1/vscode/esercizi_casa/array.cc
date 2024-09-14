#include <iostream>
using namespace std;

int def_array(int a[], int n)
{
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }
    return a[n];
}

int main()
{
    int n;
    cin >> n;
    int a[n];
    def_array(a, n);
    for (int i=0; i<n; i++) {
        cout << a[i] << ", ";
    }
    cout << endl;
}