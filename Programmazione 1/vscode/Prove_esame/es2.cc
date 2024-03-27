#include <iostream>
using namespace std;

void get_elements_aux(char source[], int dim, int i, char *&dest1, int &dim1, char *&dest2, int &dim2);
void get_elements(char source[], int dim, char *&dest1, int &dim1, char *&dest2, int &dim2);
void print(const char a[], const int s, const char *prefix);
void read_elements(char source[], int max_dim,  int &dim);

int main()
{
    int max_dim = 20;
    int dim = 0;
    char *source = new char [max_dim];
    read_elements(source, max_dim, dim);
    print(source, dim, "Source: ");
    char *dest1;
    int dim1 = 0;
    char *dest2;
    int dim2 = 0;
    get_elements(source, dim, dest1, dim1, dest2, dim2);
    print(dest1, dim1, "D1: ");
    print(dest2, dim2, "D2: ");
    return 0;
}

void get_elements_aux(char source[], int dim, int i, char *&dest1, int &dim1, char *&dest2, int &dim2) {
    if (i >= dim) {
        dest1 = new char [dim1];
        dest2 = new char [dim2];
    }
    else {
        if (source[i]>='a' && source[i]<='z') {
            int tmp = dim1++;
            get_elements_aux(source, dim, i+1, dest1, dim1, dest2, dim2);
            dest1[tmp] = 'Z' - (source[i] - 'a');
        }
        else if (source[i]>='0' && source[i]<='9') {
            int tmp = dim2++;
            get_elements_aux(source, dim, i+1, dest1, dim1, dest2, dim2);
            dest2[tmp] = '9' - (source[i] - '0');
        }
        else {
            get_elements_aux(source, dim, i+1, dest1, dim1, dest2, dim2);
        }
    }

}

void get_elements(char source[], int dim, char *&dest1, int &dim1, char *&dest2, int &dim2) {
dim1 = dim2 = 0;
get_elements_aux(source, dim, 0, dest1, dim1, dest2, dim2);
}

void print(const char a[], const int dim, const char *prefix) {
    cout << prefix;
    for (int i=0; i < dim; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

void read_elements(char source[], int max_dim,  int &dim) {
    char ch = '\0';
    for (dim=0; (dim<=max_dim) && (ch!='\n'); ) {
        cin.get(ch);
        if ((ch!='\n') && (ch!=' ')) {
            source[dim++] = ch;
        }
    }
}