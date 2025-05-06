#include <iostream>
#include <fstream>
#include <vector>
#include <stdlib.h>
#include <algorithm>

using namespace std;

vector<vector<int>> g;

int main()
{
    ifstream in("input.txt");
    ofstream out("output.txt");

    int N;
    in >> N;
    g.resize(N, vector<int>(N, 0));


    for (int i=1; i<N; i++) {
        int w;
        for (int j=0; j<i; j++) {
            in >> w;
            g[i][j] = w;
            g[j][i] = w;
        }
    }

    for (int i=0; i<N; i++) {
        for (int j : g[i]) {
            cout << j << " ";
        }
        cout << endl;
    }
    

    vector<bool> visited(N, false);

    int curr = 0;
    visited[0] = true;
    out << 0 << " ";
    for (int i=0; i<N-1; i++) {
        int minv = 1001;
        int index = -1;
        for(int j=0; j<N; j++) {
            if ((!visited[j]) && (g[curr][j] < minv)) {
                minv = g[curr][j];
                index = j;
            }
        }
        visited[index] = true;
        out << index << " ";
        curr = index;
    }

    out << "0#";

    return 0;
}