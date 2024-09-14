#include <iostream>
using namespace std;

struct complex {
    int re;
    int im;
    char i;
};

int main()
{
    complex n;
    complex* pn = &n;
    pn -> re=4;
    n.im = 3;
    cout << pn -> re << " " << n.im << n.i << endl;
}