#ifndef QUEUE_H
#define QUEUE_H

const int dim = 30;

struct node_q {
    char ch;
    node_q *next;
};

struct queue {
    node_q *head;
    node_q *tail;
};

void init(queue &q);

bool empty(const queue &q);

bool enqueue(queue &q, char a);

bool dequeue(queue &q);

bool first(queue &q, char &a);

void print(const queue &q);

void deinit(queue &q);

#endif