#include <iostream>
#include <fstream>
using namespace std;

struct node {
    int dato;
    node *next;
};

void insert_node(node *&s, int n) {
    node *t = new node;
    t->dato = n;
    t->next = NULL;
    if (s!=NULL) {
        node *r = s;
        while (r->next!=NULL) {
            r = r->next;
        }
        r->next = t;
    }
    else s = t;
}

void delete_list(node *&s) {
    node *t = s;
    while (t != NULL) {
        node *r = t;
        t = t->next;
        delete r;
    }
}

void delete_list_rec(node *&s) {
    if (s!=NULL) {
        delete_list(s->next);
        delete s;
    }
}

void print_list(node *s) {
    while (s != NULL) {
        cout << s->dato << " ";
        s = s->next;
    }
    cout << '\n';
}

int lenght(node *s) {
    node *t = s;
    int l = 0;
    for (; t!= NULL; t=t->next) {
        l++;
    }
    return l;
}

void print_inverted(node *s) {
    if (s!=NULL) {
    int count = lenght(s)-1;
    while (count >= 0) {
        node *r = s;
        int tmp = count;
        while (tmp > 0) {
            r = r->next;
            tmp--;
        }
        cout << r->dato << " ";
        count--;
    }
    cout << '\n';
    }
}

void print_inverted_rec(node *s) {
    if (s->next != NULL) {
        print_inverted_rec(s->next);
    }
    cout << s->dato << " ";
}

bool isPrime(int n) {
    for (int i=2; i<=(n/2); i++) {
        if (n%i==0) {
            return false;
        }
    }
    return true;
}

node *remove_node(node *&s) {
    node *t = s->next;
    s->next = t->next;
    t->next = NULL;
    return t;
} 

node *prime_numbers(node *&s) {
    node *t = s;
    node *prev = NULL;
    node *x = s;
    while (x!=NULL) {
        if (!isPrime(x->dato)) {
           if (x == t) {
            t = x->next;
            delete x;
            x = t;
           }
           else {
            prev->next = x->next;
            delete x;
            x = prev->next;
           } 
        }
        else {
            prev = x;
            x = x->next;
    }
    }
    return t;
}

int main(int argc, char *argv[])
{
    if (argc != 2) {
        cerr << "Usage: ./a.out <file>" << endl;
        exit (0);
    }
    node *list = NULL;
    fstream fin;
    fin.open(argv[1], ios::in);
    if (fin.fail()) {
        cerr << "Errore nell'apertura del file" << endl;
        exit (0);
    }
    else {
        int n;
        while (!fin.eof()) {
            fin >> n;
            insert_node(list, n);
        }
        print_list(list);
        print_inverted_rec(list);
        list = prime_numbers(list);
        print_list(list);
        delete_list(list);
    }
    fin.close();
}