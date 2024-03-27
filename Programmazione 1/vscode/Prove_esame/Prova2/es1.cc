#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

int main(int argc, char *argv[])
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
    char buffer[256];

    cout << "Inserire la stringa da cercare: ";
    cin >> string;

    int Nstars = 0;

    int l = strlen(string);
    for (int i=0; i<l; i++) {
        if (string[i] == '*') {
            Nstars++;
        }
    }

    while (fin >> buffer) {
        int tmp = 0;
        char stars[Nstars];
        bool match = true;
        int l1 = strlen(buffer);
        if ( l1 != l) {
            match = false;
        }
        for (int i=0; i<l && match; i++) {
            if (string[i] == '*') {
                stars[tmp] = buffer[i];
                for (int j=0; j<tmp; j++) {
                    if (buffer[i] == stars[j]) {
                        match = false;
                    }
                }
                tmp++;
            }
            else {
                if (buffer[i] != string[i]) {
                    match = false;
                }
            }
        }
        if (match) {
            cout << buffer << '\n';
        }
    }

    fin.close();

    return 0;
}