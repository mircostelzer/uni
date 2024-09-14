#include <iostream>
#include "es_email.h"
using namespace std;

/* 1. Deve contenere un solo simbolo @, che divida la parola in due parti,
nella forma: <utente>@<dominio>
2. Entrambe le parole <utente> e <dominio> devono:
a. Avere lunghezza >= 1;
b. Essere formate solo da:
i. lettere minuscole (a-z)
ii. lettere maiuscole (A-Z)
iii. cifre (0-9)
iv. i simboli . (punto) e _ (underscore)
3. Non avere il simbolo . (punto) come prima o ultima lettera; */

bool checkLetter(char ch) {
    return (ch>='a' && ch<='z') ||
           (ch>='A' && ch<='Z') ||
           (ch>='0' && ch<='9') ||
           (ch == '.') || (ch == '_');
}

bool email(char parola[]) {
    bool res = true;
    int at = -1, pt = -1;
    int numAt = 0;
    int i = 0;
    while (parola[i]!='\0') {
            if (parola[i]=='@') {
                at = i;
                numAt++;
            }
            else if (parola[i]=='.') {
                pt = i;
            }
            else if (!checkLetter(parola[i])) {
                res = false;
            }
        i++;
    }
    if (numAt != 1) {
        res = false;
    }
    if (at<=1 || at>=(i-1)) {
        res = false;
    }
    if (pt>=(i-1) || pt<=0) {
        res = false;
    }
    return res;
}