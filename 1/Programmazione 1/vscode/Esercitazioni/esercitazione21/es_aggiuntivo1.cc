#include <iostream>
#include <fstream>
using namespace std;

/* Scrivere un programma che, presi i nomi di due file da linea di
comando, copi il primo file nel secondo correggendone la sintassi.
Affinché un testo possa essere considerato corretto, la prima parola del
testo e tutte le parole dopo i caratteri “.”, “?” e “!” devono iniziare con
una lettera maiuscola.
Potete usare la libreria <fstream>.
Inoltre potete scrivere “input >> noskipws;” per impedire
all’operatore “>>” di skippare spazi bianchi e nuove linee */

int main(int argc, char *argv[])
{
    if (argc != 3) {
        cerr << "Usage: a.out <file1> <file2>\n";
        exit (0); 
    }
    fstream fin, fout;
    fin.open(argv[1], ios::in);
    fout.open(argv[2], ios::out);
    if (fin.fail() || fout.fail()) {
        cerr << "Errore nell'apertura di un file\n";
        exit(0);
    }
    char ch;
    bool toUpper = true;
    while (fin.get(ch)) {
        fin >> noskipws;
        if (toUpper) {
                if (ch>='a' && ch<='z') {
                    ch = ch -'a' + 'A';
                    toUpper = false;
                }
        } 
        if (!toUpper) {
                if (ch=='.' || ch=='?' || ch=='!') {
                    toUpper = true;
                }
                else {
                    toUpper = false;
                }
            }
        fout << ch;
    }
    fin.close();
    fout.close();
}