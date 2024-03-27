#ifndef QUEUE_H
#define QUEUE_H

const int dim = 30;

struct node_q {
    int val;
    node_q *next;
};

struct queue {
    node_q *head;
    node_q *tail;
};

void init(queue &q);

bool empty(const queue &q);

bool enqueue(queue &q, int n);

bool dequeue(queue &q);

bool first(queue &q, int &n);

void print(const queue &q);

void deinit(queue &q);

#endif