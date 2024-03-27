#include <iostream>
#include <fstream>

using namespace std;

/* Scrivere nel file esercizio3.cc un programma che riceve da linea di comando (quindi usando argc e argv) 
il percorso di un file contenente una lettera dell’alfabeto per riga (26 lettere). 
Il file contiene almeno 1 lettera e al massimo 26 lettere, e tutte le lettere sono diverse fra loro. 
Il programma deve creare un albero di ricerca binaria bilanciato con le lettere contenute nel file, ordinate alfabeticamente.
Ricordarsi che l’albero di ricerca binaria dev’essere bilanciato. 
Quindi, il primo elemento contenuto nel file di input non dev’essere necessariamente la radice dell’albero. 
Gli elementi contenuti nel file di input non sono necessariamente ordinati.*/

struct nodo {
    char value;
    nodo* left;
    nodo* right;
};
typedef nodo* albero;


void stampaAlbero(albero radice, int spazio=0);
void init(albero &t);
bool empty(const albero &t);
bool insert(char val, albero &t);
void deinit(albero &t);
void bubble_sort(char a[], int dim);



int main(int argc, char ** argv) {

    if (argc != 2) {
        cout << "Usage: a.out <file>\n";
        exit(1);
    }

    fstream fin;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit(1);
    }

    char ch;
    int DIM_MAX = 26;
    int i = 0;
    char *array = new char [DIM_MAX];
    while (fin >> ch) {
        array[i] = ch;
        i++;
    }
    fin.close();
    albero t;
    init(t);
    bubble_sort(array, i);
    insert(array[i/2-1], t);

    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit(1);
    }
    while (fin >> ch) {
        if (ch != array[i/2-1]) {
        insert(ch, t);
        }
    }
    fin.close();

    stampaAlbero(t);

    delete[] array;
    deinit(t);

    return 0;
}


/** Stampa dell'albero */
void stampaAlbero(albero radice, int spazio){
    if (radice != NULL) {
        spazio ++;

        stampaAlbero(radice->right, spazio);

        for (int i = 1; i < spazio; i++) {
            cout<<"\t";
        }
        cout<<radice->value<<"\n";

        stampaAlbero(radice->left, spazio);
    }
}

void init(albero &t) {
    t=NULL;
}

bool empty(const albero &t) {
    return (t==NULL);
}

bool insert(char val, albero &t) {
    bool inserted;
    if (empty(t)) {
        t = new (nothrow) nodo;
        if (t==NULL) {
            inserted = false;
        }
        else {
            t->value = val;
            t->left = NULL;
            t->right = NULL;
            inserted = true;
        }
    }
    else if (val<=t->value) {
            inserted = insert(val, t->left);
        }
        else if (val>t->value) {
            inserted = insert(val, t->right);
        }
    return inserted;
}

void deinit(albero &t) {
    if (!empty(t)) {
        deinit(t->left);
        deinit(t->right);
        delete t;
    }
}

void bubble_sort(char a[], int dim) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<(dim-1); j++) {
            if (a[j]>a[j+1]) {
                int tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
            }
        }
    }
}