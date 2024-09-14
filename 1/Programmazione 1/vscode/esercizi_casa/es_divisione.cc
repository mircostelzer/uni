#include <iostream>
using namespace std;

int main()
{
    int d, D, Q, R;

    cout << "Inserisci un dividendo: ";

    cin >> d;

    cout << "Inserisci un divisore: ";

    cin >> D;

    Q = d/D;

    R = d-(D*Q);

    cout << "Il risultato dell'operazione è " << Q << " con resto di " << R << endl;

    return 0;
}