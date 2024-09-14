#include <iostream>
using namespace std;

const int dim=50;

int main()
{
    char word[dim];
    do { cin >> word;
    cout << "\t\"" << word << "\"\n"; }
    while (!cin.fail());
}