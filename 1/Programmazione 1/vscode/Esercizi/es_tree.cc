#include <iostream>
#include "alberi_bin.h"

using namespace std;

int main()
{
    tree root;
    init(root);

    char input;
    int num;

    do {
        cout << "Press 'i' to insert a value\n";
        cout << "Press 's' to search for a value\n";
        cout << "Press 'p' to print the tree\n";
        cout << "Press 'e' to exit\n\n";
        cout << "Your choice: ";
        cin >> input;

        switch(input) {
            case 'i':
                cout << "\nNumber: ";
                cin >> num;
                insert_iter(root, num);
                cout << num << " inserted\n";
                break;
            case 's':
                cout << "Number to search: ";
                cin >> num;
                if (search_iterative(num, root) == NULL) {
                    cout << "Couldn't find " << num << " in the tree\n";
                }
                else {
                    cout << num << " found\n";
                }
                break;
            case 'p':
                cout << '\n';
                print_indented(root);
                break;
            default:
                break;

        }

    } while ((input == 'i') || (input == 's') || (input == 'p'));
    

    deinit(root);
    return 0;
}