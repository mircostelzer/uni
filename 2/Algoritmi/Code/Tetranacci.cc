#include <iostream>

using namespace std;

int tetranacci(int n) {
    int res = 0;
    if (n < 0) {
        res = 0;
    }
    else if (n == 0) {
        res = 1;
    }
    else {
        for (int i=1; i<=4; i++) {
            res += tetranacci(n-i);
        }
    }
    return res;
}

int main() {

    for (int i=0; i<=7; i++) {
        cout << tetranacci(i) << endl;
    }

}