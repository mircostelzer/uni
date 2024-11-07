#include <iostream>
#include <bits/stdc++.h>
#include <vector>
#include <fstream>

using namespace std;

int main()
{
    int n;
    vector<int> v1;
    vector<int> v2;
    ifstream in("input.txt");
    in >> n;
    int x;
    int y;
    for (int i=0; i<n; i++) {
        in >> x;
        in >> y;
        v1.push_back(x);
        v2.push_back(y);
    }

    sort(v1.begin(), v1.end());    
    sort(v2.begin(), v2.end());    



    int low = -1;
    int up = -1;
    int maxDiff = 0;

    for (int i=0; i<n-1; i++) {
        if ((v1[i+1] != v2[i]) && (v1[i+1] != v2[i]+1)) {
            int diff = v1[i+1] - v2[i];
            if (diff > maxDiff) {
                low = v2[i];
                up = v1[i+1];
                maxDiff = diff;
            }
        }
    }

    ofstream out("output.txt");
    if (low != -1 && up != -1) {
        out << low << " " << up;
    }
    else {
        out << 0;
    }

    return 0;
}