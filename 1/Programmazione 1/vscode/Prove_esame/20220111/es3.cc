#include <iostream>
#include <fstream>

using namespace std;

struct nodo {
    int value;
    nodo* left;
    nodo* right;
};
typedef nodo* albero;


void stampaAlbero(albero radice, int spazio=0);
void init(albero &t);
bool empty(const albero &t);
void deinit(albero &t);
void insert_balanced(albero &t, int array[], int dim);
void insert_balanced_aux(albero &t, int array[], int first, int last);
void bubble_sort(int a[], int dim);

int main(int argc, char **argv)
{
    if (argc != 2) {
        cout << "Usage: a.out <input>\n";
        exit(1);
    }

    fstream fin;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file di input\n";
        exit(1);
    }

    int DIM_MAX = 100;
    int *array = new int [DIM_MAX];
    int dim = 0;
    int n;
    
    while (fin >> n) {
        array[dim] = n;
        dim++;
    }
    albero t;
    init(t);
    bubble_sort(array, dim);
    insert_balanced(t, array, dim);
    stampaAlbero(t);
    deinit(t);

    fin.close();
    delete[] array;

    return 0;
}

void init(albero &t) {
    t=NULL;
}

bool empty(const albero &t) {
    return (t==NULL);
}

void deinit(albero &t) {
    if (!empty(t)) {
        deinit(t->left);
        deinit(t->right);
        delete t;
    }
}

void insert_balanced(albero &t, int array[], int dim) {
    insert_balanced_aux(t, array, 0, dim-1);
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

void bubble_sort(int a[], int dim) {
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