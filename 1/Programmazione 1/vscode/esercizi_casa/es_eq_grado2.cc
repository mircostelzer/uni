#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    float a, b, c, delta;
    cout << "Inserire tre parametri: ";
    cin >> a >> b >> c;
    delta = b*b - (4*a*c);
    if (delta>=0) {
        double x1 = (-b + sqrt(delta))/(2*a);
        double x2 = (-b - sqrt(delta))/(2*a);
        cout << "x1= " << x1 << endl << "x2= " << x2 << endl;
    }
    else {
        cout << "x1= " << -b/(2*a) << " + " << sqrt (-(delta)) << "i" << endl;
        cout << "x2= " << -b/(2*a) << " - " << sqrt (-(delta)) << "i" << endl;
    }
}