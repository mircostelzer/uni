#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

int main(int argc, char **argv)
{
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " <input>\n";
        exit(1);
    }

    fstream fin;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit(1);
    }

    char string[256];
    char ch;

    cout << "Inserire la sequenza di caratteri: ";
    cin.getline(string, 256);

    int l = strlen(string);

    while (fin.get(ch)) {
        bool match = false;
        for (int i=0; i<l; i++) {
            char curr = string[i];
            if (curr>='A' && curr<='Z') {
                if (ch == curr) {
                    match = true;
                }
                else if (ch>='a' && ch<='z') {
                    if (ch == (curr - 'A' + 'a')) {
                        match = true;
                    }
                }
            }
            else if (curr>='a' && curr<='z') {
                    if (ch == curr) {
                        match = true;
                    }
                    else if (ch>='A' && ch<='Z') {
                        if (ch == (curr - 'a' + 'A')) {
                            match = true;
                        }
                    }
            }
            else if (ch == curr) {
                match = true;
            }
        }
        if (match) {
            cout << ch;
        }
    }
    cout << '\n';

    fin.close();
    return 0;
}