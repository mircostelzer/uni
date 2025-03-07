#include <bits/stdc++.h>

using namespace std;

int main()
{

    int N;
    ifstream in("input.txt");
    in >> N;

    long long int dp[N+1][N+1];
    
    for (int i = 0; i <= N; i++) {
        dp[0][i] = 1;
        dp[1][i] = 1;
        dp[i][N] = 1;
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 0; j < N; j++) {
            if (j == 0) {
                dp[i][j] = dp[i-1][j+1];
            } else if (j <= N-i) {
                    dp[i][j] = dp[i-1][j+1] + dp[i][j-1];
            } else {
                dp[i][j] = dp[i-1][j+1];
            }
        }
    }

    ofstream out("output.txt");
    out << dp[N][0];

    return 0;
}