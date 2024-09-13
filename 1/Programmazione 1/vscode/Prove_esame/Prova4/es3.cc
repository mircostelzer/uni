#include <iostream>
#include <fstream>

using namespace std;

struct nodo {
    int value;
    nodo* left;
    nodo* right;
};
typedef nodo* albero;

bool insert(int val, albero &t) {
    bool inserted;
    if (t == NULL) {
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

void bubble_sort(int *a, int n) {
    for (int i=0; i<n-1; i++) {
        for (int j=0; j<n-i-1; j++) {
            if (a[j] > a[j+1]) {
                swap(a[j], a[j+1]);
            }
        }
    }
}

void insert_balanced_aux(albero &t, int array[], int first, int last) {
    if (first <= last) {
        int pivot = (first + last) / 2;
        t = new nodo;
        t->value = array[pivot];
        t->left = NULL;
        t->right = NULL;
        insert_balanced_aux(t->left, array, first, pivot - 1);
        insert_balanced_aux(t->right, array, pivot + 1, last);
    }
}

void insert_balanced(albero &t, int array[], int dim) {
    insert_balanced_aux(t, array, 0, dim-1);
}



void stampaAlbero(albero radice, int spazio=0);


int main(int argc, char **argv) {
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " <input>\n";
        exit(1);
    }

    fstream fin;
    fin.open(argv[1], ios::in);

    if (fin.fail()) {
        cout << "Errore nell'apertura del file\n";
        exit(1);
    }

    int dim = 0;
    int num[100];
    int n;
    while (fin >> n) {
        num[dim] = n;
        dim++;
    }

    bubble_sort(num, dim);

    albero t = NULL;
    insert_balanced(t, num, dim);
   

    stampaAlbero(t);

    fin.close();
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