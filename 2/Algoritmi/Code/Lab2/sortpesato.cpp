#include <iostream>
#include <bits/stdc++.h>

using namespace std;

void copy(int *src, int *dest, int n) {
    for (int i=0; i<n; i++) {
        dest[i] = src[i];
    }
}

int Min(int a, int b) {
    if (a < b) {
        return a;
    }
    return b;
}

int main()
{
    ifstream in("input.txt");
    int n;
    in >> n;
    int arr[n];
    int index[n];
    int x;
    for (int i=0; i<n; i++) {
        in >> x;
        arr[i] = x-1;
        index[x-1] = i;
    }

    int arr1[n];
    int index1[n];
    copy(arr, arr1, n);
    copy(index, index1, n); 

    int S = 0;
    int P = 0;
    int min = 0;
    int max = n-1;
    
    while(min < max) {
        if (index[min] == min) {
            min++;
        } else {
            int x = arr[index[index[min]]];
            int y = arr[index[min]];
            swap(arr[index[index[min]]], arr[index[min]]);
            swap(index[min], index[x]);
            S++;
        }
    }

    min = 0;
    max = n-1;

    while (min < max) {
        if (index1[min] == min) {
            min++;
        } else {
            int x = arr1[index1[min]];
            int y = arr1[index1[index1[min]]];
            swap(arr1[index1[min]], arr1[index1[index1[min]]]);
            swap(index1[min], index1[y]);
            int p1 = x + y + 2;
            int p2 = (1 + (min + 1)) * 2 + y + 1 + 1;
            P += Min(p1, p2);
        }



    }

    ofstream out("output.txt");
    out << S << " " << P;
}