#include <iostream>
#include <bits/stdc++.h>

using namespace std;

void merge(int arr[], int first, int mid, int last) {
    int tmp[first+last+1];

    int i;
    for (i=mid; i>first; i--) {
        tmp[i-1] = arr[i-1];
    }

    int j;
    for (j=mid+1; j<last; j++) {
        tmp[mid+(last-j)] = arr[j+1];
    }

    int k=first;
    while (k<=last) {
        if (tmp[i] < tmp[j]) {
            arr[k] = tmp[i++];
        }
        else {
            arr[k] = tmp[j--];
        }
        k++;
    }
}

void mergeSort(int arr[], int first, int last) {
    if (first >= last) {
        return;
    }

    int mid = (first+last)/2;
    mergeSort(arr, first, mid);
    mergeSort(arr, mid+1, last);
    merge(arr, first, mid, last);

}


int main()
{
    int n;
    ifstream in("input.txt");
    in >> n;

    int arr[n];
    for (int i=0; i<n; i++) {
        in >> arr[i];
    }


    mergeSort(arr, 0, n);



    ofstream out("output.txt");
    for (int& i:arr) out << i << " "; 

    return 0;
}