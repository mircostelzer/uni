#include <iostream>
using namespace std;

int main()
{
    int n, i, count, div = 0;
    cout << "Inserire limite superiore: ";
    cin >> n;
    for (i=2; i<=n; i++) {
        for (count=1; count<=i; count++) {
            if (i%count==0) {
                div++;
            }
        }
        if (div==2) {
                cout << i << " ";
            }
            div = 0;
    }
    cout << endl;
}