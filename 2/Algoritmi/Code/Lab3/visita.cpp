#include <iostream>
#include <bits/stdc++.h>

using namespace std;



int main()
{
    vector<vector<int>> g;
    int N, M, S;
    ifstream in("input.txt");
    in >> N;
    g.resize(N);
    in >> M;
    in >> S;

    int j;
    int k;
    for (int i = 0; i < M; i++) {
        in >> j;
        in >> k;
        g[j].push_back(k);
    }

    vector<bool> visited(N, false);

    queue<int> q;
    q.push(S);

    int counter = 1;
    visited[S] = true;

    while (!q.empty()) {
        int u = q.front();
        q.pop();
        for (int i : g[u]) {
            if (!visited[i]) {
                counter++;
                visited[i] = true;
                q.push(i);
            }
        }
    }

    ofstream out("output.txt");
    out << counter;

    return 0;
}