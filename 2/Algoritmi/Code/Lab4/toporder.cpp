#include <iostream>
#include <bits/stdc++.h>

using namespace std;

void dfs(vector<vector<int>> g, int u, vector<bool> &visited, stack<int> &s) {
    visited[u] = true;
    for (int v : g[u]) {
        if (!visited[v]) {
            dfs(g, v, visited, s);
        }
    }
    s.push(u);
}

int main()
{
    int N, M;
    ifstream in("input.txt");
    in >> N >> M;
    vector<vector<int>> g(N);
    int j, k;
    for (int i=0; i<M; i++) {
        in >> j >> k;
        g[j].push_back(k);
    }

    stack<int> s;
    vector<bool> visited(N, false);

    for (int i=0; i<N; i++) {
        if (!visited[i]) {
            dfs(g, i, visited, s);
        }
    }


    ofstream out("output.txt");
    for (int i=0; i<N; i++) {
        out << s.top() << " ";
        s.pop();
    }

    return 0;
}