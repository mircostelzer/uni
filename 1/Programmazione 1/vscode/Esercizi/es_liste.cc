#include <iostream>
#include <cstdlib>

struct node {
    int val;
    node *next;
};

void print_list(node *t) {
    node * s = t;
    while (s!=NULL) {
        std::cout << s->val << " ";
        s = s->next;
    }
    std::cout << '\n';
}

node *convert(node *t) {
    node *res = NULL;
    node *s = t;
    while (s->next!=NULL) {
        node *tmp = s->next;
        while ((tmp->val<s->val) || tmp!=NULL) {
            tmp = tmp->next;
        }
        node *x = new node;
        if (tmp == NULL) {
            x->val = 0;
        }
        else {
            x->val = tmp->val;
        }
        x->next = res;
        res = x;
        s = s->next;
    }
    return res;
}

void delete_list(node *t) {
    if (t!=NULL) {
        delete_list(t->next);
        delete t;
    }
}


int main()
{
    srand(time(NULL));
    node *list = NULL;
    for (int i=0; i<10; i++) {
        node *t = new node;
        t->val = rand()%10 + 1;
        t->next = list;
        list = t;
    }
    node *list1;
    list1 = convert(list);
    print_list(list);
    // print_list(list1);
    delete_list(list1);
    delete_list(list);
    return 0;
}