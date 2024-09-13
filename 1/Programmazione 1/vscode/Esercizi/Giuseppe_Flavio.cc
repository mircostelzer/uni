#include <iostream>
#include <cstring>
using namespace std;

struct node{
    char name[30];
    node *left;
};

int main(int argc, char * argv[])
{
    if (argc != 3) {
        cout << "Usage: a.out <N> <M>\n";
        exit (1);
    }
    int N = atoi(argv[1]);
    int M = atoi(argv[2]);
    node *Person = new node;
    char name[30];
    cin >> name;
    strcpy(Person->name, name);
    Person->left = nullptr;
    Person->left = Person;
    node *t = Person;
    for (int i=1; i<N; i++) {
    node *p = new node;
    cin >> name;
    strcpy(p->name, name);
    p->left = Person;
    t->left = p;
    t = t->left;
    }
    cout << Person->name << endl; 
    for (node *l = Person->left; l!=Person; l = l->left) {
        cout << l->name << endl;
    }
    while (t!=t->left) {
        for (int i=0; i<M; i++) {
            t = t->left;
        }
        node *r = t->left;
        t->left = t->left->left;
        r->left = nullptr;
        cout << "Rimozione di " << r->name << endl;
        delete r;
    }
    cout << "Leader: " << t->name << endl;
}