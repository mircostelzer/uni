#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

void f(char x[2], int index, char value) {
    x[index] = value;
}

int main() {
    char a[] = "ABCDEFGHIL";
    strcpy(&a[3], "OOO");
    f(&a[2], 4, '$');
    f(&a[2], 6, 'O');
    cout << a;
    return 0;

}