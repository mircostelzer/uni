#include <iostream>
#include "alberi_bin.h"
using namespace std;

void init(tree &t) {
    t=NULL;
}

bool empty(const tree &t) {
    return (t==NULL);
}

tree search(int val, const tree &t) {
    tree res;
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
        else if (val>t->val) {
            res = search(val, t->right);
        }
    }
    return res;
}

tree search_iterative(int val, const tree &t) {
    tree res;
    if (empty(t)) {
        res = NULL;
    }
    else {
        res = t;
        while ((res->val != val) && (res != NULL)) {
            if (res->val > val) {
                res = res->left;
            }
            else {
                res = res->right;
            }
        }
    }

    return res;
}

bool insert(int val, tree &t) {
    bool inserted;
    if (empty(t)) {
        t = new (nothrow) node;
        if (t==NULL) {
            inserted = false;
        }
        else {
            t->val = val;
            t->left = NULL;
            t->right = NULL;
            inserted = true;
        }
    }
    else if (val<=t->val) {
            inserted = insert(val, t->left);
        }
        else if (val>t->val) {
            inserted = insert(val, t->right);
        }
    return inserted;
}

void insert_iter(tree &root, int num) {
    if (root == NULL) {
        root = new node {num, NULL, NULL};
    }
    else {
        tree t = root;
        tree father;
        while (t != NULL) {
            father = t;
            if (num < t->val) {
                t = t->left;
            }
            else {
                t = t->right;
            }
        }
        tree tmp = new node {num, NULL, NULL};
        if (num < father->val) {
            father->left = tmp;
        }
        else {
            father->right = tmp;
        }
    }

}

void deinit(tree &t) {
    if (!empty(t)) {
        deinit(t->left);
        deinit(t->right);
        delete t;
    }
}

void print_ordered(const tree &t) {
    tree s = t;
    if(!empty(s)) {
        print_ordered(t->left);
        cout << t->val << '\n';
        print_ordered(t->right);
    }
}

void print_spaces(int depth) {
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
}

int countNodes(const tree &t, int lvl=0, int res=0) {
    if (t == nullptr) return res;
    if (t->val == lvl) res++;
    res = countNodes(t->left, lvl++, res) + countNodes(t->right, lvl++, res);
    return res;
}

int main() {
    tree t;
    init(t);

    insert(0, t);
    insert(3, t);
    insert(2, t);
    insert(4, t);
    cout << countNodes(t) << endl;
}