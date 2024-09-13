#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

int main(int argc, char * argv [])
{
    if (argc != 3) {
        cout << "Usage: a.out <input> <output>\n";
        exit (1);
    }
    fstream fin, fout;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file di input\n";
        exit (1);
    }
    fout.open(argv[2], ios::out);
    if (fout.fail()) {
        fin.close();
        cout << "Errore nell'apertura del file di output\n";
        exit (1);
    }
    char ch;
    bool toUpper = true;
    while (fin.get(ch)) {
        fin >> noskipws;
        if (toUpper) {
            if ((ch>= 'a') && (ch<= 'z')) {
                ch = ch - 'a' + 'A';
                toUpper = false;
            }
            else if (ch == ' ' || ch == '\n') { toUpper = true; }
            else { toUpper = false; }
        }
        else {
            if (ch == '.' || ch == '?' || ch == '!') {
                toUpper = true;
            }
            else { toUpper = false; }
        }
        fout << ch;
    }

    fin.close();
    fout.close();
  return 0;
}