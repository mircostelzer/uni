#include <iostream>
#include <fstream>
#include <cstring>
using namespace std;

/* Scrivere un programma che prenda in input un testo e riporti in
   output il numero di occorrenze di ogni carattere. */

const int dim = 50;

int main() 
{
   fstream fin;
   fin.open("a.txt", ios::in);
   char c,word[dim];
   
   while (!fin.fail() && !fin.eof()) {
      int count=1;
      fin.get(c);
      fin.open("a.txt", ios::in);
      while(!fin.fail() && !fin.eof()) {
         fin >> word;
         for (int i=0; i!='\0'; i++) {
            if (word[i]==c) {
               count ++;
            }
            }
            cout << c << " -> " << count << endl;
         }
         fin.close();
      }
   fin.close();     
}

