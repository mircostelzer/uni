#include <iostream>
#include <cctype>
using namespace std;

int main()
{
    char lettera;
    cout << "Inserire una lettera: ";
    cin >> lettera;
    if (isalpha(lettera)) {
        if (islower(lettera)) {
            cout << lettera << " -> " << char(toupper(lettera)) << endl;
        } else cout << lettera << " è una lettera maiuscola" << endl;
    } else cout << lettera << " non è una lettera" << endl;

}

