#include <iostream>
#include <cstdlib>

#define MAX_DIM 75

void fill_random_array(char * A, int N) {
  if (NULL != A) {
    for(int i = 0; i < N; i++) {
      A[i] = 'A' + rand()%(('A' - 'Z')+1);
    }
  }
}

void print_array(const char msg[], char * A, int N) {
  std::cout << msg;
  if (NULL != A) {
    for (int i = 0; i < N; i++) {
      std::cout << A[i];
    }
  }
  std::cout << std::endl;
}

/* Inserire qui sotto la dichiarazione della funzione conta */
void conta(char *A, int D, int i, int j, int *&res);
/* Inserire qui sopra la dichiarazione della funzione conta */

int main(int argc, char **argv) {
  unsigned int seed = (unsigned int)time(NULL);
  // seed = 60000
  seed = 1697033220;
  if (argc > 1) {
    seed = atoi(argv[1]);
  }
  std::cout << "Seed = " << seed << std::endl;
  srand(seed);

  char A[MAX_DIM];

  fill_random_array(A, MAX_DIM);
  print_array("A[] = ", A, MAX_DIM);
  int i, j;
  i = 0; j = -1;
  while(i > j) {
    i = rand()%MAX_DIM;
    j = rand()%MAX_DIM;
  }
  int * res;
  conta(A, MAX_DIM, i, j, res);
  std::cout << "i = " << i << ", j = " << j << std::endl;
  std::cout << "A[" << i << "] = " << A[i];
  std::cout << "  A[" << j << "] = " << A[j] << std::endl;
  std::cout << "There are " << res[0] << " occurrences of " << A[j];
  std::cout << " between indexes " << i << " and " << j
            << " (with A[" << i << "] included and A[" << j << "] excluded)" << std::endl;
  if (res[0] > 0) {
    std::cout << "They are at indexes: ";
    for(int l = 1; l < res[0]+1; l++) {
      std::cout << res[l] << " ";
    }
    std::cout << std::endl;
  }
  delete [] res;
}

/* Inserire qui sotto la definizione della funzione conta */
int dim_array(char *A, int i, int j) {
    int res = 0;
    if (i<j) {
        if (A[i] == A[j]) {
        res = 1 + dim_array(A, i+1, j);
        }
        else {
            res = dim_array(A, i+1, j);
        }    
    }
    return res;
}

void conta_aux(char *A, int D, int i, int j, int *&res, int dim, int k) {
  if (i+k >= j) {
    res = new int[dim+1];
    res[0] = dim;
    return;
  }
  if (A[i+k] == A[j]) {
    dim++;
    conta_aux(A, D, i, j, res, dim, k+1);
    res[dim] = i+k;
    return;
  }
  conta_aux(A, D, i, j, res, dim, k+1);

}

void conta(char *A, int D, int i, int j, int *&res) {
  if ((i > j) || (j > D)) {
    res = new int[1];
    res[0] = 0;
  }
  conta_aux(A, D, i, j, res, 0, 0);
}
/* Inserire qui sotto la definizione della funzione conta */