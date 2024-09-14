#include <iostream>
#include <cstdlib>
using namespace std;

int * generate_numbers(int n) {
    srand(time(NULL));
    int *a = new int [n];
    for (int i=0; i<n; i++) {
        a[i] = rand()%100;
    }
    return a;
}

void printArray(const int *a, int n) {
    for (int i=0; i<n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

int main()
{
    int n;
    cin >> n;
    int *a = generate_numbers(n);
    printArray(a, n);
    delete[] a;
    return 0;
}