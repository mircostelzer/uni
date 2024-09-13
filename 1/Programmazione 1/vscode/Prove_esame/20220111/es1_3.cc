#include <iostream>
#include <fstream>
#include <cstring>
#include <cmath>
using namespace std;

int result(char op1[], char op2[], char op) {
    int res = 0;
    double Iop1 = 0;
    double Iop2 = 0;
    int l1 = strlen(op1);
    int l2 = strlen(op2);
    for (int i=0; i<l1; i++) {
        int n;
        if (op1[i]>='0' && op1[i]<='9') {
            n = op1[i] - '0';
        }
        else if (op1[i]>='A' && op1[i]<='G') {
            n = op1[i] -'A' + 10;
        }
        n = pow(17, l1-i-1) * n;
        Iop1 += n;
    }                                   
    for (int i=0; i<l2; i++) {
        int n;
        if (op2[i]>='0' && op2[i]<='9') {
            n = op2[i] - '0';
        }
        else if (op2[i]>='A' && op2[i]<='G') {
            n = op2[i] -'A' + 10;
        }
        n = pow(17, l2-i-1) * n;
        Iop2 += n;
    }
    
switch (op) {
    case '+': {
        res = Iop1 + Iop2;
    } break;
    case '*': {
        res = Iop1 * Iop2;
    } break;
    case '^': {
        res = pow(Iop1, Iop2);
    } break;
}

    return res;
}

int main(int argc, char **argv)
{
    if (argc != 3) {
        cout << "Usage: a.out <input> <output>\n";
        exit(1);
    }
    fstream fin, fout;
    
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file di input\n";
        exit(1);
    }

    fout.open(argv[2], ios::out);
    if (fout.fail()) {
        fin.close();
        cout << "Errore nell'apertura del file di output\n";
        exit(1);
    }

    char op1[11], op2[11], op;
    while (fin >> op1 >> op >> op2) {
        
        fout << result(op1, op2, op) << '\n';

    }

    fin.close();
    fout.close();

    return 0;
}