#include <iostream>
using namespace std;

int main()
{
    int n;
    cin >> n;
    for (int i=1; i<=n; i++) {
        int riga = 2*i-1;
        for (int j=1;j<=n-i;j++) {
            cout << " ";
        }
        for (int k=1;k<=riga;k++) {
            cout << "*";
        } cout << endl;
    }
    for (int l=1;l<n;l++) {
        for (int m=1; m<=l; m++) {
            cout << " ";
        }
        for (int o=1;o<2*(n-l);o++) {
            cout << "*";
        }
        cout << endl;
    }
}