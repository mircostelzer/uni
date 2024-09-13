#include <iostream>
#include "stack.h"
#include "queue.h"
using namespace std;

typedef node * stack;

static bool empty(const stack &s) {
    return (s==nullptr);
}

void init_s(stack &s) {
    s=nullptr;
}

bool push(stack &s, int n) {
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

bool top(const stack &s, int &n) {
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

bool pop(stack &s) {
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

void print_s(const stack &s) {
    node *t = s;
    while (t!=NULL) {
        cout << t->val << '\n';
        t = t->next;
    }
}

void deinit_s(stack &s) {
    if (!empty(s)) {
        pop(s);
    }   
}