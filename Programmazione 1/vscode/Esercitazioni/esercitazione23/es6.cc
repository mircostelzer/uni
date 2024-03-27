#include <iostream>
#include <fstream>
using namespace std;

bool isAlphaNum(char ch) {
    return ((ch>='a' && ch<='z') ||
            (ch>='A' && ch<='Z') ||
            (ch>='0' && ch<='9'));
}

int Sniffer(char file[]) {
    int res = 0;
    fstream fin;
    fin.open(file, ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit (1);
    }
    char string[100];
    bool sniffer = true;
    while (fin >> string) {
            int posAt = 0;
            int dots = 0;
            int Ats = 0;
            int posDot = 0;
            int i;
        for (i=0; string[i]!='\0' && sniffer; i++) {
            if (string[i]=='@') {
                posAt = i;
                Ats++;
            }
            else if (string[i]=='.') {
                    posDot = i;
                    dots++;
                    }
            else if (!isAlphaNum(string[i])) {
                    sniffer = false;
                    }
        }
        if (posAt==0 || posAt==(i-1) || Ats!=1 || posDot==(i-1) || dots<=0) {
            sniffer = false;
        }
        if (sniffer) {
            res++;
        }
        sniffer = true;
        }
    
    return res;
}

int main(int argc, char *argv[])
{
    if (argc != 2) {
        cout << "Usage: a.out <file>\n";
        exit (1);
    }
    int n = Sniffer(argv[1]);
    cout << "Il numero di stringhe trovate compatibili con il formato richiesto è " << n << endl;
    return 0;
}