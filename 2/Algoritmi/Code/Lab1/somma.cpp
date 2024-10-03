#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    int N, M;
    ifstream infile("input.txt");
    infile >> N >> M;
    ofstream outfile("output.txt");
    outfile << N + M;

    return 0;
}