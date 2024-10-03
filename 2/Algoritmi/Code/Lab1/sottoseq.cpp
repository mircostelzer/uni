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

    int max = 0;
    for (int i=0; i<N; i++) {
        
    }

    ofstream outfile("output.txt");
    outfile << max;

    return 0;
}