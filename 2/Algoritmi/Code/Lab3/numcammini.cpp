#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int min_el(vector<int> vec)
{
    if (vec.size() > 0) {
    int res = vec[0];
    for (int i = 1; i < vec.size(); i++)
    {
        res = min(res, vec[i]);
    }

    return res;

    }
    
    return 0;
}

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

    vector<int> cammini;
    if (T != S) {
        for (int v : g[S]) 
    {
        queue<int> q;
        q.push(v);

        vector<int> distance(N, -1);
        distance[S] = 0;

        distance[v] = 1;

        while (!q.empty())
        {
            int u = q.front();
            q.pop();
            for (int i : g[u])
            {
                if (i == T)
                {
                    cammini.push_back(distance[u] + 1);
                }
                if (distance[i] == -1)
                {
                    distance[i] = distance[u] + 1;
                    q.push(i);
                }
            }
        }
    }
    }


    int minC = min_el(cammini);
    int numcammini = 0;
    for (int i = 0; i < cammini.size(); i++)
    {
        if (cammini[i] == minC)
        {
            numcammini++;
        }
    }

    ofstream out("output.txt");
    out << minC << " " << numcammini;

    return 0;
}