#include <iostream>
#include <fstream>

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
        cout << "Errore nell'apertura dei file\n";
        exit(1);
    }

    char line[256];
    int max = 0;
    int i = 0;
    int i_max;

    while (!fin.eof()) {
        fin.getline(line, 255);
        int l = 0;
        while (line[l]!='\0') {
            l++;
        }
        fout << l << '\n';
        
        if (l > max) {
            max = l;
            i_max = i;
        }
        i++;
    }
    fin.close();

    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit(1);
    }

    for (int j=0; j<=i_max; j++) {
        fin.getline(line, 255);
    }

    fout << line << '\n';

    fin.close();
    fout.close();
    return 0;
}