#include <iostream>

using namespace std;

bool *init(int n) {
    bool *b_f = new bool[n];
    for (int i=0; i<n; i++) {
        b_f[i] = false;
    }
    return b_f;
}

void insert(bool *b_f, int n, char *string) {
    for (int i=0; string[i]!='\0'; i++) {
        b_f[string[i]%n] = true;
    }
}

bool check(bool *b_f, int n, char *string) {
    bool res = true;
    for (int i=0; string[i]!='\0'; i++) {
        if (!b_f[string[i]%n]) {
            res = false;
        }
    }

    return res;
}


void deinit(bool *b_f) {
    delete[] b_f;
}


int main(int argc, char* argv[]) {

    // Se modificate la funzione "main", ricordarsi poi di ripristinare il codice originale
    int n = 255;

    bool* bloom_filter = init(n);

    char ciao[] = { 'c', 'i', 'a', 'o', '\0' };     
    insert(bloom_filter, n, ciao);
    cout << "Ho inserito la parola 'ciao' nel bloom filter" << endl;
    
    if (check(bloom_filter, n, ciao)) {
        cout << "La parola 'ciao' è presente nel bloom filter " << endl;
    } else {
        cout << "La parola 'ciao' NON è presente nel bloom filter " << endl;
    }

    char volo[] = { 'v', 'o', 'l', 'o', '\0' }; 
    if (check(bloom_filter, n, volo)) {
        cout << "La parola 'volo' è presente nel bloom filter " << endl;
    } else {
        cout << "La parola 'volo' NON è presente nel bloom filter " << endl;
    }

    deinit(bloom_filter);

    return 0;
}