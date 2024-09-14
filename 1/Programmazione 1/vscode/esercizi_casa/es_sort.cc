#include <iostream>
using namespace std;

void swap(int &a,int &b) {
    int c = a;
    a = b;
    b = c;
}

void sort (int &a, int &b, int &c) {
    if (a>=b) {
        swap (a,b);
    }
    if (b>=c) {
        swap (b,c);
    }
    if (a>=c) {
        swap (a,c);
    }
}

int main()
{
    int a, b, c;
    cin >> a >> b >> c;
    sort (a, b, c);
    cout << a << " " << b << " " << c << endl;
}