#include <iostream>
#include <bits/stdc++.h>

using namespace std;

bool isValid(vector<vector<int>> g, int u, int dest, vector<bool> &visited) {
    queue<int> q;
    q.push(u);
    visited[u] = true;

    while (!q.empty()) {
        int v = q.front();
        q.pop();
        if (v == dest) {
            return true;
        }
        for (int i : g[v]) {
            if (!visited[i]) {
                visited[i] = true;
                q.push(i);
            }
        }
    }
    
    return false;
}

void dfs(vector<vector<int>> g, int u, int counter, vector<int> &id, int &currDim) {
    id[u] = counter;
    currDim++;
    for (int v : g[u]) {
        if ((id[v] == 0)) {
            vector<bool> visited(g.size(), false);
            if (isValid(g, v, u, visited)) {
                dfs(g, v, counter, id, currDim);
            }
        }
    }
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

    int counter = 0;
    vector<int> id(N, 0);
    int maxx = 0;
    for (int i=0; i<N; i++) {
        int currDim = 0;
        if (id[i] == 0) {
            counter++;
            dfs(g, i, counter, id, currDim);
            maxx = max(maxx, currDim); 
        }
    }

    ofstream out("output.txt");
    out << maxx;

    return 0;
}