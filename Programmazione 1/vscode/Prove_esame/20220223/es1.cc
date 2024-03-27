#include <iostream>
#include <fstream>
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

    char string[101];
    char array[100][101];
    int occurences[100];

    int i = 0;

    while (fin >> string) {
        bool found = false;
        bool valid = true;
        int l = strlen(string);
        for (int j=0; j<l; j++) {
            if ((string[j]<'A') || (string[j]>'Z')) {
                valid = false;
            }
        }

        if (valid) {
            for (int j=0; j<i && !found; j++) {
                if (strcmp(array[j], string)==0) {
                    occurences[j]++;
                    found = true;
                }
            }
            
            if (!found) {
                strcpy(array[i], string);
                occurences[i] = 1;
                i++;
            }
        }

    }

    for (int j=0; j<i; j++) {
        fout << array[j] << ": " << occurences[j] << '\n';

    }

    fin.close();
    fout.close();

    return 0;
}