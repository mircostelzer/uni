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
bool MIU(char word[]) {
    bool isMIU = true;
    if ((word[0]=='M') && (word[strlen(word)-1]!='U')) {
        isMIU = false;
    }
    else {
        int count_I = 0;
        bool is_I;
        for (int i=0; word[i]!='\0'; i++) {
            if (word[i]=='I') {
                count_I++;
                is_I = true;
            }
            else {
                if (is_I && word[i]=='M') {
                    isMIU = false;
                }
                is_I = false;
            }
        }
        if (count_I!=0 && count_I%2==0) {
            isMIU = false;
        }
    }

    return isMIU;
}

int main(int argc, char **argv)
{
    if (argc != 3) {
        cout << "Usage: a.out <file2> <file2>\n";
        exit (1);
    }
    fstream fin, fout;
    
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file input\n";
        exit (1);
    }
    
    fout.open(argv[2], ios::out);
    if (fout.fail()) {
        fin.close();
        cout << "Erroe nell'apertura del file output\n";
        exit (1);
    }

    char word[101];
    while (fin >> word) {
        if (MIU(word)) {
            fout << word << endl;
        }
    }

    fin.close();
    fout.close();

    return 0;
}