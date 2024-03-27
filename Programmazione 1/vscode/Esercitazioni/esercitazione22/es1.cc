#include <iostream>
#include <fstream>
using namespace std;

void media(char file[]) {
    fstream append;
    append.open(file, ios::in);
    if (append.fail()) {
        cerr << "Errore nell'apertura del file\n";
        exit (0);
    }
    else {
        char word[11];
        int res = 0;
        int count = 0;
        while (append >> word) {
            for (int i=0; word[i]!='\0'; i++) {
                res++;
            }
            count++;
        }
        append.close();
        append.open(file, ios::out|ios::app);
        if (append.fail()) {
            "Errore nell'apertura del file\n";
            exit (0);
        }
        else {
            append << '\n';
            for (int i=0; i<(res/count); i++) {
                append << '*';
            }
        }
    }
    append.close();
}

int main(int argc, char *argv[])
{
    if (argc != 2) {
        cout << "Usage: a.out <file>\n";
        exit (0);
    }
    else {
        media(argv[1]);
    }
    return 0;
}