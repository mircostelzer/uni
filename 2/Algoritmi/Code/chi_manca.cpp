#include <iostream>
#include <bits/stdc++.h>
#include <numeric>

using namespace std;

int chi_manca(vector<int> a, int low, int up) {
    if (low >= up) {
        return low;
    }
    int mid = (up + low)/2;
    if (a[mid] == mid) {
        return chi_manca(a, mid+1, up);
    }
    return chi_manca(a, low, mid-1);
}


int main()
{
    vector<int> v = {0, 1, 2, 3, 5, 6};
    cout << chi_manca(v, 0, v.size());



    return 0;
}