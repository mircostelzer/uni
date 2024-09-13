#include <iostream>
#include "stack.h"
using namespace std;

typedef node * stack;

static bool nempty(const stack &s) {
    return (s!=nullptr);
}

void init(stack &s) {
    s=nullptr;
}

bool add(stack &s, long n) {
    bool res;
    node *r = new (nothrow) node;
    if (r==NULL) {
        res = false;
    }
    else {
    r->val = n;
    r->next = s;
    s = r;
    res = true;
    }
    return res;
}

bool first(const stack &s, long &n) {
    bool res;
    if (s==nullptr) {
        res = false;
    }
    else {
        n = s->val;
        res = true;
    }
    return res;
}

bool shrink(stack &s) {
    bool res;
    if (s==nullptr) {
        res = false;
    }
    else {
        node *t = s;
        s = s->next;
        delete t;
        res = true;
    }
    return res;
}

void print(const stack &s) {
    node *t = s;
    while (t!=NULL) {
        cout << t->val << '\n';
        t = t->next;
    }
}

void deinit(stack &s) {
    if (!nempty(s)) {
        shrink(s);
    }   
}