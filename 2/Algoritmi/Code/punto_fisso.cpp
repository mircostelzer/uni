#include <iostream>
#include <bits/stdc++.h>

using namespace std;

bool pFisso(vector<int> a, int low, int up) {
    if (low > up) {
        return false;
    }
    int mid = (up + low)/2;
    if (a[mid] == mid) {
        return true;
    }
    if (a[mid] > mid) {
        return pFisso(a, low, mid-1);
    }
    return pFisso(a, mid+1, up);
}


int main()
{
    vector<int> v = {0, 4, 5, 7, 10, 12};
    cout << pFisso(v, 0, v.size());



    return 0;
}