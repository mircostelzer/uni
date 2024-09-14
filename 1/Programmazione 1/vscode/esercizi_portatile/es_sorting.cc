#include <iostream>
#include <cstdlib>
using namespace std;

const int dim = 10;

void def_array(int a[], int n) {
    srand(time(NULL));
    for (int i=0;i<n; i++) {
        a[i] = rand()%10;
    }
}

void print(int a[], int n) {
    for (int i=0;i<n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

void bubble_sort(int a[], int n) {
    for (int i=0; i<n; i++) {
        for (int j=0; j<n-1; j++) {
            int tmp=0;
            if (a[j]>a[j+1]) {
                tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
            }
        }
    }
}


int search(int a[], int n, int target) {
    bool found = false;
    int loc, left = 0, right = n-1;
    while (!found && left <= right) {
        loc = (left + right)/2;
        if (a[loc]== target) {
            found = true;
        }
        else if (a[loc] < target) {
            left = loc + 1;
        }
        else right = loc -1; 
    }
    if (found) {
    } 
    else {loc = -1;}
    return loc;
}


int main()
{
    int a[dim], n;
    cin >> n;
    def_array(a, dim);
    print(a, dim);
    bubble_sort(a, dim);
    print(a, dim);
    if (search( a, dim, n) >= 0) {
        cout << n << " trovato in posizione " << search( a , dim , n) << endl;
    }
    else cout << n << " non trovato" << endl;
}