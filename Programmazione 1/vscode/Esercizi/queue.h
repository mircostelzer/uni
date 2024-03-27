#ifndef QUEUE_H
#define QUEUE_H
#include "stack.h"

struct queue {
    stack head;
    stack tail;
};

void init(queue &);

bool enqueue(queue &, int);

bool dequeue(queue &);

bool first(const queue &, int &);

void print(const queue &);

void deinit(queue &);


#endif