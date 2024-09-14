#include <iostream>
using namespace std;

int main()
{
    int b;
    cout << "Inserire un numero binario: ";
    int potenza_2 = 1, decimale = 0;
    cin >> b;
    while (b!=0) {
        decimale = decimale + ((b%10) * potenza_2);
        potenza_2*=2;
        b/=10;
    }    
    cout << decimale << endl;
}