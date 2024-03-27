#include <iostream>
#include <cstdlib>
#include "coda.h"

using namespace std;

int trovaIlVincitore(int n, int k);

int main(int argc, char * argv[]) {

    if (argc != 3) {
        cerr << "Usage: a./out <numeroDiAmici> <numeroDiSalti>" << endl;
        exit(0);
    }

    cout << "Il vincitore e' l'amico numero " << trovaIlVincitore(atoi(argv[1]), atoi(argv[2])) << endl;
}


// Implementare la funzione sottostante come da consegna:
// - 'numeroDiAmici' è il numero di amici, o anche chiamato 'n'
// - 'numeroDiSalti' è il numero di salti, o anche chiamato 'k' 
int trovaIlVincitore(int numeroDiAmici, int numeroDiSalti) {
    init();
    int n;
    for (int i=1; i<=numeroDiAmici; i++) {
        enqueue(i);
    }
    for (int j=0; j<numeroDiAmici; j++) {
        for (int i=0; i<numeroDiSalti; i++) {
            first(n);
            dequeue();
            enqueue(n);
        }
        dequeue();
    }
    first(n);
    deinit();

    return n;
}