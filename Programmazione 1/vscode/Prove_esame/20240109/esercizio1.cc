#include <iostream>
#include <fstream>
using namespace std;

void elaborariga(char *str, int *num, int &res);
int converti(int *b, int n);
int prodotto(int *a, int n);
int pow(int b, int n);

int main()
{
    fstream fin, fout;
    fin.open("inputdati.txt", ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file di input\n";
        exit (1); 
    }

    fout.open("outputcheck.txt", ios::out);
    if (fout.fail()) {
        fin.close();
        cout << "Errore nell'apertura del file di output\n";
        exit (1);
    }

    char str[128];

    while (fin >> str) {
        int num[13] = {0};
        int res = 0;
        elaborariga(str, num, res);
        if (res == prodotto(num, 13)) {
            fout << "Corretto\n"; 
        }
        else {
            fout << prodotto(num, 13) << '\n';
        }

    }

    fin.close();
    fout.close();

    return 0;
}

int pow(int b, int n) {
    int res;
    if (n==0) {
        res = 1;
    }
    else {
        res = b * pow(b, n-1);
    }
    return res;
}

void elaborariga(char *str, int *num, int &res) {
    for (int j=0; j<13; j++) {
            num[j] = 1;
        }
    int counter = 0;
    int i = 0;
    int i_t = 0;
    int tmp[8] = {0};
    char curr = str[i];
    while (curr!='\0') {
        while (curr!='=') {
            while (curr!='*') {
                tmp[i_t] = curr - '0';
                i++;
                i_t++;
            }
            num[counter] = converti(tmp, i_t);
            i++;
            counter++;
            i_t = 0;
        }
        tmp[i_t] = curr - '0';
        i++;
        i_t++;
    }
    res = converti(tmp, i_t);
}

int converti(int *b, int n) {
    int res = 0;
    for (int j=n-1, k=0; j>=0; j--, k++) {
        if (b[j]!=0) {
            res = res + pow(2, k);
        }
    }

    return res;
}

int prodotto(int *a, int n) {
    int res = 1;
    for (int i=0; i<n; i++) {
        res *= a[i];
    }

    return res;
}
