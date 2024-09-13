#include <iostream>
#include "lista.h"

using namespace std;

const int POS_AL_SECONDO = 2;
const int DIM_COLORI = 4;
const int MAX_BAMBINI = 10;

const char* nomi[18] = {"Marco", "Luca", "Anna", "Sabrina", "Veronica", "Simone", "Mario", "Luigi", "Antonio", "Francesca", "Giovanni", "Letizia", "Lucrezia", "Carolina", "Luca", "Annalisa", "Susanna", "Licia"};
const color colori[DIM_COLORI] = {rosso, verde, blu, giallo};

// Inserire QUI sotto la dichirazione delle funzioni coloraPartecipante e cerca.
lista cerca(const lista &L, char *v);
lista coloraPartecipante(const lista &L, int k, int i);
// Inserire QUI sopra la dichirazione delle funzioni coloraPartecipante e cerca.

int main() {
    lista cerchio = NULL;
    
    unsigned int seed = time(NULL);
    // Commentare la riga sotto per non avere sempre lo stesso seed
    seed = 1703945587;
    std::cout << "Seed: " << seed << std::endl;
    srand(seed);
  

    int numero_bambini = rand() % MAX_BAMBINI + 2;
    for (int i = 0; i < numero_bambini; i++) {
        char* nome = (char*)nomi[rand() % 18];
        if (cerca(cerchio, nome) == NULL) {
            insert_in(cerchio, nome, 0);
        } else {
            i--;
        }
    }

    cout << "Ci sono " << size(cerchio) << " bambini nella lista." << endl;
    print(cerchio);

    int i = 0;
    int durata;
    bool finished = false;

    while (!empty(cerchio) && !finished) {
        cout << "-------------------------------------------------------------" << endl;
        cout << "Giro numero " << ++i << endl;
        
        cout << "La canzone durerà per " << (durata = rand() % 60 + 10) << " secondi." << endl;

        int sedia_rimossa = rand() % size(cerchio);
        cout << "Fermo il bambino alla sedia numero " << sedia_rimossa << "." << endl;

        lista eliminato = coloraPartecipante(cerchio, durata, sedia_rimossa);

        if (eliminato != NULL) {
            cout << eliminato->nome << " ha ricevuto il colore " << eliminato->colore << endl;
        } else {
            cout << "Tutti i bambini hanno un colore. Ho finito." << endl;
            finished = true;
        }
        print(cerchio);
    }

    cout << "-------------------------------------------------------------" << endl;
    cout << "Tutti i bambini hanno un colore. Ho finito." << endl;

    return 0;
}

// Inserire QUI la definizione delle funzioni coloraPartecipante e cerca.
lista cerca(const lista &L, char *v) {
    if (NULL == L) {
        return NULL;
    }
    lista l = L->next;
    while (l != L) {
        if (strcmp(l->nome, v) == 0) {
            return l;
        }
        l = l->next;
    }
    return NULL;
}

lista coloraPartecipante(const lista &L, int k, int i) {
    if (NULL == L) {
        return NULL;
    }
    lista prec = L;
    int j = 0;
    while (j<(k*POS_AL_SECONDO+i)%size(L)-1) {
        prec = prec->next;
        j++;
    } 

    color colore = colori[rand()%DIM_COLORI];
    bool colored = false;
    lista curr = prec->next;
    lista tmp = prec;
    while(curr->colore != nero && curr != prec) {
        tmp = curr;
        curr = curr->next;
    }

    if (curr == prec) {
        colored = false;
    }
    else {
        while (tmp->colore == colore || curr->next->colore == colore) {
            colore = colori[rand()%DIM_COLORI];
        }
        colored = true;
        curr->colore = colore;
    }

    if (colored) {
        return curr;
    }
    return NULL;
}