#include <iostream>
#include <fstream>
#include <cmath>
#include <cstring>

using namespace std;

int main(int argc, char **argv)
{
    if (argc != 3) {
        cout << "Usage: " << argv[0] << " <input> <output>\n";
        exit(1);
    }

    fstream fin, fout;
    fin.open(argv[1], ios::in);
    fout.open(argv[2], ios::out);
    if (fin.fail() || fout.fail()) {
        cout << "Errore nell'apertura di un file\n";
        exit(1);
    }


    while (!fin.eof()) {
        char num1[11];
        fin >> num1;
        int n1 = 0;
        int l1 = strlen(num1);
        for (int i=l1-1, j=0; i>=0; i--, j++) {
            if (num1[i]>= '0' && num1[i]<='9') {
                num1[i] -= '0';
            }
            else {
                num1[i] = num1[i] - 'A' + 10;
            }
            n1 += (num1[i] * pow(17, j));
        }
        char op;
        fin >> op;
        
        char num2[11];
        fin >> num2;
        int n2 = 0;
        int l2 = strlen(num2);
        for (int i=l2-1, j=0; i>=0; i--, j++) {
            if (num2[i]>= '0' && num2[i]<='9') {
                num2[i] -= '0';
            }
            else {
                num2[i] = num2[i] - 'A' + 10 ;
            }
            n2 += (num2[i] * pow(17, j));
        }

        switch(op) {
            case '+':
                fout << n1 + n2 << '\n';
                break;
            case '*':
                fout << n1 * n2 << '\n';
                break;
            case '^':
                fout << pow(n1, n2) << '\n';
        }


    }

    fin.close();
    fout.close();
    return 0;
}