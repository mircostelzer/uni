#include <iostream>
#include "pila.h"


using namespace std;


/**
 * Ricordare che il file "pila.h" contiene la definizione della struct "cella" (qui sotto riportata)
 * 
 * struct cella {
 *   int indiceRiga;
 *   int indiceColonna;
 * };
 */
void risolviLabirinto(int [][5], int, int);


int main(int argc, char* argv[]) {

    // Se modificate la funzione "main", ricordarsi poi di ripristinare il codice originale  

    // E' possibile modificare la matrice per effettuare dei test   
    int labirinto[5][5] = {
        { 1, 0, 1, 1, 0 },
        { 1, 1, 1, 0, 1 },
        { 0, 1, 0, 1, 1 },
        { 1, 1, 1, 1, 1 },
        { 1, 1, 1, 1, 1 }
    };

    // E' possibile modificare la cella di arrivo per effettuare dei test (la cella di partenza invece è sempre [0,0])   
    cout<<"Percorso: ";
    risolviLabirinto(labirinto, 4, 2);
   
    return 0;
}



void risolviLabirinto(int labirinto[][5], int x, int y) {
    init();
    bool visited[5][5] = {0};
    cella start {0, 0};
    push(start);
    
    while (!vuota()) {
        cella tmp;
        top(tmp);
        int i = tmp.indiceRiga;
        int j = tmp.indiceColonna;
        if (i == x && j == y) {
            while (!vuota()) {
                top(tmp);
                cout << "[" << tmp.indiceRiga << "," << tmp.indiceColonna << "] ";
                pop();
            }
        }
        else if (i-1>=0 && !visited[i-1][j] && labirinto[i-1][j] == 1) {
            cella c {i-1, j};
            push(c);
            visited[i-1][j] = true;
        }
        else if (j-1>=0 && !visited[i][j-1] && labirinto[i][j-1] == 1) {
            cella c {i, j-1};
            push(c);
            visited[i][j-1] = true;
        }
        else if (i+1<5 && !visited[i+1][j] && labirinto[i+1][j] == 1) {
            cella c {i+1, j};
            push(c);
            visited[i+1][j] = true;
        }
        else if (j+1<5 && !visited[i][j+1] && labirinto[i][j+1] == 1) {
            cella c {i, j+1};
            push(c);
            visited[i][j+1] = true;
        }
        else { pop(); }

    }

    cout << '\n';

    deinit();
}