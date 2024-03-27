#include <iostream>
#include "stack.h"
#include "queue.h"
using namespace std;

void invert(stack &s, queue &q) {
    init(q);
    while (s!=NULL) {
        int n;
        top(s, n);
        pop(s);
        enqueue(q, n);
    }
    while (q.head!=NULL) {
        int n;
        first(q, n);
        dequeue(q);
        push(s, n);
    }
    deinit(q);
}

int main()
{
    stack s;
    queue q;
    stack_init(s);
    int n;
    while (cin >> n && n!=0) {
        push(s, n);
    }
    stack_print(s);
    invert(s, q);
    stack_print(s);
    stack_deinit(s);
}