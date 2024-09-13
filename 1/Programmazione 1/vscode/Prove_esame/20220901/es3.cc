#include <iostream>
#include <string.h> // definisce la funzione "int strlen (const char * array);"
#include <math.h>   // definisce la funzione "int pow (base, esponente);"
#include "pila.h"   // fare riferimento al file "pila.h" per le funzioni esposte

using namespace std;

int decodificaNumero(char numeroCodificato []);

int main() { 
    int dimensioneMassima = 9;
    char numeroCodificato [dimensioneMassima];
    cout << "Inserisci l'array: ";
    cin >> numeroCodificato;
    int decodifica = decodificaNumero(numeroCodificato);
    cout << "Decodifica: " << decodifica << endl;
}

int decodificaNumero(char numeroCodificato []) {
    // Scrivere il codice qui
    init();
    int num = 0;
    int l = strlen(numeroCodificato);
    int esp = l;
    for (int i=0; i<=l; i++) {
        push(i+1);
        if ((numeroCodificato[i] == 'I') || (i == l)) {
            int x;
            while (top(x)) {
                num += (x*pow(10, esp));
                esp--;
                pop();
            }
        }
    }

    deinit();
    return num;
    // Potete assumere che l'array rispetti le assunzioni
    // dell'esercizio (non serve fare controlli sull'input)
}