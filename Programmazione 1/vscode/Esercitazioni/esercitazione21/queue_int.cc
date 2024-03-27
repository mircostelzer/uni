#include <iostream>
#include "queue.h"
using namespace std;

/* struct node {
    int val;
    node *next;
}; */

/*vstruct queue {
    node *head;
    node *tail;
}; */

void init(queue &q) {
    q.head = NULL;
}

bool empty(const queue &q) {
    return (q.head == nullptr);
}

bool enqueue(queue &q, int n) {
    node_q *tmp = new (nothrow) node_q;
    if (tmp==nullptr) {
        return false;
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
        return true;
    }
}

bool dequeue(queue &q) {
    if (empty(q)) {
        return false;
    }
    else {
        node_q *t = q.head;
        q.head = q.head->next;
        delete t;
        return true;
    }
}

bool first(queue &q, int &n) {
    if (empty(q)) {
        return false;
    }
    else {
        n = q.head->val;
        return true;
    }
}

void print(const queue &q) {
    if (!empty(q)) {
    node_q *t = q.head;
    do {
        cout << t->val << " ";
        t = t->next;
    }
    while (t!=nullptr);
    }
    cout << '\n';
}

void deinit(queue &q) {
    if (!empty(q)) {
        dequeue(q);
    }

}