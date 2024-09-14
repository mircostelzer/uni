#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char *argv[])
{
    if (argc < 3) {
        cout << "Errore!" << endl;
        exit(0);
    }
    fstream fin, fout;
    fin.open(argv[1], ios::in);
    fout.open(argv[2], ios::out);
    char word[50];
    while (!fin.fail() && !fin.eof()) {
    fin.getline(word, 100);
    fout << word << endl;
    }
    fin.close();
    fout.close();
}

