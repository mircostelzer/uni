#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

const int DIM = 256;

int main(int argc, char **argv)
{
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " input.txt\n";
        exit(1);
    }

    fstream fin;
    fin.open("input.txt", ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file di input\n";
        exit(1);
    }

    char string[DIM];
    cout << "Inserire la stringa da cercare: ";
    cin >> string;

    char input[DIM];
    while (fin >> input) {
        bool match = true;
        int i = 0;
        if (strlen(string) != strlen(input)) {
            match = false;
        }
        while (match && string[i]!='\0') {
            if (string[i] == '*') {
                i++;
            }
            else if (input[i] != string[i]) {
                match = false;
            }
            else {
                i++;
            }
        }
        if (match) {
            cout << input << '\n';
        }
    }

    fin.close();
    return 0;
}