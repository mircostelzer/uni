#include <iostream>
#include <iomanip>
#include <cstdlib>

void copy_array(char *src, char *dst, int n) {
    for (int i = 0; i < n; i++) {
        dst[i] = src[i];
    }
}

// Inserire qui la dichiarazione della funzione codici
char **codici(int n, int &max);
void codici_aux(int n, int max, int i, int count, char **&res, int first, int &last);
// Inserire qui sopra la dichiarazione della funzione codici_aux

// NON MODIFICARE IL MAIN
int main(int argc, char **argv) {
    if (argc != 2) {
        std::cout << "Usage: " << argv[0] << " #num" << std::endl;
        exit(1);
    }
    int nb = atoi(argv[1]);

    int max;
    char **res = codici(nb, max);

    std::cout << "Grey codes for " << nb << " bits:" << std::endl;
    for (int i = 0; i < max; i++) {
        std::cout << std::setw(3) << i << ": ";
        for (int j = 0; j < nb; j++) {
            std::cout << res[i][j];
        }
        delete [] res[i];
        std::cout << std::endl;
    }
    delete [] res;
    return 0;
}
// NON MODIFICARE IL MAIN

// Inserire qui sotto eventuali definizioni di funzioni ausiliarie
char **codici(int n, int &max) {
    max = 1 << n;
    char **res = new char*[max];
    for (int i=0; i<max; i++) {
        res[i] = new char[n];
    }
    int last = 2;
    int count = n-1;
    codici_aux(n, max, 0, count, res, 0, last);

    return res;
}

void codici_aux(int n, int max, int i, int count, char **&res, int first, int &last) {
    if(count > 0) {
        if (last==2) {
            res[0][n-1] = '0';
            res[1][n-1] = '1';
            last*=2;
            codici_aux(n, max, i, count, res, first, last);
        }
        else if (first!=(last/2)) {
            if (i+count != n) {
            res[last-first-1][n-i-1] = res[first][n-i-1];
            codici_aux(n, max, i+1, count, res, first, last);
            }
            else {
            res[last-first-1][n-i-1] = '1';
            res[first][n-i-1] = '0';
            codici_aux(n, max, 0, count, res, first+1, last);
            }
        }
        else if (first==(last/2)) {
            last*=2;
            codici_aux(n, max, 0, count-1, res, 0, last);
        }
    }
}
// Inserire qui sopra eventuali definizioni di funzioni ausiliarie

// Inserire qui sotto la definizione della funzione codici

// Inserire qui sopra la definizione della funzione codici