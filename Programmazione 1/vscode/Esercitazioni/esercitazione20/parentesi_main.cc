#include <iostream>
#include "stack.h"
using namespace std;

const int dim = 200;

bool balanced(char a[]) {
    stack s1;
    init(s1);
    for (int i=0; a[i]!='\0'; i++) {
        if (a[i]=='(') {
            push(s1, 1);
        }
        else if (a[i]==')') {
            if (pop(s1)==FAIL) {
                return false;
            }
        }
    }
    if (s1!=NULL) {
        return false;
    }
    deinit(s1);
    return true;
}

int main()
{
    char a[dim];
    cin >> a;
    if (balanced(a)) {
        cout << "Le parentesi sono bilanciate" << endl;
    }
    else { cout << "Le parentesi non sono bilanciate" << endl;}
}