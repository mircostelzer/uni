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
void codici_aux(char **&res, int n, int start, int end, bool first, int &i) {
    if (n == 0) {
        if (i < end) {
            copy_array(res[i], res[i+1], start);
            i++;
        }
    }
    else if (first) {
        res[i][start] = '1';
        codici_aux(res, n-1, start+1, end, false, i);
        res[i][start] = '0';
        codici_aux(res, n-1, start+1, end, true, i);
    }
    else {
        res[i][start] = '0';
        codici_aux(res, n-1, start+1, end, false, i);
        res[i][start] = '1';
        codici_aux(res, n-1, start+1, end, true, i);
    }

}
// Inserire qui sopra eventuali definizioni di funzioni ausiliarie

// Inserire qui sotto la definizione della funzione codici
char **codici(int n, int &max) {
    max = 1 << n;
    char **res = new char*[max];
    for (int i=0; i<max; i++) {
        res[i] = new char[n];
    }

    int i = 0;
    codici_aux(res, n, 0, max-1, false, i);

    return res;
}
// Inserire qui sopra la definizione della funzione codici