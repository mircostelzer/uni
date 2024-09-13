#include <iostream>
#include <cstring>
#include "queue.h"
using namespace std;

void init(queue &q) {
    q.head = NULL;
}

bool empty(const queue &q) {
    return (q.head == nullptr);
}

bool enqueue(queue &q, char a) {
    node_q *tmp = new (nothrow) node_q;
    if (tmp==nullptr) {
        return false;
    }
    else {
        tmp->ch = a;
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

bool first(queue &q, char &a) {
    if (empty(q)) {
        return false;
    }
    else {
        a = q.head->ch;
        return true;
    }
}

void print(const queue &q) {
    if (!empty(q)) {
    node_q *t = q.head;
    do {
        cout << t->ch << endl;
        t = t->next;
    }
    while (t!=nullptr);
    }
    cout << '\n';
}

void deinit(queue &q) {
    char tmp;
    while (first(q, tmp)) {
        dequeue(q);
    }

}