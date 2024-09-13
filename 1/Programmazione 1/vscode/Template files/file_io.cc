#include <iostream>
#include <fstream>
using namespace std;

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

    fin.close();
    fout.close();

    return 0;
}