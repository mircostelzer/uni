#include <iostream>
#include <iomanip>
#include <cstdlib>
#include <ctime>

#define MAXSIZE 20
#define MAXVALUE 100

void print_matrix(int ** A, int N, int M) {
  for(int i = 0; i < N; i++) {
    std::cout << std::setw(5);
    for (int j = 0; j < M; j++)
      std::cout << A[i][j] << std::setw(5);
    std::cout << std::endl;
  }
}

void dealloca(int ** A, int N, int M) {
  for (int i = 0; i < N; i++)
    delete[] A[i];
  delete[] A;
}

int ** generate(int N, int M) {
  int ** res = new int * [N];
  for (int i = 0; i < N; i++) {
    res[i] = new int[M];
    for (int j = 0; j < M; j++)
      res[i][j] = rand()%MAXVALUE;
  }
  return res;
}

int ** trasposta(int **A, int N, int M);

int main(int argc, char * argv[]) {
  srand(unsigned(time(0)));
		//
		// Commentare la linea seguente per avere comportamento
		// non-deterministico
		//
		srand(0);
  int N = rand()%MAXSIZE;
  int M = rand()%MAXSIZE;
  int **A = generate(N, M);
  std::cout << "Matrice A["<< N << "][" << M << "]" << std::endl;
  print_matrix(A, N, M);
  int **AT = trasposta(A, N, M);
  dealloca(A, N, M);
  std::cout << "Matrice AT["<< M << "][" << N << "]" << std::endl;
  print_matrix(AT, M, N);
  dealloca(AT, M, N);
}

void alloc(int **a, int n, int m, int i) {
    if (i<m) {
        a[i] = new int [n];
        alloc(a, n, m, i+1);
    }
}

void trasposta_aux(int **A, int **res, int n, int m, int i, int j) {
    if (i<m) {
        if (j==n) {
            trasposta_aux(A, res, n, m, i+1, 0);
        }
        else {
            res[i][j] = A[j][i];
            trasposta_aux(A, res, n, m, i, j+1);
        }
    }

}

int **trasposta(int **A, int N, int M) {
    int **res = new int *[M];

    alloc(res, N, M, 0);

    trasposta_aux(A, res, N, M, 0, 0);

    return res;
}