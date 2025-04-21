#include <iostream>
#include <bits/stdc++.h>

using namespace std;

void subsets(int n) {
    for (int i = 0; i < (1 << n); i++) {
        for (int j = 0; j < n; j++) {
            if (i & (1 << j)) {
                cout << j << " ";
            }
        }
        cout << endl;
    }
}

int main()
{

    subsets(3);
    subsets(4);

    return 0;
}