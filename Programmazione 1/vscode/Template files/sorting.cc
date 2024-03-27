#include <iostream>
using namespace std;

void bubble_sort(int a[], int dim) {
    for (int i=0; i<dim; i++) {
        for (int j=0; j<(dim-1); j++) {
            if (a[j]>a[j+1]) {
                int tmp = a[j];
                a[j] = a[j+1];
                a[j+1] = tmp;
            }
        }
    }
}

void bubble_sort_rec1(int a[], int dim) {
    if ((dim-1) <= 0) {
        return;
    }
    for (int i=0; i<dim-1; i++) {
    if (a[i]>a[i+1]) {
        int tmp = a[i];
        a[i] = a[i+1];
        a[i+1] = tmp;
    }
    }
    bubble_sort_rec1(a, dim-1);
}

void bubble_sort_rec2(int a[], int dim, int i=0) {
    if ((dim-1)<=0) {
        return;
    }
    if (i >= dim-1) {
        bubble_sort_rec2(a, dim-1, 0);
    }
    else {
        if (a[i]>a[i+1]) {
        int tmp = a[i];
        a[i] = a[i+1];
        a[i+1] = tmp;
    }
    bubble_sort_rec2(a, dim, i+1);
    }
}

void bubblesort_rec3_aux(int a[], int first, int last) {
  if (last <= 0) {
    return;
  }
  if (first >= last-1) {
    bubblesort_rec3_aux(a, 0, last-1);
  }
  else {
    if(a[first] > a[first+1]){
      int tmp = a[first];
        a[first] = a[first+1];
        a[first+1] = tmp;
    }

    bubblesort_rec3_aux(a, first+1, last);
  }
}

void bubblesort_rec3(int arr[], int size) {
  bubblesort_rec3_aux(arr, 0, size);
}

void merge_sort(int a[], int first, int last) {
  if (first >= last) {
    return;
  }
  int pivot = (first + last)/2;
  merge_sort(a, first, pivot);
  merge_sort(a, pivot+1, last);
  merge(a, first, pivot, last);
}

void merge(int a[], int first, int pivot, int last) {
  int i;
  int j;
  int k = 0;
  int tmp[first+last+1];

  for (i=pivot+1; i>first; i--) {
    tmp[i-1] = a[i-1];
  }
  for (j=pivot; j<last; j++) {
    tmp[pivot+(last-j)] = a[j+1];
  }
  for (k=first; k<=last; k++) {
    if (tmp[j] < tmp[i]) {
      a[k] = tmp[j--];
    }
    else {
      a[k] = tmp[i++];
    } 
  }
}

void quicksort1(int v[], int primo, int ultimo) {
  if (primo < ultimo) {
    // begin partition
    int p = primo;
    int u = ultimo;
    int pivot = v[ultimo];

    do {
      while ((p < u) && (v[p] <= pivot)) { p++; }
      while ((u > p) && (v[u] >= pivot)) { u--; }
      if (p < u) {
        swap(v[p],v[u]);
      }
    } while (p < u);

    swap(v[p],v[ultimo]);
    // end partition
    quicksort1(v, primo, p-1);
    quicksort1(v, p+1, ultimo);
  }
}

void quicksort (int v[],int n)
{
  quicksort1 (v,0,n-1);
}

void insertion_sort(int a[], int n) {
  for (int i=n-1; i>0; i--) {
    if (a[i] < a[i-1]) {
      swap(a[i], a[i-1]);
    }
  }
  for (int i=2; i<=n-1; i++) {
    int j = i;
    int v = a[i];
    while (v < a[j-1]) {
      a[j] = a[j-1];
      j--;
    }
    a[j] = v;
  }
}

void selection_sort(int a[], int n) {
  for (int i=0; i<n-1; i++) {
    int min = i;
    for (int j=i+1; j<n; j++) {
      if (a[j] < a[min]) { min = j; }
    }
    swap(a[i], a[min]);
  }
}


// Search algorithms

int linear_search(int a[], int n, int target) {
  bool found = false;
  int pos;
  for (pos = 0; !found && pos<n; pos++) {
    found = (a[pos] == target);
  }
  return (found ? pos-1 : -1);
}

int bynary_search(const int a[], int n, int target) {
  bool found = false;
  int pos, left = 0, right = n-1;
  while (!found && left <= right) {
    pos = (left + right)/2;
    if (a[pos] == target) {
      found = true;
    }
    else if (a[pos] < target) {
      left = pos + 1;
    }
    else { right = pos - 1; }
  }
  return (found ? pos : -1);
} 


int bynary_search_aux(const int a[], int n, int target,  int left, int right) {
  int res;
  int pos = (left + right)/2;
  if (left > right) {
    res = -1;
  }
  else if (a[pos] == target) {
    res = pos;
  }
  else if (a[pos] < target) {
    res = bynary_search_aux(a, n, target, pos+1, right);
  }
  else {
    res = bynary_search_aux(a, n, target, left, pos-1);
  }
  return res;
}

int bynary_search_rec(const int a[], int n, int target) {
  return bynary_search_aux(a, n, target, 0, n-1);
}


void print_array(const int a[], int dim) {
    for (int i=0; i<dim; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

int main()
{
  int a[]= {4, 5, 3, 7, 2, 8, 23, 1, 89, 9};
  quicksort(a, 10);
  int n = bynary_search_rec(a, 10, 7);
  print_array(a, 10);
  cout << n << '\n';
}