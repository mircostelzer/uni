#include <iostream>
using namespace std;

enum retval {FAIL, OK};

struct node {
    char ch;
    node *next;
};

typedef node * stack;

static bool empty(const stack &s) {
    return (s==nullptr);
}

void stack_init(stack &s) {
    s=nullptr;
}

/* void deinit(stack &s) {
    if (s!=nullptr) {
        deinit(s->next);
        delete s;
    }
} */

retval push(stack &s, char ch) {
    retval res;
    node *r = new (nothrow) node;
    if (r==NULL) {
        res = FAIL;
    }
    else {
    r->ch = ch;
    r->next = s;
    s = r;
    res = OK;
    }
    return res;
}

retval top(const stack &s, char &ch) {
    retval res;
    if (s==nullptr) {
        res = FAIL;
    }
    else {
        ch = s->ch;
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

void stack_print(const stack &s) {
    node *t = s;
    while (t!=NULL) {
        cout << t->ch << " ";
        t = t->next;
    }
}

void stack_deinit(stack &s) {
    if (!empty(s)) {
        pop(s);
    }   
}