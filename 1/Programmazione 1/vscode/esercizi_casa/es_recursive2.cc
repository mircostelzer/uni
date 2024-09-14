#include <iostream>
using namespace std;



int Hailstone(int n) {
    int res;
    if (n==1) {
        res = 1;
    }
    else if ((n%2)==0) {
        res = (Hailstone(n))/2;
    }
    else {res = 3*(Hailstone(n))+1;}
    return res;
}

void printHailstone(int n) {
    do {
        cout << n << " ";
        n = Hailstone(n);
    }
    while (n!=1);
}


int main()
{
    int n;
    cin >> n;
    //printHailstone(n);
    cout << Hailstone(n) << endl;
    return 0;
}