#include <iostream>
using namespace std;

int main()
{
    int i, a = 0, b = 1;
    cout << 0 << " " << 1 << " ";
    for (i=2;i<=10;i++) {
        a +=b;
        cout << a << " ";
        b +=a;
        cout << b << " ";
    }
}