#include <iostream>
#include <cstdlib>
#include <cassert>

struct node {
		char info;
		node * next;
};

void dealloca(node *& s) {
		while(s != NULL) {
				node * t = s;
				s = s->next;
				delete t;
		}
}

void stampa_lista(const char * testo, node * s) {
		std::cout << testo;
		for( ; s!= NULL; s=s->next) {
				std::cout << " " << s->info;
		}
		std::cout << std::endl;
}

// Scrivere qui sotto la dichiarazione della funzione compute_lists ed
// eventuali funzioni accessorie
void compute_lists(const char *string, node *&s1, node *&s2);
// Scrivere qui sopra la dichiarazione della funzione compute_lists ed
// eventuali funzioni accessorie

int main(int argc, char **argv) {
		if (argc != 2) {
				std::cout << "Usage: " << argv[0]
														<< " \"stringa di caratteri\"" << std::endl;
				exit(1);
		}
		node * s1, * s2;
		std::cout << "La stringa da analizzare e': " << argv[1] << std::endl;

		compute_lists(argv[1], s1, s2);

		stampa_lista("Lista s1:", s1);
		stampa_lista("Lista s2:", s2);
		dealloca(s1);
		dealloca(s2);
}

// Scrivere qui sotto la definizione della funzione compute_lists ed
// eventuali funzioni accessorie
char convert(char c) {
    char res;
    if (c>='a' && c<='m') {
        res = 'm' - (c - 'a') + 'A' - 'a';
    }
    else if (c>='n' && c<='z') {
        res = 'z' - (c - 'n') + 'A' - 'a'; 
    }
    
    return res;
}

void compute_lists(const char *string, node *&s1, node *&s2) {
    if (*string == '\0') {
        s1 = NULL;
        s2 = NULL;
        return;
    }
    char c = *string;
    if (c>='a' && c<='m') {
        compute_lists(++string, s1, s2);
        s1 = new node {convert(c), s1};
    }
    else if (c>='n' && c<='z') {
        compute_lists(++string, s1, s2);
        s2 = new node {convert(c), s2};
    }
    else {
        compute_lists(++string, s1, s2);
    }
}
// Scrivere qui sopra la definizione della funzione compute_lists ed
// eventuali funzioni accessorie