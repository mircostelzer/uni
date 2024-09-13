#ifndef STACK_H
#define STACK_H
#include <iostream>
using namespace std;

enum retval {FAIL, OK};

struct node {
    int val;
    node *next;
};

typedef node * stack;

void stack_init(stack &s);

void stack_deinit(stack &s);

retval push(stack &s, int n);

retval top(const stack &s, int &n);

retval pop(stack &s);

void stack_print(const stack &s);

#endif