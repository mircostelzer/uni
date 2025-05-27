#include <iostream>
#include <stdlib.h>
#include <stack> 
#include <math.h>

using namespace std;

stack<char> s;
void printStack(stack<char> s) {
    while(!s.empty()) {
        cout << s.top();
        s.pop();
    }
    cout << endl;
}
static int count = 0;
void fun(int n, int m) {
    if(n == 0 && m == 0) {
        cout << ++count << ": ";
        printStack(s);
        return;
    }
    if (n) {
        s.push('/');
        fun(n-1, m);
        s.pop();
    }
    if (m) {
        s.push('*');
        fun(n, m-1);
        s.pop();
    }
    
}


int main()
{

    fun(10, 15);
}