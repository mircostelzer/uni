#include <iostream>
using namespace std;

void swap(double &pa, double &pb) {
    double c;
    c = pa;
    pa = pb;
    pb = c;
}

int main()
{
    double x, y;
    cin >> x >> y;
    swap(x, y);
    cout << x << " " << y << endl;
}