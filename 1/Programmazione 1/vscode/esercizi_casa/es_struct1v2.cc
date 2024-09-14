#include <iostream>
#include <cstring>
#include <fstream>
using namespace std;

struct Studente {
    char nome[31];
    char cognome[31];
    int matricola;
    float media;
};

void stampa_database(Studente **S, int dim);
bool riempi_database(Studente **database, char file[], int dim);
Studente * genera_studente(char nome[], char cognome[], int matricola, float media_ponderata);
void stampa_studente(Studente *S);


int main(int argc, char * argv[])
{
    if (argc != 3) {
       cerr << "Error" << endl;
       cerr << "Usage: ./a.out file num" << endl;
       exit (0);
    }
    int dimArray = atoi(argv[2]);
    Studente **database = new Studente*[dimArray];
    if (riempi_database(database, argv[1], dimArray)) {
    stampa_database(database, dimArray);
    }
    for (int i=0; i<dimArray; i++) {
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

bool  riempi_database(Studente **database, char file[],int dim) {
    bool filled = false;
    fstream fin;
    fin.open(file, ios::in);
    int i=0;
    if (fin.fail()) {
        cerr << "Error" << endl;
        exit (0);
    }
    else {char nome[31];
    char cognome[31];
    int matricola;
    float media;
    while (!fin.eof() && i<dim) {
       fin >> nome >> cognome >> matricola >> media;
        database[i] = genera_studente(nome, cognome, matricola, media);
        i++;
    }
    filled = true;
    }
    fin.close();
    return filled;
}

void stampa_database(Studente **S, int dim) {
    for (int i=0; i<dim; i++) {
        stampa_studente(S[i]);
        cout << endl;
    }
}