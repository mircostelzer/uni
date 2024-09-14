#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char *argv[])
{
    if (argc < 3) {
        cout << "Errore!" << endl;
        exit(0);
    }
    fstream fin;
    fin.open(argv[1], ios::in);
    char c, d=argv[2][0];
    while (!fin.fail() && !fin.eof()) {
    fin.get(c);
    if (c==d) {
        cout << "?";
    }
    else {
        cout.put(c);
    }
    }
    cout << endl;
    fin.close();
}

