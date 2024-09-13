#include <iostream>
#include "alberi_bin.h"
#include <fstream>
using namespace std;

tree search_path(tree &t, int val) {
    tree res;
    if (t==NULL) {
        res = NULL;
    }
    else {
        if (val==t->val) {
            res = t;
        }
        else if (val<=t->val){
            cout << t->val << ", sinistra, "; 
            res = search_path(t->left, val);
        }
        else if (val>t->val) {
            cout << t->val << ", destra, ";
            res = search_path(t->right, val);
        }
    }
    return res;
}

int main(int argc, char *argv[])
{
    if (argc != 2) {
        cout << "Usage: ./a.out <file>\n";
        exit (0);
    }
    fstream fin;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cerr << "Errore nell'apertura del file\n";
        exit (0); 
    }
    int n;
    tree t;
    init(t);
    while (fin >> n) {
        insert(n, t);
    }
    fin.close();
    print_indented1(t);
    for (int i=0; i<5; i++) {
        cout << '\n';
    }
    print_ordered(t);
    cout << '\n';
    int x;
    cin >> x;
    cout << search_path(t, x)->val << '\n';
    deinit(t);
}