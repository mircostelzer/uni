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

void strcpy(char *s, char *d) {
    int i = 0;
    while (s[i] != '\0') {
        d[i] = s[i];
        i++;
    }
    d[i] = '\0';
}

int main(int argc, char *argv[])
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
    
    char buffer[256];
    char maxl[256] = {};
    int maxl_size = 0;

    fin.getline(buffer, 255);
    strcpy(buffer, maxl);
    maxl_size = strlen(buffer);
    fout << maxl_size << endl;

    while (fin.getline(buffer, 255)) {
        int l = strlen(buffer);
        fout << l << endl;
        if (l > maxl_size) {
            strcpy(buffer, maxl);
            maxl_size = l;
        }
    }
    fout << maxl << " " << maxl_size;

    fin.close();
    fout.close();

    return 0;
}