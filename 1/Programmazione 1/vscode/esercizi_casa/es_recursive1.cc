#include <iostream>
using namespace std;


void print(char a, char b) {
    if (a<=b) {
        cout << a;
        cout << " ";
        print(a+1, b);
}
}

int main()
{
    char a, b;
    cin >> a >> b;
    print(min(a,b), max(a, b));
}