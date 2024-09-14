#include <iostream>
#include <cmath>
#include "es_string1.h"
using namespace std;

int main()
{
    char c[dim];
    cin >> c;
    while (!checkAlpha(c)) {
        cout << "Solo caratteri alfabetici!" << endl;
        cin >> c;
    }
    cout << punteggio(c) << endl;
}