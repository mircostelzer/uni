#ifndef QUEUE_H
#define QUEUE_H

struct node {
    int val;
    node *next;
};

struct queue {
    node *head;
    node *tail;
};

void init(queue &);

bool empty(const queue &);

bool enqueue(queue &, int);

bool dequeue(queue &);

bool first(const queue &, int &);

void print(const queue &);

void deinit(queue &);

#endif