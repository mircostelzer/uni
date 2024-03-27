#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

void shift(char *string, int shifting) {
    for (int i=0; string[i]!='\0'; i++) {
        if (string[i]>='A' && string[i]<='Z') {
            string[i] = string[i] + 'a' - 'A';
        }
    }
    int l = strlen(string);
    for (int i=0; i<shifting; i++) {
        char tmp = string[l-1];
        for (int j=(l-1); j>0; j--) {
            string[j] = string[j-1];
        }
        string[0] = tmp;
    }
}

/*char *shift(char *string, char *res,  int shifting) {
    for (int i=0; string[i]!='\0'; i++) {
        if (string[i]>='A' && string[i]<='Z') {
            string[i] = string[i] + 'a' - 'A';
        }
    }
    int l = strlen(string);
    int s = shifting;
    for (int i=0; i<l; i++, s++) {
        res[s%l] = string[i];
    }
    res[l] = '\0';

    return res;
}*/

int main(int argc, char **argv)
{
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " <input>\n";
        exit(1);
    }

    fstream fin;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit(1);
    }

    char string[256];
    char buffer[256];
    int shifting;

    cout << "Inserire la stringa: ";
    cin >> string;
    cout << "Inserire il valore di shifting: ";
    cin >> shifting;

    //char *shifted = new char[256];
    //shifted = shift(string, shifted, shifting);

    shift(string, shifting);
    cout << string << '\n';

    int counter = 0;
    while (fin >> buffer) {
        for (int i=0; buffer[i]!='\0'; i++) {
                bool cond = true;
                for (int j=0; string[j]!='\0' && cond; j++) {
                    if (buffer[i+j]!=string[j]) {
                        cond = false;
                    }
                }
                if (cond) {counter++;}
        }
    }

    cout << "La stringa compare " << counter << " volte\n";

    //delete[] shifted;
    fin.close();

    return 0;

}