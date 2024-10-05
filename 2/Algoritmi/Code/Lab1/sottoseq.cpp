#include <iostream>
#include <fstream>
#include <stdlib.h>

using namespace std;

int main()
{
    int N;
    ifstream infile("input.txt");
    infile >> N;

    int arr[N];
    for (int i=0; i<N; i++) {
        int n;
        infile >> n;
        arr[i] = n;
    }


    int maX = 0;
    int sum = 0;
    for (int i=0; i<N; i++) {
        sum = max(sum+=arr[i], 0);
        maX = max(maX, sum);
    }


    ofstream outfile("output.txt");
    outfile << maX;

    return 0;
}