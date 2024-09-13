#include <iostream>
#include "albero.h"
using namespace std;

void init(Tree &t) {
    t=NULL;
}

boolean empty(const Tree &t) {
    boolean res = FALSE;
    if (t==NULL) {
        res = TRUE;
    }
    return res;
}

boolean search(const Tree &t, char val) {
    boolean res;
    if (empty(t)) {
        res = FALSE;
    }
    else {
        if (val==t->val) {
            res = TRUE;
        }
        else if (val<=t->val){
            res = search(t->left, val);
        }
        else if (val>t->val) {
            res = search(t->right, val);
        }
    }
    return res;
}

boolean insert(Tree &t, char val) {
    boolean inserted;
    if (empty(t)) {
        t = new (nothrow) Node;
        if (t==NULL ||
            search(t, val)==TRUE) {
            inserted = FALSE;
        }
        else {
            t->val = val;
            t->left = NULL;
            t->right = NULL;
            inserted = TRUE;
        }
    }
    else if (val<=t->val) {
            inserted = insert(t->left, val);
        }
        else if (val>t->val) {
            inserted = insert(t->right, val);
        }
    return inserted;
}

void deinit(Tree &t) {
    if (!empty(t)) {
        deinit(t->left);
        deinit(t->right);
        delete t;
    }
}

void print(const Tree &t) {
    Tree s = t;
    if(!empty(s)) {
        print(t->left);
        cout << t->val << '\n';
        print(t->right);
    }
}

/* void print_spaces(int depth) {
    for (int i=0; i<depth; i++) {
        cout << "  ";
    }
}

void print_indented(const tree &t) {
    static int depth = 0;
    depth++;
    if (!empty(t)) {
    print_indented(t->right);
    print_spaces(depth);
    cout << t->val << '\n';
    print_indented(t->left);
    }
    depth--;
}
 
void print_indented1(const tree &t, int space){
   if (t != NULL) {
    space ++;
    
    print_indented1(t->right, space);
 
    for (int i = 1; i < space; i++) {
        cout<<"\t";
    }
    cout<<t->val<<"\n";
    
    print_indented1(t->left, space);
   }
} */