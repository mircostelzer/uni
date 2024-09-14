#include <iostream>
using namespace std;

void comp(int bin) {
    int res=0, conta=0;
    while (res<=bin) {
        int molt=1;
        res+= (bin%10)*molt;
        molt*=10;
        conta++;
    }
    while (conta!=0) {
        cout << 0;
        conta--;
    }
    cout << res;
}

int main()
{
    int bin;
    cin >> bin;
    comp(bin);
    cout << endl;
    return 0;
}