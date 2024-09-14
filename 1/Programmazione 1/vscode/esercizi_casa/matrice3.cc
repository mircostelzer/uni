#include <iostream>
#include <cstdlib>
using namespace std;

const int dim=5;

void def_array(int a[][dim])
{
    srand(time(NULL));
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim; j++) {
        a[i][j] = rand()%2;
    }
    }
}

void print_array(const int a[][dim]) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim; j++) {
        cout << a[i][j] << " ";
    }
    cout << endl;
    }
}

void print_array1(const int b[dim]) {
    for (int i=0; i<dim; i++) {
        cout << b[i];
    }
    cout << endl;
}

bool array_percorso(const int a[][dim], int i, int j, int b[dim]) {
    bool found = true;
    if (a[i][j]==1) {
        b[j]=i;
        j++;
        while (found && (j<dim)) {
            if (i==0) {
            if (a[i][j]==1) {
                b[j]=i;
                j++;
            }
            else if (a[i+1][j]==1) {
                i=i+1;
                b[j]=i;
                j++;
            }
            else {found=false;} 
        }
        else if (i==(dim-1)) {
            if (a[i-1][j]==1) {
                i=i-1;
                b[j]=i;
                j++;
            }
            else if (a[i][j]==1) {
                b[j]=i;
                j++;
            }
            else {found=false;}
        }
        else {if( a[i-1][j]==1 ) {
                i=i-1;
                b[j]=i;
                j++;
            }
            else if (a[i][j]==1) {
                b[j]=i;
                j++;
            }
            
            else if (a[i+1][j]==1) {
                i=i+1;
                b[j]=i;
                j++;
            }
            else {found=false;}
        }
    }
}
else {found=false; j--;}
return found;
}

bool cerca_percorso(int a[][dim], int b[]) {
    int i=0;
    bool found = false;
    while (i<dim && !found) {
        found = array_percorso(a, i , 0, b);
        i++;
    }
    return found;
}


void matr_percorso(const int b[], char c[][dim]) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim; j++) {
            if (i==b[j]) {
                cout << '*' << " ";
            }
            else cout << '_' << " ";
        }
        cout << endl;
    }
}

int main()
{
    int a[dim][dim], b[dim];
    char c[dim][dim];
    def_array(a);
    print_array(a);
    cout << endl;
    if (cerca_percorso(a, b)) {
    print_array1(b);
    cout << endl;
    matr_percorso(b, c);
}
else cout << "Percorso non trovato!" << endl;

}