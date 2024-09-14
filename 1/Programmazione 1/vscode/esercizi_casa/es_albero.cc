#include <iostream>
using namespace std;

int main()
{
    int h, i, j;
    cout << "Inserisci un'altezza: ";
    cin >> h;
    for (i=1; i<=h; i++) {
        int riga = i*2 - 1;
        for (j=1; j<=h-i; j++) {
            cout << " ";
        }
        for (int j=1; j<=riga; j++) {
            cout << '*';
        }
        cout << endl;
    }
}

