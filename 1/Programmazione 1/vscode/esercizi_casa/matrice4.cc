#include <iostream>
#include <cstdlib>
using namespace std;

const int dim=4;

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

bool isIsland(const int a[][dim], int i, int j) {
    bool island = false;
    if (j==0) {
        if (i==0 && a[i][j+1]==0 && a[i+1][j]==0 && a[i+1][j+1]==0) {
            island = true;
        }
        else if (i==(dim-1) && a[i][j+1]==0 && a[i-1][j]==0 && a[i-1][j+1]==0) {
            island = true;
        }
        else if (a[i][j+1]==0 && a[i-1][j]==0 && a[i+1][j]==0 && a[i-1][j+1]==0 && a[i+1][j+1]==0) {
            island = true;
        }
    }
    if (j==(dim-1)) {
        if (i==0 && a[i][j-1]==0 && a[i+1][j]==0 && a[i+1][j-1]==0) {
            island = true;
        }
        else if (i==(dim-1) && a[i][j-1]==0 && a[i-1][j]==0 && a[i-1][j-1]==0) {
            island = true;
        }
        else if (a[i][j-1]==0 && a[i-1][j]==0 && a[i+1][j]==0 && a[i-1][j-1]==0 && a[i+1][j-1]==0) {
            island = true;
        }
    }
    else if (i==0 && a[i][j-1]==0 && a[i][j+1]==0 && a[i+1][j-1]==0 && a[i+1][j]==0 && a[i+1][j+1]==0) {
        island = true;
    }
    else if (i==(dim-1) && a[i][j-1]==0 && a[i][j+1]==0 && a[i-1][j-1]==0 && a[i-1][j]==0 && a[i-1][j+1]==0) {
        island = true;
    }
    else if (a[i][j-1]==0 && a[i-1][j]==0 && a[i-1][j-1]==0 && a[i][j+1]==0 && a[i+1][j]==0 && a[i+1][j+1]==0 && a[i-1][j+1]==0 && a[i+1][j-1]==0) {
        island = true;
    }
    return island;
}

int island(const int a[][dim]) {
    int res=0;
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim; j++) {
                if (a[i][j]==1) {
                    if (isIsland(a, i, j)) {
                    res++;
                    }
                    j++;
                }
        }

    }   
    return res;
}

void printIslands(const int a[][dim]) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<dim; j++) {
            if (isIsland(a, i, j)) {
            cout << "*" << " ";
            }
            else cout << "_" << " ";
        }
    cout << endl;
    }
}

int main()
{
    int a[dim][dim];
    def_array(a);
    print_array(a);
    cout << "\nCi sono " << island(a) << " isole" << endl;
    printIslands(a);
    cout << endl;
}