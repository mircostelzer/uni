#include <iostream>
#include <cmath>
using namespace std;


long double somm(int n) {
    long double res;
    if (n==0) {
        res = 1;
    }
    else res = 1/(pow(2, n)) + somm(n-1);
    return res;
}

int main()
{
    int n;
    cin >> n;
    cout << somm(n) << endl;
}