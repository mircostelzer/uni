#include <iostream>
using namespace std;

int main()
{
    int i = 1, a = 0, b = 1;
    do {
        cout << a << " ";
        b += a;
        cout << b << " ";
        a += b;
        i++;
    }
    while (i<=10);
}