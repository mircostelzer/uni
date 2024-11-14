#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int main()
{
    ifstream in("input.txt");
    int n;
    in >> n;
    vector<int> num;
    vector<bool> visited;

    num.resize(n + 1);
    visited.resize(n + 1, false);
    for (int i = 1; i <= n; i++) {
        in >> num[i];
    }

    int S = 0;
    int P = 0;

    for (int i = 1; i <= n; i++) {
        if (!visited[i]) {
            if (num[i] != i) {
                int curr = num[i];
                visited[curr] = true;

                int currS = 0;
                int sum = curr;
                int m = curr;
                
                do {
                    visited[num[curr]] = true;
                    curr = num[curr];
                    m = min(m, curr);
                    sum += curr;
                    currS++;
                } while (!visited[num[curr]]);

                S += currS;
                int Cm = currS * m + sum - m;
                int C1 = 2 * (1 + m) + currS + sum - m;

                P += min(Cm, C1);

            }
            visited[i] = true;
        }
    }

    ofstream out("output.txt");
    out << S << " " << P;
}