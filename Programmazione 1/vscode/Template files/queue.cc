#include <iostream>
#include "queue.h"
using namespace std;

void init(queue &q) {
    q.head = NULL;
}

bool empty(const queue &q) {
    return (q.head == nullptr);
}

bool enqueue(queue &q, int n) {
    bool res;
    node *tmp = new (nothrow) node;
    if (tmp==nullptr) {
        res = false;
    }
    else {
        tmp->val = n;
        tmp->next = nullptr;
        if (empty(q)) {
            q.head = tmp;
        }
        else {
            q.tail->next = tmp;
        }
        q.tail = tmp;
        res = true;
    }
    return res;
}

bool dequeue(queue &q) {
    bool res;
    if (empty(q)) {
        res = false;
    }
    else {
        node *t = q.head;
        q.head = q.head->next;
        delete t;
        res = true;
    }
    return res;
}

bool first(const queue &q, int &n) {
    bool res;
    if (empty(q)) {
        res = false;
    }
    else {
        n = q.head->val;
        res = true;
    }
    return res;
}

void print(const queue &q) {
    if (!empty(q)) {
    node *t = q.head;
    do {
        cout << t->val << '\n';
        t = t->next;
    }
    while (t!=nullptr);
    }
}

void deinit(queue &q) {
    if (!empty(q)) {
        dequeue(q);
    }

}