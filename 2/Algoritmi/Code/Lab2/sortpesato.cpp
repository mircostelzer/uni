#include <iostream>
#include <bits/stdc++.h>

using namespace std;

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
            P += (x + y + 2);
        }
    }

    ofstream out("output.txt");
    out << S << " " << P;
}