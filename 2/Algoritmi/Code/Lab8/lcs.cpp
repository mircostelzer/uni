#include <bits/stdc++.h>

using namespace std;

int main()
{
    ifstream in("input.txt");

    string s1;
    string s2;

    in >> s1 >> s2;

    int d1 = s1.size();
    int d2 = s2.size();

    vector<int> dp(d2+1, 0);
    vector<int> dp1(d2+1, 0);

    for (int i=1; i<=d1; i++) {
        swap(dp, dp1);
        dp1[0] = 0;
        for (int j=1; j<=d2; j++) {
            if (s1[i-1] == s2[j-1]) {
                dp1[j] = dp[j-1] + 1;
            } else {
                dp1[j] = max(dp1[j-1], dp[j]);
            }
        }
    }

    ofstream out("output.txt");
    out << dp1[d2];

    return 0;
}