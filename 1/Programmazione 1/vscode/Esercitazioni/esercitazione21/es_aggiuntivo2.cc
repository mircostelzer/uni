#include <iostream>
#include <cstdlib>
using namespace std;

int **fillMatrix(int **mat, int &i, int &j) {
    srand(time(NULL));
    cout << "Dimensioni matrice? ";
    cin >> i;
    cin >> j;
    mat = new int *[i];
    for (int k = 0; k<i; k++) {
        mat[k] = new int [j];
    }
    return mat;
}

void printMatrix(int **a, int dim1, int dim2) {
    for (int i=0; i<dim1; i++) {
        for (int j=0; j<dim2; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

void printMatrix1(int **mat, int i, int j, int a, int b, int c, int d) {
    for (int k=a; k<=(c+a) && k<i; k++) {
        for (int l=b; l<=(d+b) && l<j; l++) {
            cout << mat[k][l] << " ";
        }
        cout << endl;
    }

}

int main()
{
    int i, j, coord_i, coord_j, dim1, dim2;
    int **mat = fillMatrix(mat, i, j);   
    for (int l=0; l<i; l++) {
        for (int m=0; m<j; m++) {
            mat[l][m] = rand()%10;
        }
    }
    cout << "Sottomatrice? ";
    cin >> coord_i >> coord_j >> dim1 >> dim2;
    printMatrix(mat, i, j);
    cout << endl;
    printMatrix1(mat, i, j, coord_i, coord_j, dim1, dim2);
    for (int k=0; k<i; k++) {
        delete[] mat[k];
    }
    delete[] mat;
}