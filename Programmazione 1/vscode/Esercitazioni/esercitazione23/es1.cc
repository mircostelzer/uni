#include <iostream>
#include <fstream>
using namespace std;

int sniffer(char file[]) {
    int res = 0;
    fstream fin;
    fin.open(file, ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit (1);
    }
    int count = 0;
    char string[100];
    while (fin >> string) {
        int i = 0;
        if (string[0]>='0' && string[0]<='9') {
            bool isNum = true;
            while (isNum && string[i]!='\0') {
                if (string[i]>='0' && string[i]<='9') {
                    isNum = true;
                    i++;
                }
                else { isNum = false; }
                
            }
            if (i==4) {
                count++;
            }
        }
        else {
            count = 0;
        }
        if (count == 4) {
            res++;
            count = 0;
        }
    }
    return res;
}

int main(int argc, char *argv[])
{
    if (argc != 2) {
        cout << "Usage: a.out <file>\n";
        exit (1);
    }
    int n = sniffer(argv[1]);
    cout << "Il numero di stringhe trovate compatibili con il formato richiesto è " << n << endl;
    return 0;
}