#include <iostream>
#include <bits/stdc++.h>

using namespace std;

// int main()
// {
//     int N;
//     int C;
//     vector<int> w(N, 0);
//     vector<int> p(N, 0);

//     ifstream in("input.txt");
//     in >> C >> N;
//     for (int i = 0; i < N; i++) {
//         in >> w[i] >> p[i];
//     }

//     vector<vector<int>> dp(N + 1, vector<int>(C + 1, -1));

//     for (int i = 0; i <= N; i++) {
//         dp[i][0] = 0;
//     }

//     for (int i = 0; i <= C; i++) {
//         dp[0][i] = 0;
//     }

//     for (int i = 1; i <= N; i++) {
//         for (int c = 1; c <= C; c++) {
//             if (w[i-1] <= c) {
//                 dp[i][c] = max(dp[i-1][c-w[i-1]] + p[i-1], dp[i-1][c]);
//             } else {
//                 dp[i][c] = dp[i-1][c];
//             }
//         }
//     }
    
//     ofstream out("output.txt");
//     out << dp[N][C];


//     return 0;
// }

int main()
{
    int N;
    int C;    
    ifstream in("input.txt");
    in >> C >> N;

    // int w[N];
    // int p[N];
    // for (int i = 0; i < N; i++) {
    //     in >> w[i] >> p[i];
    // }

    vector<vector<int>> dp(2, vector<int>(C+1, 0));

    // for (int i = 0; i < N; i++) {
    //     dp[i][0] = 0;
    // }

    int w;
    int p;

    for (int i = 1; i <= N; i++) {
        dp[0].swap(dp[1]);
        in >> w >> p;
        for (int c = 1; c <= C; c++) {
            if (w <= c) {
                dp[1][c] = max(dp[0][c-w] + p, dp[0][c]);
            } else {
                dp[1][c] = dp[0][c];
            }
        }
    }
    
    ofstream out("output.txt");
    out << dp[1][C];

    return 0;
}