#include <iostream>

using namespace std;

bool *init(int n) {
    bool *res = new (nothrow) bool[n];
    for (int i=0; i<n; i++) {
        res[i] = false;
    }
    return res;
}

void insert(bool *bloom_filter, int n, const char *word) {
    int i = 0;
    while (word[i]!='\0') {
        int tmp = int(word[i]);
        if (tmp>n) {
            tmp %= n;
        }
        if (!bloom_filter[tmp]) {
            bloom_filter[tmp] = true;
        }
        i++;
    }
}

bool check(const bool *bloom_filter, int n, const char *word) {
    bool res;
    int count = 0;
    int i = 0;
    while (word[i]!='\0') {
        int tmp = int(word[i]);
        if (tmp>n) {
            tmp %= n;
        }
        if (bloom_filter[tmp]) {
            count++;
        }
        i++;
    }
    if (count == i) {
        res = true;
    }
    else { res = false; }

    return res;
}

void deinit(bool *bloom_filter) {
    delete[] bloom_filter;
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