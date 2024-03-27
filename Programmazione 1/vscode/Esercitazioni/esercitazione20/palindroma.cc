#include <iostream>
#include "stack.h"
#include "queue.h"
using namespace std;

bool isPalindrome(char word[], stack &s, queue &q) {
    bool res = true;
    init(q);
    stack_init(s);
    for (int i=0; word[i]!='\0'; i++) {
        char c = word[i];
        push(s, c);
        enqueue(q, c);
    }
    char c, c1;
    while(top(s, c) && first(q, c1)) {
        if (c!=c1) {
            res = false;
        }
        pop(s);
        dequeue(q);
    }
    stack_deinit(s);
    deinit(q);
    return res;
}

int main()
{
    stack s;
    queue q;
    char word[30];
    cout << "Inserire parola: ";
    cin >> word;
    if (isPalindrome(word, s, q)) {
        cout << "La parola è palindroma\n";
    }
    else {
        cout << "La parola non è palindroma\n";
    }
    return 0;
}