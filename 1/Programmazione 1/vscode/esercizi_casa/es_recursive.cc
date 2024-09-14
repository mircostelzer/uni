#include <iostream>
using namespace std;

int pow(int a, int b) {
    int res;
    if (b==0) {
        res = 1;
    } else if (b==1) {
        res = a;
        } else while (b>1) {
        a*=a;
        b--;
    }
    return res;
}

long double sum(int i) {
    long double res;
    if (i==0) {
        res = 1;
    } else {
        res = 1/(pow(2,i)) + sum(i-1);
    }
    return res;
}

int main()
{
    int i;
    cin >> i;
    cout << sum(i) << endl;
}