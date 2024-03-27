#include <iostream>
#include <fstream>

using namespace std;

const int MAX_STRING = 128;
const int MAX_BIN = 8;
const int MAX_ADD = 13;

int somma(int *a, int n);
void elaborariga(char *str, int *num, int &ris);
int converti(int *b, int n);
int pow(int b, int e);


int main()
{
    fstream fin, fout;
    fin.open("inputdati.txt", ios::in);
    fout.open("outputcheck.txt", ios::out);
    if (fin.fail() || fout.fail()) {
        cout << "Errore nell'apertura di un file\n";
        exit(1);
    }

    char string[MAX_STRING];
    while (!fin.eof()) {
        fin >> string;
        int num[MAX_ADD] = {0};
        int ris = 0;
        elaborariga(string, num, ris);
        int sum = somma(num, MAX_ADD);
        if (ris == sum) {
            fout << ris << '\n';
        }
        else {
            fout << "Errore" << '\n';
        }

    }

    fin.close();
    fout.close();
    return 0;
}


int pow(int b, int e) {
    int res = 1;
    int i = 0;
    while (i < e) {
        res *= b;
        i++;
    }

    return res;
}

void elaborariga(char *str, int *num, int &ris) {
    int i = 0;
    int add = 0;
    int bin[MAX_BIN] = {0};
    while (str[i]!='\0') {
        int l = 0;
        while (str[i]!='+' && str[i]!='=' && str[i]!=';') {
            bin[l] = str[i] - '0';
            l++;
            i++;
        }
        if (str[i]=='+' || str[i]=='=') {
            int dec = converti(bin, l);
            num[add] = dec;
            add++;
        }
        else {
            ris = converti(bin, l);
        }
        i++;
    }
}

int converti(int *b, int n) {
    int res = 0;
    for (int i=n-1, esp=0; i>=0; i--, esp++) {
        res += (pow(2, esp) * b[i]);
    }

    return res;
}

int somma(int *a, int n) {
    int res = 0;

    for (int i=0; i<n; i++) {
        res += a[i];
    }

    return res;
}