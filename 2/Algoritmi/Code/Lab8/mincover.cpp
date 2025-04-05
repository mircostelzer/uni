#include <bits/stdc++.h>

using namespace std;

int solve(vector<vector<int>> t, vector<int> p, int N, int node, vector<int> dp) {
    if (node == -1) {
        return 0;
    }
    if (dp[node] > N) {
        if (t[node].size() == 1) {
            dp[node] = 1;
            dp[p[node]] = 1;
        } else {
            int sum = 0;
            for (int i=1; i<t[node].size(); i++) {
                sum += solve(t, p, N, t[node][i], dp);
            }
            dp[p[node]] = sum + 1;
        }
    } 

    return dp[node];
}


int main()
{
    int N;

    ifstream in("input.txt");
    in >> N;

    vector<vector<int>> t(N);
    vector<int> parent(N);

    int f;
    int s;
    for (int i=0; i<N; i++) {
        in >> f;
        in >> s;
        t[f].push_back(s);
        parent[s] = f;
    }

    parent[0] = -1;

    vector<int> dp(N, N+1);
    dp[0] = 1;

    int res = 1;
    if (t[0].size() > 1) {
        solve(t, parent, N, t[0][1], dp);
        res = dp[N-1];
    }

    ofstream out("output.txt");
    out << res;

    return 0;
}