#include <bits/stdc++.h>

using namespace std;

vector<int> fr;
vector<int> ob;

vector<vector<int>> t;
vector<int> w;

int take(int node);
int free(int node);


int main()
{
    int N;

    ifstream in("input.txt");
    in >> N;

    t.resize(N);
    w.resize(N);

    for (int i=0; i<N; i++) {
        in >> w[i];
    }

    int f;
    int s;
    for (int i=0; i<N-1; i++) {
        in >> f;
        in >> s;
        t[f].push_back(s);
    }

    fr.resize(N, -1);
    ob.resize(N, -1);

    int res = free(0);

    ofstream out("output.txt");
    out << res;

    return 0;
}

int take(int node) {
    if (ob[node] == -1) {
        ob[node] = w[node];
        for(int i : t[node]) {
            ob[node] += free(i);
        }
    }
    return ob[node];
}

int free(int node) {
    if (fr[node] == -1) {
        fr[node] = 0;
        for(int i : t[node]) {
            fr[node] += take(i);
        }
        fr[node] = min(take(node), fr[node]);
    }
    return fr[node];
}