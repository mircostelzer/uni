#include <iostream>
#include <fstream>
#include <cstring>
#include <cmath>
using namespace std;

int encode(const char *buffer) {
    int res = 0;
    int l = strlen(buffer);
    for (int i=0; i<l; i++) {
        int n;
        if (buffer[i]>=0 && buffer[i]<=9) {
            n = buffer[i] - '0';
        }
        else {
            n = buffer[i] -'a' + 10;
        }
        n = pow(36, l-1-i) *n;
        res += n;
    }
    return res;
}

void decode(int coded, char *buffer) {
    int i=0;
    while (coded!=0) {
        int m = coded % 36;
        coded = (coded - m) / 36;
        if (m<10) {
            buffer[i] = '0' + m;
        }
        else {
            buffer[i] = 'a' + m - 10;
        }
        i++;
        buffer[i] = '\0';
    }
    
    for (int j=0; j<(i/2); j++) {
        char ch = buffer[j];
        buffer[j] = buffer[i-j-1];
        buffer[i-j-1] = ch;
    }
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
    int key;
    do {
        cout << "Inserire chiave: ";
        cin >> key;
        if (cin.fail()) {
            exit (1);
        }
    }
    while (key > 9999999);
    char buffer[80];
    while (fin >> buffer) {
        buffer[4] = '\0';
        int coded = encode(buffer);
        coded += key;
        decode(coded, buffer);
        fout << buffer << " ";
    }
    fin.close();
    fout.close();

    return 0;

}