#include <iostream>
using namespace std;

int main()
{
    float a, b, c;
    cout << "Inserire tre valori: ";
    cin >> a >> b >> c;
    if ((a>b) && (a>c)) cout << a << " è il valore maggiore" << endl;
    else if ((b>a) && (b>c)) cout << b << " è il valore maggiore" << endl;
    else cout << c << " è il valore maggiore" << endl;
}