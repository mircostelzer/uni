#include <iostream>
#include <cstdlib>
using namespace std;

struct node {
    int dato;
    node *next;
};

int lenght(node *s) {
    int l=0;
    while (s!=nullptr) {
        l++;
        s = s->next;
    }
    return l;
}

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
        t = r;
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
    if (s == NULL) {
        s = n;
    }
    else {
        node *r = s;
        while (r->next != NULL) {
            r = r->next;
        }
        r->next = n;
    }
}

void insert_order(node *&s, int d) {
    if (s==nullptr || s->dato>=d) {
        insert_first(s, d);
    }
    else {
        node *t = s;
        while ((t->next!=nullptr) && (t->next->dato<=d)) {
            t = t->next;
        }
        node *r = new node;
        r->dato = d;
        r->next = t->next;
        t->next = r;
    }
}

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
            s = s->next;
            delete t;
        }
        else {
            while (t->next!=nullptr) {
                if (t->next->dato==d) {
                    node *r = t->next;
                    t->next = t->next->next;
                    delete r;
                    return;                }
                else {
                    t = t->next;
                }
            }
    }
    }
}

node *reverse(node *s) {
    node *t;
    node *y = s;
    node *r = nullptr;
    while (y!=nullptr) {
        t = y->next;
        y->next = r;
        r = y;
        y = t;
    }
    return r;
}

node *reverse_copia(node *s) {
    node *t = nullptr;
    while (s!=nullptr) {
        node *r = new node;
        r->dato = s->dato;
        r->next = t;
        t = r;
        s = s->next;
    }
    return t;
}

void move_to_last_max(node *&s) {
    if (s!=nullptr) {
        node *t = s;
        int max = t->dato;
        while (t->next!=nullptr) {
            if (t->next->dato>max) {
                max = t->next->dato;
            }
            t = t->next;
        }
        remove_element(s, max);
        insert_last(s, max);
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

void delete_rec(node *s) {
    if (s!=nullptr) {
        delete_rec(s->next);
        delete s;
    }
}

node *append(node *x, node *y) {
    if (x==nullptr) {
        return y;
    }
    if (y==nullptr) {
        return x;
    }
    node *t = x;
    while (t->next!=nullptr) {
        t = t->next;
    }
    t->next = y;
    return x;
}

node *append_rec(node *x, node *y) {
    if (x==nullptr) {
        return y;
    }
    x->next = append_rec(x->next, y);
    return x;
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
    node *list1;
    print_list(list);
    list1 = copia_rec(list);
    print_list(list1);
    delete_rec(list);
    delete_rec(list1);
}