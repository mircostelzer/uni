#include <bits/stdc++.h>

using namespace std;

int binarySearch(int a[], int v, int n, int i, int j) {
    if (i > j) {
        return -1;
    }

    int mid = i + (j - i)/2;   // overflow optimization

    if (a[mid] == v) {
        return mid;
    } else if (a[mid] > v) {
        return binarySearch(a, v, n, i, mid - 1);
    } else {
        return binarySearch(a, v, n, mid + 1, j);
    }

    return -1;
}

int main()
{
    int array[] = {1, 4, 5, 7, 12, 54, 110, 112};

    cout << binarySearch(array, 20, 8, 0, 7);

    return 0;
}