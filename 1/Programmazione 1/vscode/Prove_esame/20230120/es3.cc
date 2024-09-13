#include <iostream>
#include "pila.h"

using namespace std;

int * collidiAsteroidi(int asteroidi[], int numeroAsteroidi, int & numeroAsteroidiRimasti);

int main() {
    
    // Potete modificare l'array di asteroidi (e la sua
    // dimensione) per testare la vostra soluzione
    int asteroidi [] = {-6, 10, 5, 8, -9};
    int numeroAsteroidi = 5;


    int numeroAsteroidiRimasti;
    int * asteroidiRimasti = collidiAsteroidi(asteroidi, numeroAsteroidi, numeroAsteroidiRimasti);


    // La stampa dell'array dinamico degli
    // asteroidi rimasti avviene nel main
    for (int i = 0; i < numeroAsteroidiRimasti ; i++) {
        cout << asteroidiRimasti[i] << " ";
    }
    cout << endl;

    // La deallocazione dell'array dinamico 
    // degli asteroidi rimasti avviene nel main
    delete[] asteroidiRimasti;
}


// Implementare la funzione sottostante come da consegna:
// - ritornare un'array di interi allocato dinamicamente che 
//   contenga lo stato degli asteroidi dopo tutte le collisioni
// - assegnare a 'numeroAsteroidiRimasti' il numero di elementi 
//   nell'array ritornato
int * collidiAsteroidi(int asteroidi[], int numeroAsteroidi, int & numeroAsteroidiRimasti) {
    init();
    numeroAsteroidiRimasti = numeroAsteroidi;
    int n;
    for (int i=0; i<numeroAsteroidi; i++) {
        if (asteroidi[i]>0 || vuota()) {
            push(asteroidi[i]);
        }
        else {
            asteroidi[i] = -asteroidi[i];
            top(n);
            while (!vuota() && n>0 && n<asteroidi[i]) {
                numeroAsteroidiRimasti--;
                pop();
                top(n);
            }
            if (!vuota() && n == asteroidi[i]) {
                pop();
                numeroAsteroidiRimasti -= 2;
            }
            else {
                if (vuota() || n < 0) {
                    push(-asteroidi[i]);
                }
                else { numeroAsteroidiRimasti--; }
            }
        }
    }
    int tmp = numeroAsteroidiRimasti - 1;
    int * asteroidiRimasti = new int [numeroAsteroidiRimasti];
    while (top(n)) {
        asteroidiRimasti[tmp] = n;
        pop();
        tmp--;
    }
    deinit();

    return asteroidiRimasti;
}