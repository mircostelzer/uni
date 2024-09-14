#include <iostream>
using namespace std;

int main()
{
    cout << "Inserire un valore n: ";
    int n, i;
    cin >> n;
    double r = 1;
    for (i = 1; i <= n; i++) {
        cout << double(1/r) << " ";
        r *= 2;
    }
    
}