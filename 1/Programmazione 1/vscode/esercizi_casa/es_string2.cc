#include <iostream>
#include <fstream>
using namespace std;

int main(int argc, char *argv[])
{
    if (argc < 2) {
        cout << "Errore!" << endl;
        exit(0);
    }
    fstream fin;
    fin.open(argv[1], ios::in);
    char word[50];
    while (!fin.fail() && !fin.eof()) {
    fin.getline(word, 100);
    cout << word << endl;
    }
    fin.close();
}

