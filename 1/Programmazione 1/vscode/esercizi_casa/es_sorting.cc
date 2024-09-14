#include <iostream>
using namespace std;

double def_array(double a[], int n)
{
    for (int i=0; i<n; i++) {
        cin >> a[i];
    }
    return a[n];
}

int search(const double a[], int n, double target, int loc=0)
{
  bool found = (a[loc]==target);                                                                   
    if (loc>=n || loc<0) {
        return -1;
    }
    else if (found) {
        return loc;
    }
    return search( a, n, target, loc+1);
}                                  

int main()
{
    int n;
    cin >> n;
    double a[n], target;
    def_array(a, n);
    for (int i=0; i<n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
    cin >> target;
    cout << search(a, n, target) << endl;
}