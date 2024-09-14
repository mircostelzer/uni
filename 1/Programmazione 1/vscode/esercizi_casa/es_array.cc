#include <iostream>
using namespace std;



int def_array(int a[], int &n)
{   cin >> n;
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }
    return a[n];
}
/*int comp(const int a[],int b[], int n) {
    for (int i=n-1, j=0; i>=0; i--, j++) {
        b[j] = a[i];
        }
    return b[n];
} */

int main()
{
    const int size = 100;
    int n;
    int a[size];
    def_array(a, n);
    // comp(a,b, n);
    for (int i=0; i<n; i++) {
        cout << a[i];
    }
    cout << endl;
    for (int i=0; i< n;i++) {
        if (a[i]==1)
        {cout << 0;
    } else cout << 1;
    }
    cout << endl;
}