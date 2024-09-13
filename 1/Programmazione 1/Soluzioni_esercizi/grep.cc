#include <fstream>
#include <cstring>
#include <iostream>

using namespace std;

bool grep_helper(const char * s, fstream *f) {
  char c;
  int m = 0;
  while ((*f).get(c)) {
    if (s[m] == '\0') return true;
    if (c == s[m]) m++;
    else m = 0;
  }
  return false;
}

bool grep(const char * s, fstream files[], const int n ) {
  for(int f=0; f < n; f++) {
    if (grep_helper(s, &(files[f]))) return true;
  }
  return false;
}

int main_v1(int argc, char * argv[]) {
  if (argc < 3) {
    std::cerr << "Errore" << std::endl;
    return 1;
  }
  char * stringadacercare = argv[1];
  fstream files[argc-2];

  for(int i = 2,j=0; i < argc; i++,j++) {
    files[j].open(argv[i], ios::in);
    if (files[j].fail()) {
      for(int j = 0; j < i; j++) files[j].close();
    }
  }
  if (grep(stringadacercare, files, argc-2)) {
    std::cout << "Trovato" << std::endl;
  } else {
    std::cout << "Non Trovato" << std::endl;
  }
  for(int i = 2,j=0; i < argc; i++,j++) {
    files[j].close();
  }
  return 0;
}


bool grep(const char * s, char * files[], const int n) {
  for(int i = 0; i < n; i++) {
    fstream f;
    f.open(files[i], ios::in);
    if (f.fail()) return false;
    if (grep_helper(s, &f)) {
      f.close();
      return true;
    }
    f.close();
  }
  return false;
}

int main_v2(int argc, char * argv[]) {
  if (argc < 3) {
    std::cerr << "Errore" << std::endl;
    return 1;
  }
  char * stringadacercare = argv[1];

  if (grep(stringadacercare, argv+2, argc-2)) {
    std::cout << "Trovato" << std::endl;
  } else {
    std::cout << "Non Trovato" << std::endl;
  }

  return 0;
}

int main(int argc, char * argv[]) {
  std::cout << "Main Variante 1" << std::endl;
  main_v1(argc, argv);
  std::cout << "Main Variante 2" << std::endl;
  main_v2(argc, argv);
}
