#include <iostream>
#include "stack.h"
#include "queue.h"


using namespace std;


void init(queue &Q) {
    init_s(Q.head);
    init_s(Q.tail);
}

bool enqueue(queue &Q, int n) {
    bool res = false;
    if ((Q.tail == NULL) && (Q.head == NULL)) {
        if (push(Q.head, n)) {
            res = true;
        }
    }
    else {
        if (push(Q.tail, n)) {
            res = true;
        }
    }

    return res;
}

bool first(const queue &Q, int &n) {
    bool res;
    if (Q.head == NULL) {
        res = false;
    }
    else {
        top(Q.head, n);    
        res = true;
    }

    return res;
}   

bool dequeue(queue &Q) {
    bool res;
    if (Q.head == NULL) {
        res = false;
    }
    else {
        pop(Q.head);
        int n;
        while (Q.tail!=NULL) {
            int tmp;
            top(Q.tail, tmp);
            push(Q.head, tmp);
            pop(Q.tail);
        }
        top(Q.head, n);
        pop(Q.head);
        while(Q.head!=NULL) {
            int tmp;
            top(Q.head, tmp);
            push(Q.tail, tmp);
            pop(Q.head);
        }
        push(Q.head, n);
        res = true;
    }

    return res;
}

void print(const queue &Q) {
    print_s(Q.head);
    node *h = Q.head;
    node *t = Q.tail;
    int n;
    top(h, n);
    pop(h);
    while (t!=NULL) {
        int tmp;
        top(t, tmp);
        push(h, tmp);
        pop(t);
    }
    print_s(h);
    while (h!=NULL) {
        int tmp;
        top(h, tmp);
        push(t, tmp);
        pop(h);
    }
    push(h, n);
}

void deinit(queue &Q) {
    deinit_s(Q.head);
    deinit_s(Q.tail);
}