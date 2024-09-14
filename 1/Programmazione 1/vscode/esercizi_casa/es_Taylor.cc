#include <iostream>
#include <cmath>
using namespace std;

long long fact(int a) {
    long long fatt=1;
    for (int i=1; i<=a; i++) {
        fatt *= i;
    }
    return fatt;
}

int main ()
{
    cout << "Inserire x ed N: ";
    float x, N;
    cin >> x >> N;
    float ex = 0;
    for (int i=0; i<=N; i++) {
        ex+= (pow(x, i)/ fact(i));
    }
    cout << "e^x= " << ex << endl;
}