#include<iostream>

using namespace std;

const int righe = 5;
const int colonne = 6;

bool cercaCammino (int palude[][colonne], int i, int j, int cammino[]);
bool esplora (int palude [][colonne], int cammino[]);
void mostraCammino (int palude [][colonne], int cammino[]);

int main() {

int palude[righe][colonne] = {
{1,0,0,1,0,0},
{1,0,0,0,0,0},
{0,1,0,0,1,1},
{0,0,1,1,0,0},
{0,1,0,0,0,1}};

int cammino[colonne] ={0}; 


if (esplora(palude, cammino))
    mostraCammino(palude, cammino);
else
    cout << "Non ci sono percorsi che attraversano la palude sulla terraferma"<<endl;
return 0;

}


bool esplora (int palude[][colonne], int cammino[]) {

int i=0;
bool trovato = false;  


while(i < righe && !trovato){
    trovato = cercaCammino(palude, i, 0, cammino);
    i++;
}
return trovato;
}


bool cercaCammino (int palude[][colonne], int i, int j, int cammino[]) {

bool trovato = true; 

if (palude[i][j] == 1) { 
    cammino[j] = i; 
    j++;

    while(trovato && (j<colonne)){ 

        if (i==0) {
            if (palude[i][j]==1) 
               {
                 cammino[j]=i;
                 j++;
               }
            else if (palude[i+1][j]==1)  
                 {  i=i+1; 
                    cammino[j]=i;
                    j++;
                } 
            else trovato = false;}

        else if (i > 0 &&  i < (righe-1)) {
            if (palude[i][j]==1) 
               {
                 cammino[j]=i;
                 j++;
               }
            else if (palude[i+1][j]==1)  
                 {  i=i+1; 
                    cammino[j]=i;
                    j++;
                } 
        
            else if (palude[i-1][j]==1)
                 {  i=i-1; 
                    cammino[j]=i;
                    j++;
                }
            else trovato = false;}
        
        else if (i==(righe-1)){
            if (palude[i][j]==1) 
               {
                 cammino[j]=i;
                 j++;
               }
        
            else if (palude[i-1][j]==1)
                 {  i=i-1; 
                    cammino[j]=i;
                    j++;
                }
            else trovato = false;}
    

    }
}

else {trovato = false; j--;}

return trovato;
}


void mostraCammino (int palude[][colonne], int cammino[]){

int i, j;

for (i=0; i < colonne; i++)
    cout<<cammino[i];

cout<<endl;

cout<<"Percorso che attraversa la palude sulla terraferma:"<<endl;

for (i = 0; i < righe; i++) {
    for (j = 0; j < colonne; j++) {
    if (i == cammino[j]) 
        cout<<"*"; 
    else 
        cout<<"- "; 
}
cout<<endl;
}
}