#include <iostream>
#include <cstring>
#include <fstream>
using namespace std;

const int dim = 100;

struct Studente {
    char nome[31];
    char cognome[31];
    int matricola;
    float media;
};

void stampa_database(Studente **S);
bool riempi_database(Studente **database, char file[], int &pos);
Studente * genera_studente(char nome[], char cognome[], int matricola, float media_ponderata);
void stampa_studente(Studente *S);
int cerca_matricola(Studente **database, int matricola, int dim);
int cerca_nome_e_cognome(Studente **database, char nome[], char cognome[], int dim);
int studente_top_media(Studente **database, int dim);


int main(int argc, char * argv[])
{
    Studente **database = new Studente *[dim];
    int elements = 0;
    char choice;
    do {
        cout << '\n';
        cout << "'\t'Azioni possibili: " << '\n';
        cout << "'\t'Carica da file esterno: [c]" << '\n';
        cout << "'\t'Aggiungi un utente: [a]" << '\n';
        cout << "'\t'Cerca per matricola: [m]" << '\n';
        cout << "'\t'Cerca per nome e cognome: [n]" << '\n';
        cout << "'\t'Ritorna l'utente con la media più alta: [u]" << '\n';
        cout << "'\t'Esci: [e]" << '\n';
        cout << "'\t'Inserisci scelta: ";
        cin >> choice;
        cout << '\n';
        switch(choice) {
            case 'c': {
                char file[50];
                cout << "Nome del file: ";
                cin >> file;
                if (riempi_database(database, file, elements)) {
                    cout << "Operazione riuscita" << '\n';
                }
            }
            break;
            case 'a': {
                if (elements>=dim) {
                    cout << "Azione non valida" << '\n' << "Raggiunta dimensione massima database" << '\n';
                }
                else {
                char nome[31];
                char cognome[31];
                int matricola;
                int media;
                cout << "Nome: ";
                cin >> nome; 
                cout << "Cognome: ";
                cin >> cognome; 
                cout << "Matricola: ";
                cin >> matricola;
                cout << "Media: ";
                cin >> media;
                database[elements] = genera_studente(nome, cognome, matricola, media);
                elements++; }
        }
        break;
        case 'm': { int m, i;
            cout << "Inserire numero matricola: ";
            cin >> m;
            i = cerca_matricola(database, m, elements);
            if (i == -1) {
                cout << "Utente non trovato" << '\n';
            }
            else { stampa_studente(database[i]); } }
            break;
        case 'n': { char nome[31], cognome[31];
            cout << "Nome: ";
            cin >> nome;
            cout << "Cognome: ";
            cin >> cognome;
            int i = cerca_nome_e_cognome(database, nome, cognome, elements);
            if (i == -1) {
                cout << "Utente non trovato" << '\n';
            }
            else { stampa_studente(database[i]); } }
            break;
        case 'u': { int i = studente_top_media(database, elements);
            stampa_studente(database[i]); }
            break;
    }
    }
    while (choice=='c' || choice=='a' || choice=='m' || choice=='n' || choice=='u');
    for (int i=0; i<dim; i++) {
       delete database[i];
    }
    delete[] database;
    
    return 0;
}




void stampa_studente(Studente *S) {
    cout << "Nome: " << S->nome << endl;
    cout << "Cognome: " << S->cognome << endl;
    cout << "Matricola: " << S->matricola << endl;
    cout << "Media: " << S->media << endl;
}

Studente * genera_studente(char nome[], char cognome[], int matricola, float media_ponderata) {
    Studente *S = new Studente;
    strcpy(S->nome, nome);
    strcpy(S->cognome, cognome);
    S->matricola = matricola;
    S->media = media_ponderata;
    return S;
}

bool riempi_database(Studente **database, char file[], int &pos) {
    bool filled = false;
    fstream fin;
    fin.open(file, ios::in);
    if (fin.fail()) {
        cerr << "Error" << endl;
        exit (0);
    }
    else {char nome[31];
    char cognome[31];
    int matricola;
    float media;
    while ((!fin.eof()) && pos<dim) {
       fin >> nome >> cognome >> matricola >> media;
        database[pos] = genera_studente(nome, cognome, matricola, media);
        pos++;
    }
    filled = true;
    }
    fin.close();
    return filled;
}

void stampa_database(Studente **S) {
    for (int i=0; i<dim; i++) {
        stampa_studente(S[i]);
        cout << endl;
    }
}

int cerca_matricola(Studente **database, int matricola, int dim){
    bool found = false;
    int res;
    for (int i=0; (i<dim) && (!found); i++) {
        if (database[i]->matricola==matricola) {
            res = i;
            found = true;
        }
        else res = -1;
    }
    return res;
}

int cerca_nome_e_cognome(Studente **database, char nome[], char cognome[], int dim){
    bool found = false;
    int res;
    for (int i=0; (i<dim) && (!found); i++) {
        if ((strcmp(database[i]->nome, nome)==0) && (strcmp(database[i]->cognome, cognome)==0)) {
            res = i;
            found = true;
        } 
        else res = -1;
    } 
    return res;
}

int studente_top_media(Studente **database, int dim) {
    int max = 0;
    int res;
    for (int i=1; i<dim; i++) {
        if ((database[i]->media)>max) {
            max = database[i]->media;
            res = i;
        }
    }
    return res;
}
