#ifndef STACK_H
#define STACK_H
#include <iostream>
using namespace std;

struct node {
    int val;
    node *next;
};

typedef node * stack;

void init(stack &);

void deinit(stack &);

bool push(stack &, int);

bool top(const stack &, int &);

bool pop(stack &);

void print(const stack &);

#endif