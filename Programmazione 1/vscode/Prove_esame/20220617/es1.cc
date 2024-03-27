#include <iostream>
#include <fstream>
#include <cstring>

using namespace std;


int main(int argc, char **argv)
{
    if (argc != 4) {
        cout << "Usage: " << argv[0] << " <input1> <input2> <output>\n";
        exit(1);
    }

    fstream fin1, fin2, fout;
    fin1.open(argv[1], ios::in);
    fin2.open(argv[2], ios::in);
    fout.open(argv[3], ios::out);

    if (fin1.fail() || fin2.fail() || fout.fail()) {
        cout << "Errore nell'apertura di un file\n";
        exit(1);
    }

    char string[101];
    int num;

    fin1 >> string;
    num = atoi(string);
    char words[num][101];

    for (int i=0; i<num; i++) {
        fin1 >> string;
        strcpy(words[i], string);
    }

    int n;
    while (fin2 >> n) {
        if (n>=0 && n<num) {
            fout << words[n] << " ";
        }
        else {
            fout << "MISSING ";
        }
    }


    fin1.close();
    fin2.close();
    fout.close();

}