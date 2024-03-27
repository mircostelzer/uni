#include <iostream>
#include <fstream>

int strlen(char *s) {
    int res = 0;
    while (*s!='\0') {
        res++;
        s++;
    }
    return res;
}

using namespace std;

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
        cout << "Errore nell'apertura dei file\n";
        exit(1);
    }

    char string[50];
    bool toUpper = false;

    fin >> string;
    string[0] = string[0] - 'a' + 'A';
    fout << string << " ";

    while (fin >> string) {
        int l = strlen(string);
        if (toUpper) {
            if ((string[0]>='a') && (string[0]<='z')) {
                string[0] = string[0] - 'a' + 'A';
            }
            toUpper = false;
        }
        if (string[l-1] == '.' || string[l-1] == '!' || string[l-1] == '?') {
            toUpper = true;
        }
        fout << string << " ";

    }
 
    fin.close();
    fout.close();
    return 0;
}