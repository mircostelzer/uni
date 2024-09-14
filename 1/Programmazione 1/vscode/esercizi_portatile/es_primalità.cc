#include <iostream>
using namespace std;

int main()
{
    int n, i, d = 0;
    cout << "Inserire un intero: ";
    cin >> n;
    if (n<2) {
        cout << n << " non è un numero primo" << endl;    
    }
    else if (n>=2 && n<1000) {
        for (i=1; i<=n; i++) {
            if (!(n%i)) {
                d++;
            }
        }
        if (d>2) {
        cout << n << " non è un numero primo" << endl;
    }
    else {
        cout << n << " è un numero primo" << endl;
        }
    }
    else cout << "Errore" << endl;
    
}