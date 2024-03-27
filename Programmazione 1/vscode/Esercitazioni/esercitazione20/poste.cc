#include <iostream>
#include "queue.h"
#include <cstring>
using namespace std;

bool is_in_queue(queue &q, char *a) {
    node * tmp = q.head;
    while (tmp!=NULL) {
        if (strcmp(a, tmp->name)==0) {
            return true;
        }
        tmp = tmp->next;
    }
    return false;
}

int main()
{
    queue q;
    init(q);
    char option;
    do {
        cout << "'\t'Aggiungi persona in coda: [a]" << endl;
        cout << "'\t'Smaltisci persona: [s]" << endl;
        cout << "'\t'Stampa situazione corrente: [p]" << endl;
        cout << "'\t'Esci: [e]" << endl;
        cout << "'\t'Scegliere opzione: ";
        cin >> option;
        cout << endl;
        switch(option) {
            case 'a': {
                char name[dim];
                cout << "Nome: ";
                cin >> name;
                if (is_in_queue(q, name)) {
                    cout << "Già presente in coda" << endl;
                }
                else {
                enqueue(q, name);
                }
            } break;
            case 's': {
                if (!dequeue(q)) {
                    cout << "Fila vuota" << endl;
                }
            } break;
            case 'p': {
                print(q);
                if (q.head==NULL) {
                    cout << "Fila vuota" << endl;
                }
            } break;
            default: {deinit(q);}
        }
    }
    while (option=='a' || option=='s' || option=='p');
}