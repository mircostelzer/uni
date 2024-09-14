#ifndef ES_STRUCT_H
#define ES_STRUCT_H
using namespace std;
#include <iostream>
#include <cstring>

const int NmaxPers = 1000;
const int NmaxNome = 30;
const int NmaxCognome = 30;

struct address {
  char via[NmaxNome];
  int civico;
  char comune[NmaxNome];
  int cap;
  char prov[3];
};

struct persona {
  char nome[NmaxNome];
  char cognome[NmaxCognome];
  address indirizzo;
};

struct gruppo {
  int npers;
  persona persone [NmaxPers];
};

// elementi base
void leggi_indirizzo (address &a);
void stampa_indirizzo (const address & a);
void leggi_nome (char s[]);
void stampa_nome (const char s[]);
void leggi_cognome (char s[]);
void stampa_cognome (const char s[]);

// persona
void stampa_persona(const persona & p);
void leggi_persona(persona & p);

// gruppo di persone
void inizializza_gruppo(gruppo &g);
bool inserisci_persona(const persona & p, gruppo & g);
bool leggieinserisci_persona(gruppo & g);
void stampa_gruppo(const gruppo & g);

void swap (persona &p1, persona &p2);
void ordina_per_cognome(gruppo & g);
int cerca_per_cognome(char cognome[],gruppo & g);
int cerca_per_cognome1(char cognome[],persona *p,int inizio,int fine);


#endif