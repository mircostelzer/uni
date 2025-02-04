#include <bits/stdc++.h>

using namespace std;

template <typename Item> void insertionSort(Item a[], int n) {
    for (int i = 1; i < n; i++) {
        int j = i;
        Item val = a[i];
        while ((j > 0) && (val < a[j - 1])) {
            a[j] = a[j - 1];
            j--;
        }
        a[j] = val;
    }
}

template <typename Item> int min(Item a[], int i, int n) {
    int res = i;
    int j = i;

    while (j < n) {
        if (a[j] < a[res]) {
            res = j;
        }
        j++;
    }

    return res;
}

template <typename Item> void selectionSort(Item a[], int n) {
    for (int i = 0; i < n; i++) {
        int minn = min(a, i, n);
        swap(a[i], a[minn]);
    }
}

