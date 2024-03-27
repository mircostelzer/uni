#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

const int DIM = 101;

int main(int argc, char **argv)
{
    if (argc != 4) {
        cout << "Usage: a.out <input1> <input2> <output>\n";
        exit (1);
    }

    fstream fin1, fin2, fout;
    fin1.open(argv[1], ios::in);
    fin2.open(argv[2], ios::in);
    if (fin1.fail() || fin2.fail())  {
        cout << "Errore nell'apertura del file di input\n";
        exit (1); 
    }

    fout.open(argv[3], ios::out);
    if (fout.fail()) {
        fin1.close();
        fin2.close();
        cout << "Errore nell'apertura del file di output\n";
        exit (1);
    }


    char string[DIM];
    fin1 >> string;
    int n_words = atoi(string);
    char words[n_words][DIM];
    int i = 0;

    while (fin1 >> string) {
        strcpy(words[i], string);
        i++;
    }
    fin1.close();


    while (fin2 >> string) {
        int n = atoi(string);
        if (n>=0 && n<n_words) {
            fout << words[n] << " ";
        }
        else {
            fout << "MISSING ";
        }
    }

    fin2.close();
    fout.close();

    return 0;
}