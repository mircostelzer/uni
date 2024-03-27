#include "stack.h"
#include <iostream>
#include <fstream>
using namespace std;

void invert(char file1[], char file2[]) {
    stack s1;
    init(s1);
    fstream fin, fout;
    fin.open(file1, ios::in);
    if (fin.fail()) {
        cerr << "Errore in apertura" << endl;
        exit (0);
    }
    int num;
    while (fin >> num) {
        push(s1, num);
    }
    fin.close();
    fout.open(file2, ios::out);
    if (fout.fail()) {
        cerr << "Errore in apertura" << endl;
        exit (0);
    }
    while (s1!=NULL) {
        int num;
        top(s1, num);
        pop(s1);
        fout << num << endl;
    }
    deinit(s1);
    fout.close();
}

int main(int argc, char *argv[])
{
    if (argc != 3) {
        cout << "Usage a.out <file1> <file2>" << endl;
        exit (0);
    }
    invert(argv[1], argv[2]);

}
