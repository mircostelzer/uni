#include <iostream>
using namespace std;

const int dim_max = 100;

bool palindromehelper(int *array, int dim, int i) {
    bool res;
    if (i > dim) {
        res = true;
    }
    else {
        res = (array[i]==array[dim-1]);
        if (res) {
        palindromehelper(array, dim-1, i+1);
        }
    }
    return res;
}

bool isPalindrome(int *array, int dim) {
    bool res;
    res = palindromehelper(array, dim, 0);
    return res;
}

int main()
{
    int *array;
    int n;
    cout << "Dimensione array? ";
    cin >> n;
    while (n>dim_max || n<=0) {
        cout << "Dimensione non valida\n";
        cin >> n;
    }
    array = new int [n];
    cout << "Inserire valori:\n";
    for (int i=0; i<n; i++) {
        cin >> array[i];
    }
    if (isPalindrome(array, n)) {
        cout << "L'array è palindromo\n";
    }
    else {
        cout << "L'array non è palindromo\n";
    }
    return 0;
}