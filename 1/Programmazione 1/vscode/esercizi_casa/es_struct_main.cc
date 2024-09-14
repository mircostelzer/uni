using namespace std;
#include <iostream>
#include <cstring>
#include "es_struct.h"

int main ()
{
  int pos;
  char cognome[NmaxCognome];
  gruppo comune;
  char s[2];

  inizializza_gruppo(comune);
  do {
    cout << endl;
    cout << " i: inserisci\n";
    cout << " s: stampa\n";
    cout << " c: cerca per cognome\n";
    cout << " e: esci\n";
    cout << "\nLeggi Scelta: ";
    cin >> s;

    switch (s[0]) {
    case 'i': if (! leggieinserisci_persona(comune))
	cout << "Gruppo pieno\n";
      break;
    case 's': stampa_gruppo(comune); break;
    case 'c': leggi_cognome(cognome);
      pos=cerca_per_cognome(cognome,comune);
      if (pos==-1)
        cout << "Non trovato\n";
      else {
        cout << "Trovato in posizione " << pos+1 << endl;
        stampa_persona(comune.persone[pos]);
      }
      break;
    case 'e': break;
    default: cout << "scelta non capita\n";
    }
  }
  while ((s[0]=='i' || s[0]=='s' || s[0]=='o' || s[0]=='c'));
}