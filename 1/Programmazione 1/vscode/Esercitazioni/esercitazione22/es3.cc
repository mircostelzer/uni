#include <iostream>
#include <cstdlib>
using namespace std;

const int dim_max = 100;

void initArray(int a[], int dim) {
    for (int i=0; i<dim; i++) {
        a[i] = rand()%10;
    }
}

bool contenuto(int a[], int b[], int dim_a, int dim_b) {
    bool res = false;
    for (int i=0; i<(dim_a-dim_b) && !res; i++) {
        if (a[i]==b[0]) {
            int j=i;
            int k=0;
            while (a[j]==b[k] && k<dim_b) {
                k++;
                j++;
            }
            if (k==dim_b) {
                res = true;
            }
        }
    }
    return res;
}

void printArray(int a[], int dim) {
    for (int i=0; i<dim; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

int main()
{
    int dim_p = 2, dim_t = 10;
    int pattern[dim_p], testo[dim_t];
    srand(time(NULL));
    initArray(pattern, dim_p);
    printArray(pattern, dim_p);
    initArray(testo, dim_t);
    printArray(testo, dim_t);
    if (contenuto(testo, pattern, dim_t, dim_p)) {
        cout << "pattern è contenuto\n";
    }
    else {
        cout << "pattern non è contenuto\n";
    }
    return 0;
}