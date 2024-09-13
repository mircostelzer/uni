#include <iostream>
using namespace std;

enum retval {FAIL, OK};

struct node {
    int val;
    node *next;
};

typedef node * stack;

static bool empty(const stack &s) {
    return (s==nullptr);
}

void init(stack &s) {
    s=nullptr;
}

/* void deinit(stack &s) {
    if (s!=nullptr) {
        deinit(s->next);
        delete s;
    }
} */

retval push(stack &s, int n) {
    retval res;
    node *r = new (nothrow) node;
    if (r==NULL) {
        res = FAIL;
    }
    else {
    r->val = n;
    r->next = s;
    s = r;
    res = OK;
    }
    return res;
}

retval top(const stack &s, int &n) {
    retval res;
    if (s==nullptr) {
        res = FAIL;
    }
    else {
        n = s->val;
        res = OK;
    }
    return res;
}

retval pop(stack &s) {
    retval res;
    if (s==nullptr) {
        res = FAIL;
    }
    else {
        node *t = s;
        s = s->next;
        delete t;
        res = OK;
    }
    return res;
}

void print(const stack &s) {
    node *t = s;
    while (t!=NULL) {
        cout << t->val << " ";
        t = t->next;
    }
}

void deinit(stack &s) {
    if (!empty(s)) {
        pop(s);
    }   
}