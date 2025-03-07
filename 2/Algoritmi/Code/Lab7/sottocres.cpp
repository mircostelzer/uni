#include <bits/stdc++.h>

using namespace std;

int main()
{
    int N;
    ifstream in("input.txt");

    in >> N;

    int dp[N];
    int a[N];

    for (int i = 0; i < N; i++) {
        in >> a[i];
    }

    dp[N-1] = a[N-1];
    int currMax = a[N-1];
    int index = N-1;

    for (int i = N-2; i >= 0; i--) {
        if (a[i] > a[i+1]) {
            if (a[i] > currMax) {
                dp[i] = max(dp[i+1], a[i]);
                if (dp[i+1] < a[i]) {
                    currMax = a[i];
                    index = i;
                }
            } else {
                dp[i] = max(dp[index] + a[i], dp[i+1]);
            }
        } else {
            dp[i] = dp[i+1] + a[i];
        }
    }

    ofstream out("output.txt");
    out << dp[0];

    return 0;
}