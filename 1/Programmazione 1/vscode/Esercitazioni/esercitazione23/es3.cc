#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

bool findString(char file[], char string[]) {
    bool found = false;
    fstream fin;
    fin.open(file, ios::in);
    if (fin.fail()) {
        cout << "Errore mell'apertura del file\n";
        exit (1);
    }
    char buffer[100];
    while (fin >> buffer && !found) {
        if (strstr(buffer, string)!=NULL) {
            found = true;
        }
    }
    return found;
}

int main(int argc, char *argv[])
{
    if (argc != 3) {
        cout << "Usage: a.out <file> <string>\n";
        exit (1);
    }
    if (findString(argv[1], argv[2])) {
        cout << "Esiste almeno un'occorrenza della stringa\n";
    }
    else {
        cout << "La stringa non compare nel testo\n";
    }
    return 0;

}