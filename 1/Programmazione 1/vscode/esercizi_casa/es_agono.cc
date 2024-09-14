#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    float L, S = sqrt(3), P , A;
    cout << "Inserire una lunghezza: ";
    cin >> L;
    P = L*6;
    A = (3.0/2.0)*L*L*S;
    cout << "Il perimetro dell'esagono misura: " << P << endl << "L'area dell'esagono misura: " << A << endl;

}