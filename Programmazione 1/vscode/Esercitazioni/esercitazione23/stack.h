#ifndef STACK_H
#define STACK_H
#include <iostream>
using namespace std;

struct node {
    long val;
    node *next;
};

typedef node * stack;

void init(stack &);

void deinit(stack &);

bool add(stack &, long);

bool first(const stack &, long &);

bool shrink(stack &);

void print(const stack &);

#endif