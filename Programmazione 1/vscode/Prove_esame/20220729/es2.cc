#include <iostream>
#include <string>

using namespace std;

typedef struct _list {
  int code;
  struct _list * next;
} list;

#define MAXCODE 100
#define MAXDIP 10

// Add hereafter the declaration of estrai
list *estrai(list *l1, list *l2);
// Add here above the declaration of estrai

list * crea_lista(int num) {
  int * a = new int[num];
  for (int i = 0; i < num; i++) {
    a[i] = rand()%MAXCODE + 1;
    for (int j = 0; j < i; j++) {
      if (a[i] == a[j]) { i--; break;}
    }
  }
  list * res = NULL;
  for (int i = 0; i < num; i++) {
    res = new list{a[i], res};
  }
  delete [] a;
  return res;
}

list * crea_l2(list * const l1, const int t = 5) {
  list * res = NULL;
  for (int k = t; k >= 0; k--) {
    for (list * d = l1; d != NULL; d = d->next) {
      if (rand()%2 == 0) {
        res = new list{d->code, res};
      }
    }
  }
  return res;
}

void print_list(list * l, const char * prefix) {
  std::cout << prefix;
  for( ; l != NULL; l = l->next)
    std::cout << " " << l->code;
  std::cout << std::endl;
}

void delete_list(list * & l) {
  while(l != NULL) {
    list * p = l;
    l = l->next;
    delete p;
  }
}

int main(int argc, char ** argv) {
  srand(unsigned(time(0)));
		//
		// Scommentare la linea seguente per avere comportamento
		// deterministico
		//
		srand(0);

  list * l1 = crea_lista(MAXDIP);
  print_list(l1, "Lista L1:");
  list * l2 = crea_l2(l1);
  print_list(l2, "Lista L2:");
  list * l3 = estrai(l1, l2);
  print_list(l3, "Lista L3:");
  delete_list(l1);
  delete_list(l2);
  delete_list(l3);
  return 0;
}


// Add hereafter the definition of estrai
int count(int n, list *l2) {
    int res;
    if (l2 == NULL) {
        res = 0;
    }
    else if (l2->code==n) {
        res = 1 + count(n, l2->next);
    }
    else {
        res = count(n, l2->next);
    }
    return res;
}

list *estrai(list *l1, list *l2) {
    if (l1 == NULL) {
        return NULL;
    }
    else {
        if (l1->code%2==0) {
            list *l2t = l2;
            int val = count(l1->code, l2t);
            return new list {val, estrai(l1->next, l2)};
        }
        else {
            return new list {-1, estrai(l1->next, l2)};
        }
    }
}
// Add here above the definition of estrai