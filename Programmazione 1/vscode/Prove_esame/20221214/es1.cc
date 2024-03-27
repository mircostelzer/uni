#include <iostream>
#include <fstream>

using namespace std;

int strlen(char *s) {
    int res = 0;
    while (*s != '\0') {
        res++;
        s++;
    }

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
    fout.open(argv[2], ios::out);
    if (fin.fail() || fout.fail()) {
        cout << "Errore nell'apertura di un file\n";
        exit(1);
    }

    char string[101];
    fin >> string;
    if (string[0]>='a' && string[0]<='z') {
        string[0] = string[0] - 'a' + 'A';
    }
    fout << string << " ";

    bool toUpper = false;

    while (fin >> string) {
        if (toUpper) {
            if (string[0]>='a' && string[0]<='z') {
                string[0] = string[0] - 'a' + 'A';
            }    
            toUpper = false;   
        }
        int l = strlen(string);
        if (string[l-1] == '.' || string[l-1] == '?' || string[l-1] == '!') {
            toUpper = true;
        }

        fout << string << " ";
    }

    fin.close();
    fout.close();
    return 0;
}