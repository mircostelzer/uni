#include <iostream>
using namespace std;

int main(int argc, char *argv[])
{
    if (argc!=4) {
        cout << "Errore!" << endl;
        exit(0);
    }
    int a, b, op;
    a = atof(argv[1]);
    b = atof (argv[2]);
    op = argv[3][0];
    switch (op) {
        case '+': {
        cout << a + b << endl;
    }
    case '-': {
        cout << a - b << endl;
    }
    case '*': {
        cout << a * b << endl;
    }
    case '/': {
        if (b==0) {
            cout << "Errore";
            exit(0);
        }
        else {
        cout << a / b << endl;
    }
}
    default: {
        cout << "Errore";
        exit (0);
    }
}
}

