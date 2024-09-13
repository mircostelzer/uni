#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

int sniffer(char file[]) {
    int res = 0;
    fstream fin;
    fin.open(file, ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit (1);
    }
    char string[100];
    while (fin >> string) {
        int count = 0;
        int i = 0;
        bool isNum = true;
        while (string[i]!='\0') {
            while (isNum && i<4) {
                if (string[i]>='0' && string[i]<='9') {
                    i++;
                }
                else { isNum = false; } 
            }
            if (i==4 && strlen(string)==4) {
                count++;
            }
            else { count = 0; }
            i++;
        }
        if (count == 4) {
            res++;
        }
    }
    fin.close();
    return res;
}

int main(int argc, char **argv)
{
    if (argc != 3) {
        cout << "Usage: a.out <input> <output>\n";
        exit (1);
    }

    fstream fout;
    fout.open(argv[2], ios::out);
    if (fout.fail()) {
        cout << "Errore nell'apertura del file di output\n";
        exit (1);
    }

    int n = sniffer(argv[1]);
    
    fout << n;

    fout.close();

    return 0;
}