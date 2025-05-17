#include <bits/stdc++.h>
using namespace std;

ifstream in("input.txt");
ofstream out("output.txt");

vector<char> fromIntToDirection = {'R','U','L','D'};

int N, M, B, W;
string sol = "";

// da (r0,c0) muoviti verso (r1,c1)
bool goFromTo(int r0, int c0, int r1, int c1){
	if(r0 == r1 && c0 == c1){
		return true;
	}
	if(r0 < r1){
		sol += "D";
		goFromTo(r0+1,c0,r1,c1);
	}
	else if(r0 > r1){
		sol += "U";
		goFromTo(r0-1,c0,r1,c1);
	}
	else{ 
		if(c0 < c1){
			sol += "R";
			goFromTo(r0,c0+1,r1,c1);
		}
		else{
			sol += "L";
			goFromTo(r0,c0-1,r1,c1);
		}
	}
}

int main (){

    in >> N >> M >> B >> W;

    int r, c, rmin = N, rmax = -1, cmin = M, cmax = -1;
    for(int i = 0; i<B; i++){
        in >> r >> c;
        rmin = min(rmin,r);
    	cmin = min(cmin,c);
    	rmax = max(rmax,r);
    	cmax = max(cmax,c);
    }
    for(int i = 0; i<W; i++){
        in >> r >> c;
        rmin = min(rmin,r);
    	cmin = min(cmin,c);
    	rmax = max(rmax,r);
    	cmax = max(cmax,c);
    }
    
    /*
    Il percorso rettangolare cercato è identificato da quattro punti: (r0,c0),(r1,c1),(r2,c2),(r3,c3)
    (r0,c0) --- (r1,c1)
       |           |
       |           |
    (r2,c2) --- (r3,c3)
    dove: r0 = r1 = rmin, c0 = c2 = cmin, c1 = c3 = cmax, r2 = r3 = rmax.
	*/


    int r0 = rmin, r1 = rmin, c0 = cmin, c2 = cmin, c1 = cmax, c3 = cmax, r2 = rmax, r3 = rmax;
    goFromTo(r0,c0,r1,c1);
    goFromTo(r1,c1,r3,c3);
    goFromTo(r3,c3,r2,c2);
    goFromTo(r2,c2,r0,c0);
    
    out << B+W << " " << sol.size() << " " << r0 << " " << c0 << " " << sol << "#" << endl;

    return 0;
}