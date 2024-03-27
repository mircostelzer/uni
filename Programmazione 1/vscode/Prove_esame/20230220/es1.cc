#include <iostream>
#include <fstream>
#include <cstring>
#include <cmath>
using namespace std;

bool head(char *string) {
    return ((string[0]>='a' && string[0]<='z') || (string[0]>='A' && string[0]<='Z'));
}

bool tail(char *string) {
    char ch = string[strlen(string)-1];
    return ((ch>='a' && ch<='z') || (ch>='A' && ch<='Z'));
}

char *shift(char *res, char *string, int shifting) {
    int s = shifting;
    int i;
    res = new char[strlen(string)+1];
    int j;
    if (head(string)) { i = 0; }
    else { 
        i = 1;
        res[0] = string[0];
    }
    if (tail(string)) { j = strlen(string); }
    else { 
        j = strlen(string)-1;
        res[strlen(string)-1] = string[strlen(string)-1];
    }
    for (; i<j; i++, s++) {
        if (string[i]>='A' && string[i]<='Z') {
            string[i] = string[i] + 'a' - 'A';
        }
        res[i] = string[s%j];
    }
    res[strlen(string)] = '\0'; 
    return res;
}

int main(int argc, char **argv)
{
    if (argc != 3) {
        cout << "Usage: " << argv[0] << " <input> <output>\n";
        exit(1);
    }

    fstream fin, fout;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file di input\n";
        exit(1);
    }

    fout.open(argv[2], ios::out);
    if (fout.fail()) {
        fin.close();
        cout << "Errore nell'apertura del file di output\n";
        exit(1);
    }

    int shifting;
    char string[256];

    cout << "Inserire valore di shifting: ";
    cin >> shifting;

    while (fin >> string) {
        char *tmp;
        tmp = shift(tmp, string, shifting);
        fout << tmp << " ";
        delete[] tmp;
    }

    fin.close();
    fout.close();

    return 0;
}