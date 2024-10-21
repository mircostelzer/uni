#include <iostream>
#include <fstream>
#include <stdlib.h>

using namespace std;

int sum(int a[], int i, int j) {
    int res = 0;
    for (int k=i; k<=j; k++) {
        res+=a[k];
    }

    return res;
}

int kadane(int a[], int n) {
    int maX = 0;
    int sum = 0;
    for (int i=0; i<n; i++) {
        sum = max(sum+=a[i], 0);
        maX = max(maX, sum);
    }
    return maX;
}

int main()
{
    int R, C;
    ifstream infile("input.txt");
    infile >> R;
    infile >> C;

    int mat[R][C];
    for (int i=0; i<R; i++) {
        for (int j=0; j<C; j++) {
            int n;
            infile >> n;
            mat[i][j] = n;
        }
        
    }

    int mx = 0;
    for (int i=0; i<C; i++) {
        for (int j=i; j<C; j++) {
            int s[R];
            for (int k=0; k<R; k++) {
                s[k] = sum(mat[k], i, j);
            }
            mx = max(mx, kadane(s, R));
        }
    }

    ofstream outfile("output.txt");
    outfile << mx;

    return 0;
}