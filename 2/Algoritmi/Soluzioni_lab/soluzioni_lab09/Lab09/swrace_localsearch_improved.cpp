#include <bits/stdc++.h>
#include "swrace.h"
#define NONE -1
#define R 0
#define U 1
#define L 2
#define D 3
#define WHITE 4
#define BLACK 5
#define SEED 1234
using namespace std;

ifstream in("input.txt");
ofstream out("output.txt");

default_random_engine myengine = default_random_engine(SEED);

typedef unsigned short ints;

vector<int> diffRow = {0,-1,0,1};
vector<int> diffCol = {1,0,-1,0};
vector<char> fromIntToDirection = {'R','U','L','D'};
vector<int> dir = {R,U,L,D};

int N, M, B, W;
int maxColorPoint = -1;
vector<vector<int>> color;
vector<vector<int>> mymove;
vector<vector<bool>> taken;
vector<vector<bool>> visited;
vector<vector<int>> parents;
vector<int> modifiablePoints;

////// tools per non usare le pair //////
int id(int r, int c){ return r*M+c; }
int row(int id){ 
	if(id == -1) return -1; 
	else return id/M; 
}
int col(int id){ 
	if(id == -1) return -1; 
	else return id%M; 
}

////// tools per muoversi sulla griglia //////
bool areValidCoords(int x, int y){
    return (x>=0 && x<N && y>=0 && y<M);
}

bool areValidNotVisited(int x, int y){
    if(!areValidCoords(x,y))
    	return false;
    return !taken[x][y] && !visited[x][y]; 
}

void oppositeDirections(int d, vector<int>& opposite){ 
	opposite.resize(2);
	if(d == R || d == L){ opposite[0] = U; opposite[1] = D; } 
	else{ opposite[0] = R; opposite[1] = L; }
	shuffle(opposite.begin(), opposite.end(), myengine);
}

////// funzioni muoversi sulla griglia ed attraversare correttamente le biglie //////

bool fromBlackGoOn(int &r0, int &c0, int d);
bool fromWhiteGoOn(int &r0, int &c0, int d, bool changeDirection);
bool findBlack(int &r0, int &c0, int d);
bool findWhite(int &r0, int &c0, int d);
bool moveRandom(int &r0, int &c0);
bool goFromTo(int r0, int c0, int r1, int c1, int rpar, int cpar);

// cerca di trovare una biglia nera muovendoti di due passi nella direzione d
bool findBlack(int &r0, int&c0, int d){
	int r1 = r0+diffRow[d], c1 = c0+diffCol[d];
	int r2 = r1+diffRow[d], c2 = c1+diffCol[d];
	if(areValidNotVisited(r1,c1) && areValidNotVisited(r2,c2)){
		if(color[r2][c2] == BLACK && color[r1][c1] != BLACK){ // non posso passare da una biglia nera in (r1,c1)
			vector<int> opposite;
			oppositeDirections(d,opposite);
			for(auto o : opposite){
				int newr0 = r2, newc0 = c2;
				visited[r0][c0] = true, visited[r1][c1] = true;
				if(fromBlackGoOn(newr0,newc0,o)){ // se vero, point è aggiornato al punto di arrivo
					parents[r1][c1] = id(r0,c0);
					parents[r2][c2] = id(r1,c1);
					r0 = newr0, c0 = newc0;
					return true;
				}
				visited[r0][c0] = false, visited[r1][c1] = false;
			}
		}
	}
	return false;
}

// cerca di trovare una biglia bianca muovendoti di un passo nella direzione d
bool findWhite(int &r0, int&c0, int d){
	int r1 = r0+diffRow[d], c1 = c0+diffCol[d];
	if(areValidNotVisited(r1,c1)){
		if(color[r1][c1] == WHITE){
			int newr0 = r1, newc0 = c1;
			visited[r0][c0] = true;
			if(fromWhiteGoOn(newr0,newc0,d,true)){ 
				parents[r1][c1] = id(r0,c0);
				r0 = newr0, c0 = newc0;
				return true;
			}
			visited[r0][c0] = false;
		}
	}
	return false;
}

// dalla posizione (r0,c0), che contiene un cerchio bianco, 
// vai avanti lungo la direzione d e gira se changeDirection è true
bool fromWhiteGoOn(int &r0, int&c0, int d, bool changeDirection){
	int r1 = r0+diffRow[d], c1 = c0+diffCol[d];
	if(areValidNotVisited(r1,c1)){

		if(color[r1][c1] == NONE && !changeDirection){
			visited[r0][c0] = true, parents[r1][c1] = id(r0,c0);
			r0 = r1, c0 = c1;
			return true;
		}

		if(color[r1][c1] == NONE && changeDirection){
			vector<int> opposite;
			oppositeDirections(d,opposite);
			for(auto o : opposite){
				int r2 = r1+diffRow[o], c2 = c1+diffCol[o];
				if(areValidNotVisited(r2,c2)){
					if(color[r2][c2] == NONE){
						visited[r0][c0] = true, parents[r1][c1] = id(r0,c0);
						visited[r1][c1] = true, parents[r2][c2] = id(r1,c1);
						r0 = r2, c0 = c2;
						return true;
					}
					if(color[r2][c2] == WHITE){
						int newr0 = r2, newc0 = c2;
						visited[r0][c0] = true, visited[r1][c1] = true;
						if(fromWhiteGoOn(newr0,newc0,o,false)){ 
							parents[r1][c1] = id(r0,c0);
							parents[r2][c2] = id(r1,c1);
							r0 = newr0, c0 = newc0;
							return true;
						}
						visited[r0][c0] = false, visited[r1][c1] = false;
					}
				}
			}
			return false;	
		}

		if(color[r1][c1] == BLACK){
			vector<int> opposite;
			oppositeDirections(d,opposite);
			for(auto o : opposite){
				int newr0 = r1, newc0 = c1;
				if(fromBlackGoOn(newr0,newc0,o)){
					parents[r1][c1] = id(r0,c0);
					r0 = newr0, c0 = newc0;
					return true;
				}
				visited[r0][c0] = false;
			}
			return false;
		}

		if(color[r1][c1] == WHITE && changeDirection){
			return false;
		}

		if(color[r1][c1] == WHITE && !changeDirection){
			int newr0 = r1, newc0 = c1;
			visited[r0][c0] = true;;
			if(fromWhiteGoOn(newr0,newc0,d,true)){
				parents[r1][c1] = id(r0,c0);
				r0 = newr0, c0 = newc0;
				return true;
			}
			visited[r0][c0] = false;
		}
	}

	return false;
}

// dalla posizione (r0,c0), che contiene un cerchio nero, vai avanti lungo la direzione d (di due step)
bool fromBlackGoOn(int &r0, int&c0, int d){
	int r1 = r0+diffRow[d], c1 = c0+diffCol[d];
	int r2 = r1+diffRow[d], c2 = c1+diffCol[d];
	if(areValidNotVisited(r1,c1) && areValidNotVisited(r2,c2)){

		if(color[r1][c1] == BLACK){
			return false;
		}

		if(color[r1][c1] == NONE && color[r2][c2] == NONE){
			visited[r0][c0] = true, parents[r1][c1] = id(r0,c0);
			visited[r1][c1] = true, parents[r2][c2] = id(r1,c1);
			r0 = r2, c0 = c2;
			return true;
		}

		if(color[r1][c1] == WHITE){
			int newr0 = r1, newc0 = c1;
			visited[r0][c0] = true;			
			if(fromWhiteGoOn(newr0,newc0,d,false)){
				parents[r1][c1] = id(r0,c0);
				r0 = newr0, c0 = newc0;
				return true;
			}
			visited[r0][c0] = false;
		}

		if(color[r2][c2] == WHITE){
			int newr0 = r2, newc0 = c2;
			visited[r0][c0] = true, visited[r1][c1] = true;
			if(fromWhiteGoOn(newr0,newc0,d,true)){
				parents[r1][c1] = id(r0,c0);
				parents[r2][c2] = id(r1,c1);
				r0 = newr0, c0 = newc0;
				return true;
			}
			visited[r0][c0] = false, visited[r1][c1] = false;
		}

		if(color[r2][c2] == BLACK){
			vector<int> opposite;
			oppositeDirections(d,opposite);
			for(auto o : opposite){
				int newr0 = r2, newc0 = c2;
				visited[r0][c0] = true, visited[r1][c1] = true;
				if(fromBlackGoOn(newr0,newc0,o)){
					parents[r1][c1] = id(r0,c0);
					parents[r2][c2] = id(r1,c1);
					r0 = newr0, c0 = newc0;
					return true;
				}
				visited[r0][c0] = false, visited[r1][c1] = false;
			}
		}
	}

	return false;
}

// mi muovo a caso in una cella vuota
bool moveRandom(int &r0, int&c0){
	shuffle(dir.begin(), dir.end(), myengine);
	int d = 0, r, c;
	do{
		r = r0+diffRow[dir[d]];
		c = c0+diffCol[dir[d]];
		if(areValidNotVisited(r,c)){
			if(color[r][c] == NONE) break;
		}
		d++;
	}while(d<4);
					
	if(d<4){
		r = r0+diffRow[dir[d]];
		c = c0+diffCol[dir[d]];
		visited[r0][c0] = true;
		parents[r][c] = id(r0,c0);
		r0 = r, c0 = c;
		return true;
	}
	return false;
}

// mi sposto da (r0,c0) ad (r1,c1), proveniendo da (rpar,cpar), muovendomi su celle non nere
bool goFromTo(int r0, int c0, int r1, int c1, int rpar, int cpar){ 
	if(r0 == r1 && c0 == c1)
		return true;

	visited[r0][c0] = true;

	// memorizzo (pref,dir)
	// pref = 0 se dir è una direzione preferibile
	// pref = 1 se dir è una direzione da provare dopo quelle preferibili
	// pref = 2 se dir non è precorribile
	vector<pair<int,int>> prefDir = {make_pair(2,R),make_pair(2,U),make_pair(2,L),make_pair(2,D)}; 

	for(int i = 0; i<4; i++){
		int d = prefDir[i].second;
		int r = r0+diffRow[d], c = c0+diffCol[d];
		if(r == r1 && c == c1 && (r != rpar || c != cpar)){
			parents[r1][c1] = id(r0,c0);
			return true;
		}
		if(areValidNotVisited(r,c) && (r != rpar || c != cpar)){
			if(color[r][c] != BLACK)
				prefDir[i].first = 1;
		}
	} 

	// mi muovo preferibilmente verso la destinazione
	if(c0<c1 && prefDir[R].first != 2) prefDir[R].first = 0;
	if(c0>c1 && prefDir[L].first != 2) prefDir[L].first = 0;
	if(r0<r1 && prefDir[D].first != 2) prefDir[D].first = 0;
	if(r0>r1 && prefDir[U].first != 2) prefDir[U].first = 0;

	sort(prefDir.begin(), prefDir.end());
	for(auto d : prefDir){
		if(d.first != 2){
			int r = r0+diffRow[d.second], c = c0+diffCol[d.second];
			if(color[r][c] == NONE){
				bool res = goFromTo(r,c,r1,c1,r0,c0);
				if(res){
					parents[r][c] = id(r0,c0);
					return true;
				}	
			}else{ 
				int newr0 = r0, newc0 = c0;
				if(findWhite(newr0,newc0,d.second)){
					int rpar = row(parents[newr0][newc0]), cpar = col(parents[newr0][newc0]);
					bool res = goFromTo(newr0,newc0,r1,c1,rpar,cpar);
					if(res) return true;
				}
			}
		}
	}

	return false;
}

///////// funzioni per risolvere il problema /////////

void validatePath();
void checkAndPrintSol(int rstart, int cstart);
int createPath(int &r0, int &c0, int nMoves);
void tryToChange(int rstart, int cstart, int movesForStep); // local search
void solve(int maxMovesForStep);
void solvePartial(int div);
void solveStrange(int nMoves); 

bool rectangle(int r, int c, int d, int rdest, int cdest);
void solveRectangle(int rb, int cb);

void resetAll(){
	modifiablePoints.clear();
	mymove.assign(N, vector<int>(M,NONE));
	taken.assign(N, vector<bool>(M,false));
	visited.assign(N, vector<bool>(M,false));
	parents.assign(N, vector<int>(M,-1));
}

void validatePath(){
	for(int i = 0; i<N; i++){
		for(int j = 0; j<M; j++){
			if(row(parents[i][j]) != -1){
				int r0 = row(parents[i][j]), c0 = col(parents[i][j]);
				if(i == r0 && j<c0) mymove[r0][c0] = L;
				if(i == r0 && j>c0) mymove[r0][c0] = R;
				if(j == c0 && i<r0) mymove[r0][c0] = U;
				if(j == c0 && i>r0) mymove[r0][c0] = D;
				taken[r0][c0] = true;

				// nel mentre, cerco punti modificabili:
				// nel percorso (i,j)<-(r0,c0)<-(r1,c1)<-(r2,c2)
				// se posso modificare (r0,c0)<-(r1,c1), mi segno (r1,c1) come punto modificabile
				int r1 = row(parents[r0][c0]), c1 = col(parents[r0][c0]);
				if(r1 != -1){
					int r2 = row(parents[r1][c1]), c2 = col(parents[r1][c1]);
					if(r2 != -1){
						if(color[i][j] == NONE && color[r0][c0] == NONE && color[r1][c1] == NONE && color[r2][c2] == NONE){
							modifiablePoints.push_back(id(r1,c1));
						}
					}
				}
			}
		}
	}
}

void checkAndPrintSol(int rstart, int cstart){
	string path = "";
    int r = rstart, c = cstart, d = 0, colorPoint = 0;
    vector<vector<int>> vis(N,vector<int>(M,false));
    do{
    	vis[r][c] = true;
		if(color[r][c] != NONE)
		    colorPoint++;
		d = mymove[r][c];
		if(d != NONE){
		    r += diffRow[d];
			c += diffCol[d];
			path += fromIntToDirection[d];
		}
	}while((r != rstart || c != cstart) && d != NONE && !vis[r][c]);

	// se non ho chiuso il percorso, non stampo la soluzione
	if(r == rstart && c == cstart){ 
		if(colorPoint>maxColorPoint){
			out << colorPoint << " " << path.size() << " " << rstart << " " << cstart << " " << path << "#" << endl << endl;
			// cout << colorPoint << " " << path.size() << " " << rstart << " " << cstart << " " << path << "#" << endl << endl;
			maxColorPoint = colorPoint;
		}
	}
}

// creo un percorso cercando di prendere le biglie, restituisco il numero di mosse
int createPath(int &r0, int &c0, int nMoves){

	bool movedBlack = false, movedWhite = false, movedRandom = false;
	int n = 0;
	do{
		movedBlack = false, movedWhite = false, movedRandom = false;
		shuffle(dir.begin(), dir.end(), myengine);
		for(auto d : dir){
			if(myengine()%2 == 0){
				if(findBlack(r0,c0,d)){ movedBlack = true; break; }
				else if(findWhite(r0,c0,d)){ movedWhite = true; break; } 
			}
			else{
				if(findWhite(r0,c0,d)){ movedWhite = true; break; } 
				else if(findBlack(r0,c0,d)){ movedBlack = true; break; }
			}
		}
		if(!movedBlack && !movedWhite){
			movedRandom = moveRandom(r0,c0);
		}
		n++;
		if(n>nMoves) break;
	}while(movedBlack || movedWhite || movedRandom);

	return n;
}

// local search
void tryToChange(int rstart, int cstart, int movesForStep){
	int n = 0;
	shuffle(modifiablePoints.begin(),modifiablePoints.end(),myengine);

	while(modifiablePoints.size()>0){
		int r0 = row(modifiablePoints[modifiablePoints.size()-1]);
		int c0 = col(modifiablePoints[modifiablePoints.size()-1]);
		modifiablePoints.pop_back();
		
		visited.assign(N, vector<bool>(M,false));
		parents.assign(N, vector<int>(M,-1));

		int r1 = r0+diffRow[mymove[r0][c0]], c1 = c0+diffCol[mymove[r0][c0]]; // destinazione nuovo path

	    // due mosse random per "staccarmi" dal percorso
	    bool movedRandom = moveRandom(r0,c0);
	    if(movedRandom) movedRandom = moveRandom(r0,c0);
	    	
	    if(movedRandom){
	    	// creo un percorsino e provo a tornare indietro
	    	int moves = createPath(r0,c0,myengine()%movesForStep+2); 
	    	int rpar = row(parents[r0][c0]), cpar = col(parents[r0][c0]);
			bool res = goFromTo(r0,c0,r1,c1,rpar,cpar);
	    	if(moves>1 && res){ 
	    		validatePath();
	    		checkAndPrintSol(rstart,cstart);
	    	}
	    }
    }

}

// maxMovesForStep = massimo numero di passi da fare ogni volta che si crea un pezzo di percorso
void solve(int maxMovesForStep){ 
	resetAll();

    int r, c;
    do{
   		r = myengine()%N, c = myengine()%M; // start
    }while(color[r][c] != NONE);

   	int rstart = r, cstart = c;
    int moves = createPath(r,c,myengine()%maxMovesForStep+2);
    int rpar = row(parents[r][c]), cpar = col(parents[r][c]);
    bool res = goFromTo(r,c,rstart,cstart,rpar,cpar);

    if(moves>1 && res){
    	validatePath();
    	tryToChange(rstart,cstart,myengine()%maxMovesForStep+2); // local search
    	checkAndPrintSol(rstart,cstart);
    }

}

void solvePartial(int div){ 
    int Nold = N, Mold = M;
    N = N/div, M = M/div;
    solve(N*M/1.5);
    N = Nold, M = Mold;
}

void solveStrange(int nMoves){ 
	resetAll();

    int r = 0, c = 0, rdest = N-1, cdest = M-1;
    while(color[r][c] != NONE) r++; 
    while(color[rdest][cdest] != NONE) cdest--; 

	for(int i = 0; i<N; i++){
    	for(int j = 0; j>i; j++){
    		visited[i][j] = true;
    	}
    }
    
    int rstart = r, cstart = c;
    int moves = createPath(r,c,nMoves);
    int rpar = row(parents[r][c]), cpar = col(parents[r][c]);
    bool res = goFromTo(r,c,rdest,cdest,rpar,cpar);
    if(!res) return;

    for(int i = 0; i<N; i++){
    	for(int j = 0; j>i; j++){
    		visited[i][j] = false;
    	}
    }

    moves = createPath(rdest,cdest,nMoves);
    rpar = row(parents[rdest][cdest]), cpar = col(parents[rdest][cdest]);
    res = goFromTo(rdest,cdest,rstart,cstart,rpar,cpar);

    if(res){
    	validatePath();
    	tryToChange(rstart,cstart,myengine()%(N+M)+2); // local search
    	checkAndPrintSol(rstart,cstart);
    }

}

////// Caso multi rettangolare (bordo di più rettangoli sovrapposti) //////

bool rectangle(int r, int c, int d, int rdest, int cdest){
	if(r == rdest && c == cdest && parents[r][c] != -1)
		return true;
	if(color[r][c] == BLACK){
		vector<int> opposite;
		oppositeDirections(d,opposite);
		for(auto o : opposite){
			if(areValidNotVisited(r+diffRow[o],c+diffCol[o])){
				visited[r+diffRow[o]][c+diffCol[o]] = true;
				parents[r+diffRow[o]][c+diffCol[o]] = id(r,c);
				bool solved = rectangle(r+diffRow[o],c+diffCol[o],o,rdest,cdest);
				if(solved) return true;
				visited[r+diffRow[o]][c+diffCol[o]] = false;
				parents[r+diffRow[o]][c+diffCol[o]] = -1;
			}
		}
	}
	else{
		if(areValidNotVisited(r+diffRow[d],c+diffCol[d])){
			visited[r+diffRow[d]][c+diffCol[d]] = true;
			parents[r+diffRow[d]][c+diffCol[d]] = id(r,c);
			bool solved = rectangle(r+diffRow[d],c+diffCol[d],d,rdest,cdest);
			if(solved) return true;
			visited[r+diffRow[d]][c+diffCol[d]] = false;
			parents[r+diffRow[d]][c+diffCol[d]] = -1;
		}
	}
	return false;
}

void solveRectangle(int rb, int cb){ 
   	for(auto d : dir){
   		bool solved = rectangle(rb,cb,d,rb,cb);
   		if(solved){
   			validatePath();
    		checkAndPrintSol(rb,cb);
    		break;
   		}
   	}
}


int main (){

    in >> N >> M >> B >> W;

    color.resize(N, vector<int>(M,NONE));
    mymove.resize(N, vector<int>(M,NONE));
    taken.resize(N, vector<bool>(M,false));
    visited.resize(N, vector<bool>(M,false));
    parents.resize(N, vector<int>(M,-1));

    int rb = -1, cb = -1;
    for(int i = 0; i<B; i++){
    	int r, c;
        in >> r >> c;
        color[r][c] = BLACK;
        rb = r, cb = c;
    }
    for(int i = 0; i<W; i++){
    	int r, c;
        in >> r >> c;
        color[r][c] = WHITE;
    }

    bool solved = false;
    if(B+W < 48) solveRectangle(rb,cb);
	while(true){
		// se la grgilia è troppo grande (ha troppi cerchi) ne considero una porzione più piccola
		// divido N ed M per un valore casuale tra 1 e 3
		if(B+W > 1000) solvePartial(myengine()%3+1); 
		
		// se la griglia non è troppo grande provo a creare un percorso tra due angoli opposti
		// ovvero (0,0) e (N-1,M-1) e poi faccio ricerca locale
		else solveStrange((N+M)*1.5);

		// percorso casuale con ricerca locale lo provo sempre
		solve((N*M)/1.5);
	}

    return 0;
}
