#include <iostream>
using namespace std;



double def_array(double a[], int n)
{
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }
    return a[n];
}

double prod_scalare(const double a[], const double b[], int n) {
    int res;
    for (int i=0; i<n; i++) {
        res+= a[i]*b[i];
    }
    return res;
}

int main()
{
    const int size = 100;
    int n;
    cin >> n;
    double a[size], b[size];
    def_array(a, n);
    def_array(b, n);
    cout << prod_scalare(a,b,n) << endl;
}
