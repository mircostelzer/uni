#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int max_el(vector<int> vec) {
    int res = 0;
    for (int i = 0; i < vec.size(); i++) {
        res = max(res, vec[i]);
    }
    
    return res;
}

void dfs(vector<vector<int>> g, int n, vector<bool> &visited, int &counter) {
    visited[n] = true;
    for (int v : g[n]) {
        if (!visited[v]) {
            counter += 1;
            dfs(g, v, visited, counter);
        }
    }
}

int bfs(vector<vector<int>> g, int u, int N) {
    vector<int> distance(N, -1);

    queue<int> q;
    q.push(u);

    distance[u] = 0;

    while (!q.empty()) {
        int u = q.front();
        q.pop();
        for (int i : g[u]) {
            if (distance[i] == -1) {
                distance[i] = distance[u] + 1;
                q.push(i);
            }
        }
    }

    return max_el(distance);
}

int main()
{
    ifstream in("input.txt");
    int N, M;
    in >> N >> M;
    vector<vector<int>> g(N);

    int j, k;
    for (int i = 0; i < M; i++) {
        in >> j;
        in >> k;
        g[j].push_back(k);
        g[k].push_back(j);
    }

    int maxx = 0;
    for (int i = 0; i < N; i++) {
        vector<bool> visited(N, false);

        maxx = max(bfs(g, i, N), maxx);
    }

    ofstream out("output.txt");
    out << maxx;

    return 0;
}