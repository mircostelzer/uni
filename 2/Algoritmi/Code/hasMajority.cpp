#include <iostream>

using namespace std;

int hasMajorityAux(int *a, int index, int target) {
    if (index >= 0) {
        if (a[index] == target) {
            return hasMajorityAux(a, index - 1, target);
        }
        return (index + 1);
    }
    return 0;
}

bool hasMajority(int *a, int n) {
    int target = a[n/2];
    int first = hasMajorityAux(a, n/2, target);
    return (a[first] == a[(n/2) + first]);
}

int main()
{
    int a[] = {3, 3, 3, 4, 4, 5};
    cout << hasMajority(a, 6) << endl;

    return 0;
}