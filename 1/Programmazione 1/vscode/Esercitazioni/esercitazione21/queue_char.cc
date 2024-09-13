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

bool enqueue(queue &q, char *a) {
    node *tmp = new (nothrow) node;
    char *name = new (nothrow) char[dim];
    if (tmp==nullptr) {
        return false;
    }
    else {
        strcpy(name, a);
        tmp->name = name;
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
        node *t = q.head;
        q.head = q.head->next;
        delete t;
        return true;
    }
}

bool first(queue &q, char *&a) {
    if (empty(q)) {
        return false;
    }
    else {
        a = q.head->name;
        return true;
    }
}

void print(const queue &q) {
    if (!empty(q)) {
    node *t = q.head;
    do {
        cout << t->name << endl;
        t = t->next;
    }
    while (t!=nullptr);
    }
    cout << '\n';
}

void deinit(queue &q) {
    char *tmp;
    while (first(q, tmp)) {
        delete[] tmp;
        dequeue(q);
    }

}