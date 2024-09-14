#include<iostream>
#include <cstdlib>
using namespace std;

struct node {
    int dato;
    node *next;
};

int precede(int x, int t, node *s) {
    int res = -1;
    node *r = s;
    if (r->dato == x) {
        return x;
    }
    else while(s->next!=NULL && res==-1) {
        if (r->dato==t && r->next->dato==x) {
            res  = 1;
        }
    }
    return res;
}

bool findElement(node *s, int x) {
    node *t = s;
    for (;t->next!=NULL; t=t->next) {
        if (t->dato == x) {
            return true;
        }
    }
    return false;
}

int lenght(node *s) {
    if (s == NULL) {
        return 0;
    }
    return 1+(lenght(s->next));
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
    cout << lenght(list) << endl;
    cout << findElement(list, 5) << endl;

}