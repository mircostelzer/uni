#include <iostream>
#include <bits/stdc++.h>
#include <vector>
#include <fstream>

using namespace std;

int main()
{
    int n;
    vector<int> v;
    map<int, int> m;
    ifstream in("input.txt");
    in >> n;
    int x;
    for (int i=0; i<n*2; i++) {
        in >> x;
        m.insert(pair<int, int>(x, i%2));
        v.push_back(x);
    }

    sort(v.begin(), v.end());

    for (int i=0; i<v.size(); i++) {
        cout << v[i] << " ";
    }

    int low = -1;
    int up = -1;
    int maxDiff = 0;

    for (int i=0; i<v.size()-1; i++) {
        if ((v[i+1] != v[i]+1) && (v[i+1] != v[i])) {
                if ((m[v[i]] == 1) && (m[v[i+1]] == 0)) {
                    int diff = v[i+1] - v[i];
                    if (diff > maxDiff) {
                        low = v[i];
                        up = v[i+1];
                        maxDiff = diff;
                    }
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