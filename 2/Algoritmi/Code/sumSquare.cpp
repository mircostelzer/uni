#include <iostream>
#include <stdlib.h>
#include <math.h>

using namespace std;

void fun1(int n) {
    if (n == 0) {
        cout << endl;
        return;
    }
    
    for (int i = 1; i < sqrt(n); i++)
    {
        int low = floor(i);
        if (low > 0 ){
            cout  << low << "^2 ";
            fun1(low);
        } 
    }
    
}

int main()
{
    fun1(13);
}