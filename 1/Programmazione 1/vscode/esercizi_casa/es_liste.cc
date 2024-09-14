#include <iostream>
#include <cstdlib>
using namespace std;

struct node {
    int dato;
    node *next;
};

bool findElement(node *s, int x) {
    node *n = s;
    while (n != NULL) {
        if (n->dato==x) {
            return true;
        }
        n = n->next;
    }
    return false;
}

void print_list(node *s) {
    node *t = s;
    while (t!=nullptr) {
        cout << t->dato << " ";
        t = t->next;
    }
    cout << '\n';
}

node *precede(node *s, node *x) {
    if (s==x) return x;
    if (s==nullptr || s->next==nullptr) {
        return nullptr;
    }
    node *t = s;
    node *r = s->next;    
    while (r!=x && r!=nullptr) {
        t = t->next;
        r = r->next;
    }
    if (r==nullptr) {
        return nullptr;
    }
    return t;
}

void insert_node(node *s, node *t) {
    t->next = s->next;
    s->next = t;
}

void insert_first(node *&s, int d) {
    node *n = new node;
    n->dato = d;
    n->next = s;
    s = n;
}

void insert_last(node *&s, int d) {
    node *n = new node;
    n->dato = d;
    n->next = NULL;
    if (s != NULL) {
        node *r = s;
        while (r != NULL) {
            r = r->next;
        }
        r->next = n;
    }
    else s = n;
}

void insert_order(node *&s, int d) {
    if (s==nullptr || s->dato>=d) {
        insert_first(s, d);
    }
    else {
        node *t = s;
        while (t->next!=nullptr || t->next->dato>d) {
            t = t->next;
        }
        node *r = new node;
        r->dato = d;
        r->next = t->next;
        t->next = r;
    }
}

/* void move_to_last(node *&s) {
    if (s!=nullptr) {
        node *t = s;
        int max = t->dato;
        while (t->next!=nullptr) {
            if (t->next->dato>max) {
                max = t->next->dato;
                node *r = t->next;
                t->next = r->next;
                delete r;
                insert_last(s, max);
            }
        }
    }
} */

void remove_first(node *&s) {
    if (s!=nullptr) {
        node *t = s;
        s = s->next;
        delete t;
    }
}

void remove_element(node *&s, int d) {
    if (s!=nullptr) {
        node *t = s;
        if (t->dato==d) {
            remove_first(s);
        }
        else {
            while (t->next!=nullptr) {
                if (t->next->dato==d) {
                    node *r = t->next;
                    t->next = t->next->next;
                    delete r;
                }
                else {
                    t = t->next;
                }
            }
    }
    }
}

node *copia(node *s) {
    node *t = NULL;
    node *r = s;
    while (r!=nullptr) {
        node *y = r->next;
        node *tmp = s;
        while (y!=nullptr) {
            y = y->next;
            tmp = tmp->next;
        }
        node *x = new node;
        x->dato = tmp->dato;
        x->next = t;
        t = x;
        r = r->next;
    }

    return t;
}

node *copia_rec(node *s) {
    if (s==nullptr) {
        return nullptr;
    }
    node *t = new node;
    t->dato = s->dato;
    t->next = copia_rec(s->next);
    return t;
}

void delete_list(node *s) {
    node *r = s;
    while (r !=NULL) {
    node *n = r;
    r = r->next;
    delete n;
    }
}

int main()
{
    srand(time(NULL));
    node *list = NULL;
    for (int i=0; i<10; i++) {
        int d = rand()%10;
        node *t = new node;
        t->dato = d;
        t->next = list;
        list = t; 
    }
    node *list1 = copia_rec(list);
    print_list(list);
    print_list(list1);
    // move_to_last(list);
    print_list(list);
    delete_list(list);
    delete_list(list1);
}