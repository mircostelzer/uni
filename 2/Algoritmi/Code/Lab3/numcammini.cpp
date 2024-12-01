#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main()
{
    ifstream in("input.txt");
    int N, M, S, T;
    in >> N >> M >> S >> T;

    vector<vector<int>> g(N);
    int j;
    int k;
    for (int i = 0; i < M; i++)
    {
        in >> j;
        in >> k;
        g[j].push_back(k);
    }

    vector<int> cammini(N, 0);
    vector<int> distance(N, -1);
    queue<int> q;
    q.push(S);

    distance[S] = 0;
    cammini[S] = 1;

    while (!q.empty())
    {
        int u = q.front();
        q.pop();
        for (int i : g[u])
        {
            if (distance[i] == -1)
            {
                distance[i] = distance[u] + 1;
                q.push(i);
            }

            if (distance[i] == distance[u] + 1)
            {
                cammini[i] += cammini[u];
            }
        }
    }

    ofstream out("output.txt");
    out << distance[T] << " " << cammini[T];

    return 0;
}