#include <iostream>


/* Inserire qui sotto la dichiarazione della funzione extract */
char *extract(const char*);
/* Inserire qui sopra la dichiarazione della funzione extract */

/* Solo di esempio, non fate assunzioni su questo valore */
const int DIM = 255;

int main(int argc, char ** argv) {
  char input_string[DIM+1];
  char * extracted;
  char answer;

  do {
    std::cout << "Inserire la stringa da controllare: ";
    std::cin >> input_string;

    extracted = extract(input_string);
    std::cout << "La stringa estratta e': " << extracted << std::endl;

    delete [] extracted;
    std::cout << "Si vuole inserire un'altra stringa? [*/n]";
    std::cin >> answer;
  } while (answer != '\0' && answer != 'N' && answer != 'n');
  return 0;
}

/* Inserire qui sotto la definizione della funzione estract */
char *extract_aux(const char *string, char *&res, int l) {
    if (*string == '\0') {
        res = new char[l+1];
        res[l] = '\0';
        return res;
    }
    if (*string == '@') {
        string++;
        res = extract_aux(string, res, l+1);
        res[l] = '@';
    }
    else {
        string++;
        res = extract_aux(string, res, l);
    }

    return res;
}

char *extract(const char *string) {
    char *res;
    int l = 0;

    res = extract_aux(string, res, l);

    return res;
}
/* Inserire qui sopra la definizione della funzione estract */