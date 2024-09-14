#include <iostream>
using namespace std;

long long fib (int a) {
    long long res;
    if (a==0 || a==1) {
        res = 1;
    }
    else {
        res = fib(a-1) + fib(a-2);
    }
    return res;
}

int main()
{
    int n;
    cin >> n;
    cout << fib (n) << endl;
    return 0;
}