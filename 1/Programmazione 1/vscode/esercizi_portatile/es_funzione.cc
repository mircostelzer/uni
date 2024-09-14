#include <iostream>
#include <cmath>
using namespace std;

float function(float x) {
    if (x<=0) {
        x= -(pow(x,3));
    }
    else {
        x= exp(x-1);
    }
    return x;
}

int main()
{
    float x;
    for (x=-10; x<=10; x++) {
    cout << "f(x)= " << function(x) << endl;
    }
}