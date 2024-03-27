#ifndef ALBERI_BIN_H
#define ALBERI_BIN_H

struct node;

typedef node * tree;

struct node {
    int val;
    tree left;
    tree right;
};

void init(tree &);

void deinit(tree &);

tree search(int, const tree &);

bool insert(int, tree &);

void print_ordered(const tree &);

void print_indented(const tree &);

void print_indented1(const tree &, int=0);

#endif