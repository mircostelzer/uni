#include <iostream>


/* Inserire qui sotto la dichiarazione della funzione extract */
char *extract(char string[]);
int read_ats(char string[], int i);
void insert_ats(char *string, int l, int i);
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
int read_ats(const char string[], int i) {
    int res;
    if (string[i] == '\0') {
        res = 0;
    }
    else if (string[i] == '@') {
        res = 1 + read_ats(string, i+1);
    }
    else {
        res = read_ats(string, i+1);
    }
   return res; 
    
}

void insert_ats(char *string, int l, int i) {
    if (l == 0) {
        string[i] = '\0';
        return;
    }
    else {string[i] = '@';
    insert_ats(string, l-1, i+1);
    }
}

char *extract(const char string[]) {
    int l = read_ats(string, 0);
    char *res = new char [l+1];
    if (l == 0) {
        res[0] = '\0';
    }
    else {
        insert_ats(res, l, 0);
    }
    return res;
}
/* Inserire qui sopra la definizione della funzione estract */