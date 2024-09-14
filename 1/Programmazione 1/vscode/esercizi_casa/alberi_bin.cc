#include <iostream>
using namespace std;

struct node;

typedef node * albero;

struct node {
    int val;
    albero left;
    albero right;
};

void init(albero &t) {
    t=NULL;
}

bool empty(const albero &t) {
    return (t==NULL);
}

albero search(int val, albero &t) {
    albero res;
    if (empty(t)) {
        res = NULL;
    }
    else {
        if (val==t->val) {
            res = t;
        }
        else if (val<t->val){
            res = search(val, t->left);
        }
        else if (val>=t->val) {
            res = search(val, t->right);
        }
    }
    return res;
}

bool insert(int val, albero &t) {
    if (empty(t)) {
        t = new (nothrow) node;
        if (t==NULL) {
            return false;
        }
        else {
            t->val = val;
            t->left = NULL;
            t->right = NULL;
        }
    }
    else {
        if (val<t->val) {
            insert(val, t->left);
        }
        else {
            insert(val, t->right);
        }
        return true;
    }
}

void deinit(albero &t) {
    if (!empty(t)) {
        deinit(t->left);
        deinit(t->right);
        delete t;
    }
}

void print_ordered(const albero &t) {
    albero s = t;
    if(!empty(s)) {
        print_ordered(t->left);
        cout << t->val << " ";
        print_ordered(t->right);
    }
    cout << '\n';
}

void print_spaces(int depth) {
    for (int i=0; i<depth; i++) {
        cout << " ";
    }
}

void print_indented(const albero &t) {
    static int depth = 0;
    depth++;
    print_indented(t->left);
    print_spaces(depth);
    cout << t->val << '\n';
    print_indented(t->right);
    depth--;
}