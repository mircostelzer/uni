#include<iostream>
using namespace std;

int main()
{
    char a = 'a', b;
    a++;
    cout << "a = " << a << endl;
    a += 5;
    cout << "a = " << a << endl;
    cin >> b;
    if ((b >= 'a') && (b <= 'z'))
    cout << b << " è una lettera minuscola"<< endl;
    if ((b >= 'A') && (b <= 'Z'))
    cout << b << " è una lettera maiuscola" << endl;

}