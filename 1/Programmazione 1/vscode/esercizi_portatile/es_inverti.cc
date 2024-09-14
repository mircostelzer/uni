#include <iostream>
using namespace std;

void invers(int *pa) {
    cout << (*pa)%10;
    (*pa)/=10;
}

int main()
{
    int num;
    cout << "Inserire un numero: ";
    cin >> num;
    while (num!=0) {
        invers(&num);
    }
    cout << endl;
}