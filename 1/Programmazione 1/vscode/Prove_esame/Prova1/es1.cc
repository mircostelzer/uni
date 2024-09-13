#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;

const int DIM = 256;

int main(int argc, char **argv)
{
    if (argc != 3) {
        cout << "Usage: a.out <input> <output>\n";
        exit (1);
    }

    fstream fin, fout;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file di input\n";
        exit (1); 
    }

    fout.open(argv[2], ios::out);
    if (fout.fail()) {
        fin.close();
        cout << "Errore nell'apertura del file di output\n";
        exit (1);
    }

    int r;
    cout << "Inserire numero di rotazione: ";
    cin >> r;

    char string[DIM];
    while (fin >> string) {
        int l = strlen(string);
        char newstr[l+1];
        int i = 0;
        bool last = false;
        if ((string[l-1]<'a') || (string[l-1]>'z')) {
            if ((string[l-1]<'A') || (string[l-1]>'Z')) {
                last = true;
                l--;
            }
        }
        if ((string[0]<'a') || (string[0]>'z')) {
            if ((string[0]<'A') || (string[0]>'Z')) {
                newstr[0] = string[0];
                i++;
            }
        }
        while (i<l) {
            newstr[i] = string[(i+r)%l];
            i++;
        }
        if (last) {
            newstr[l] = string[l];
            newstr[l+1] = '\0';
        }
        else {
            newstr[l] = '\0';
        }

        fout << newstr << " ";
    }



    fin.close();
    fout.close();
    return 0;
}