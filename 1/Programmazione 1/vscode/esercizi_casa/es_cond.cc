#include <iostream>
using namespace std;

int main()
{
    cout << "Inserire una lettera: ";
    char a;
    cin >> a;
    if ((a=='A') || (a=='a') || (a=='E') || (a=='e') || (a=='I') || (a=='i') || (a=='O') || (a=='o') || (a=='U') || (a=='u'))
    cout << a << " è una vocale" << endl;
    else cout << a << " è una consonante" << endl;
    }