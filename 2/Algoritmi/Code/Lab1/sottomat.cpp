#include <iostream>
#include <fstream>
#include <stdlib.h>

using namespace std;

int main()
{
    int R, C;
    ifstream infile("input.txt");
    infile >> R;
    infile >> C;

    int mat[R][C];
    int S[R][C];

    for(int i=0; i<R; i++) {
    int sumr = 0;

    for(int j=0; j<C; j++) {
      infile >> mat[i][j];
      sumr += mat[i][j];
      S[i][j] = sumr;
    }
  }

    int mx = 0;
    for (int i=0; i<C; i++) {
        for (int j=i; j<C; j++) {
            int tot = 0;
            for (int k=0; k<R; k++) {
                int curr = S[k][j] - S[k][i-1];
                tot = max(curr, curr+tot);
                mx = max(mx, tot);
            }
        }
    }

    ofstream outfile("output.txt");
    outfile << mx;

    return 0;
}