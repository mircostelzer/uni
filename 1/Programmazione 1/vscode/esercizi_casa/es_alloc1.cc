#include <iostream>
#include <cstdlib>
using namespace std;

int ** generate_matrix(int R, int C) {
    srand(time(NULL));
    int **a = new int *[R];
    for (int j=0; j<R; j++) {
        a[j] = new int [C];
    for (int i=0; i<C; i++) {
        a[j][i] = rand()%100;
    }
    }
    return a;
}

void printArray(int **a, int R, int C) {
    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
        cout << a[i][j] << " ";
        }
    cout << endl;
    }
    cout << endl;
    for (int i=0; i<R; i++) {
        delete[] a[i]; 
    }
    delete[] a;
}

int main()
{
    int R, C;
    cin >> R >> C;
    int **a = generate_matrix(R, C);
    printArray(a, R, C);
    return 0;
}