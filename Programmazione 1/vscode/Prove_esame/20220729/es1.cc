#include<iostream>
#include<cstdlib>
#include<fstream>
using namespace std;

// La funzione non va modificata, pena l'annullamento dell'esercizio
void sort_array(int * array, int len_array) {
  for (int i=0; i<len_array; i++) {
    for (int j=i+1; j<len_array; j++) {
      if (array[i] > array[j]) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
      }
    }
  }
}

int main(int argc, char * argv []) {
    if (argc != 4) {
        cout << "Usage: " << argv[0] << " <input> <DIM> <N>\n";
        exit(1);
    }

    fstream fin, fout;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cout << "Errore nell'apertura del file di input\n";
        exit(1);
    }

    fout.open("output.txt", ios::out);
    if (fout.fail()) {
        fin.close();
        cout << "Errore nella creazione del file di output\n";
        exit(1);
    }

    int dim = atoi(argv[2]);
    int N = atoi(argv[3]);

    int *array = new int[dim];

    int n;
    int i = 0;

    while (fin >> n) {
        array[i] = n;
        i++;
    }

    sort_array(array, dim);

    for (int j=(dim-1); j>=(dim-N); j--) {
        fout << array[j] << '\n';
    }

    delete[] array;
    fin.close();
    fout.close();
    return 0;
}