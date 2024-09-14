#include <iostream>
using namespace std;

int main()
{
    int a, b;
    cout << "Inserire due valori: ";
    cin >> a >> b;
    bool uguali =  (!(a>b) && !(b>a)); // bool diversi = a^b, uguali = !diversi 
    cout << uguali << endl;
}