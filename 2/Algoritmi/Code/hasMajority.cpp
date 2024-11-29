#include <iostream>

using namespace std;

bool hasMajorityAux(int *a, int start, int end, int target, int first, int last) {
    
}

bool hasMajority(int *a, int n) {
    return hasMajorityAux(a, 0, n - 1, a[n/2], n, -1);
}

int main()
{
    int a[] = {1, 2, 4, 4, 4, 4, 5, 7};
    cout << hasMajority(a, 8) << endl;

    return 0;
}