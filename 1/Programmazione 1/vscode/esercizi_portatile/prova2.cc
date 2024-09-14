#include <iostream>
using namespace std;

int main()
{
    int a = 2;
    int *pa;
    pa = &a;
    cout << "&a= " << &a << ", *pa= " << *pa << endl;

}