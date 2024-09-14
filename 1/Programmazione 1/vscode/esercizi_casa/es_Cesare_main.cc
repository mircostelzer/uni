#include <iostream>
#include <fstream>
#include "es_Cesare.h"
using namespace std;


int main(int argc, char * argv[])
{
    char file1[256],file2[256], parola[50], choice;
    int chiave;
    cout << "File da cui leggere: ";
    cin >> file1;
    fstream fin, fout;
    cout << "File su cui cifrare: ";
    cin >> file2;
    fin.open(file1, ios::in);
    fout.open(file2, ios::out);
    if (fin.fail()) {
        cerr << "Errore" << '\n';
        exit(0);
    }
    else {
        cout << "Vuoi cifrare o decifrare? [c/d]" << '\n';
        cin >> choice;
        cout << "Chiave?" << '\n';
        cin >> chiave;
        while (!fin.eof()) {
            if (choice == 'c') {
            fin >> parola;
            crypt(parola, (chiave%26));
            fout << parola << " ";
        }
        if (choice == 'd') {
            fin >> parola;
            decrypt(parola, (chiave%26));
            fout << parola << " ";
        }
        }
    }
    fin.close();
    fout.close();
}