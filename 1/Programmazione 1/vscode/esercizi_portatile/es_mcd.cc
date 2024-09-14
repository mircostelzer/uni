#include <iostream>
#include <cmath>
using namespace std;

int mcd (int a, int b){
    int resto;
    while (b!=0) {
        resto = a%b;
        a = b;
        b = resto;
    }
    return a;
}

int main ()
{
    int n1, n2;
    cin >> n1 >> n2;
    cout << mcd (n1, n2) << endl;
}