#include <iostream>
#include <cstdlib>

using namespace std;

// Possibile funzione di supporto per il calcolo dei valori della
// continued fraction representation
int gcd(int n, int d) {
  while(n != d) {
    if(n > d)
      n -= d;
    else
      d -= n;
  }
  return n;
}

// Inserire qui sotto la dichiarazione e definizione della procedura
// compute_continued_fraction_elements
void compute_continued_fraction_elements_aux(int num, int den, int res[], const int res_maxdim, int i) {
    if (den == 0 || i >= res_maxdim) {
        return;
    }
    res[i] = num/den;
    int n = num;
    int g = gcd(num, den);
    num = den/g;
    den = (n%den)/g;
    compute_continued_fraction_elements_aux(num, den, res, res_maxdim, i+1);
}

void compute_continued_fraction_elements(const int num, const int den, int res[], const int res_maxdim) {
    compute_continued_fraction_elements_aux(num, den, res, res_maxdim, 0);
    return;
}
// Inserire qui sopra la dichiarazione e definizione della procedura
// compute_continued_fraction_elements

int main(int argc, char ** argv) {
    if (argc != 3) {
    std::cout << "Usage: " << argv[0] << " <numerator_positivenum> <denominator_positivenum>" << std::endl;
    exit(1);
  }
  int num = atoi(argv[1]);
  int den = atoi(argv[2]);
  int res_maxdim = 20;
  int * res = new int[res_maxdim];

  for(int i = 0; i < res_maxdim; i++) res[i] = -1;

  compute_continued_fraction_elements(num, den, res, res_maxdim);

  cout << "The continued fraction representation for "
       << num << "/" << den << " is" << endl;
  for(int i = 0; ((i < res_maxdim) && (res[i] != -1)); i++)
    cout << " " << res[i];
  cout << endl;

  delete res;
}
