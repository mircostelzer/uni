#include <iostream>
#include <fstream>
using namespace std;

const int dim=50;
int main()
{
    fstream myout;
    myout.open("a.txt", ios::out);
    char c;
    while (cin.get(c)) {
        if (c=='\t' || c=='\n') {
            c = '\0';
            cout << " ";
        }
    }
    myout.close();
}