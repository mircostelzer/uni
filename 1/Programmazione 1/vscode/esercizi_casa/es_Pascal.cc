#include <iostream>
#include <cmath>
using namespace std;

int Pascal(int i, int j) {
    if (i==1 || j==1 || j==(i+1)) {
        return 1;
    }
    else return (Pascal(i-1, j)+Pascal(i-1, j-1));
}

int main()
{
    int n, k;
    cin >> n >> k;
    cout << Pascal(n, k) << endl;
    for (int i=1; i<=n; i++) {
        int riga = i*2 - 1;
        for (int j=1; j<=(n-i); j++) {
            cout << "  ";
        }
        for (int l=1; l<=riga; l++) {
            cout << Pascal(i, l) << "   ";
        }
        cout << endl;
    }

}