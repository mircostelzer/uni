#include <iostream>
#include <bits/stdc++.h>

using namespace std;

void dfsTarjan(vector<vector<int>> g, int u, vector<int> &discovery, stack<int> &s, vector<bool> &onStack, vector<int> &low, int &time, int &maxx) {
    s.push(u);
    onStack[u] = true;
    discovery[u] = low[u] = time++;
    
    for (int v : g[u]) {
        if (discovery[v] == -1) {
            dfsTarjan(g, v, discovery, s, onStack, low, time, maxx);
            low[u] = min(low[u], low[v]);
        } else if (onStack[v]) {
            low[u] = min(low[u], discovery[v]);
        }
    }

    if (discovery[u] == low[u]) {
        int dim = 0;
        while (s.top() != u) {
            int n = s.top();
            s.pop();
            onStack[n] = false;
            dim++;
        }
        s.pop();
        onStack[u] = false;
        dim++;
        maxx = max(maxx, dim);
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

    vector<int> discovery(N, -1);
    stack<int> s;
    vector<bool> onStack(N, false);
    vector<int> low(N, -1);
    int time = 0;
    int maxx = 0;

    for (int i=0; i<N; i++) {
        if (discovery[i] == -1) {
            dfsTarjan(g, i, discovery, s, onStack, low, time, maxx);
        }
    }
    

    ofstream out("output.txt");
    out << maxx;

    return 0;
}