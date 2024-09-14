#include <iostream>
using namespace std;

int main()
{
    int a, n, i, p=1;
    cin >> a >> n;
    for (i=1; i<=(n-1); i++) {
        p*=a;
        cout << p << " ";
    }
}