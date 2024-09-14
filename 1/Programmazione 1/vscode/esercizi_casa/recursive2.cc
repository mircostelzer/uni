#include <iostream>
using namespace std;

long int pow(int base, int esp) {
     int res;
     if (esp==0) {
          res = 1;
     }
     else {
          res = base * pow(base, esp-1);
     }
     return res;
}

int main()
{
     int base, esp;
     cin >> base >> esp;
     cout << pow(base, esp) << endl;
     return 0;
}