#ifndef STACK_H
#define STACK_H
#include <iostream>
using namespace std;

struct node {
    int val;
    node *next;
};

typedef node * stack;

void init_s(stack &);

void deinit_s(stack &);

bool push(stack &, int);

bool top(const stack &, int &);

bool pop(stack &);

void print_s(const stack &);

#endif