#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    ifstream in("input.txt");

    in >> N;

    vector<int> dp(N);
    int a[N];

    for (int i = 0; i < N; i++) {
        in >> a[i];
        
    }

    // for (int i=N-1; i>=0; i--) {
    //     for (int j=N-1; j>=0; j--) {
    //         if (a[i] < a[j]) {
    //             dp[i][j] = dp[i+1][j];
    //         } else {
    //             dp[i][j] = max(dp[i+1][j], dp[i+1][i] + a[i]);
    //         }
    //     }
    // }
    int res = 0;

    for (int i=N-1; i>=0; i--) {
        dp[i] = a[i];
        for (int j=i+1; j<N; j++) {
            if (a[j] >= a[i]) {
                dp[i] = max(dp[i], dp[j] + a[i]);
            }
        }
        res = max(res, dp[i]);
    }


    ofstream out("output.txt");
    out << res;
       

    return 0;
}