#include <fstream>
#include <iostream>
#include <iomanip>
using namespace std;

#ifdef EVAL
ifstream in("input.txt");
ofstream out("output.txt");
#else
istream &in(cin);
ostream &out(cout);
#endif

int B, H, T;

double memo[2][2][20000];

double solve(){
  for(int hp2 =0; hp2 <= B; hp2++){
    for(int wounded = 1; wounded>=0 ; wounded--){
      for(int hp1 = 0; hp1 <= B+H; hp1++){
        double score = 0.0;
        int shot = (B * 2 + H) - (hp2*2 + hp1 + (2 - wounded) + 1);
        if (shot==T)
          score = 1.0;
        else{
          if(wounded == 0)
            score += memo[hp2%2][1][hp1] / (hp1 + hp2 + 2.0);
          if(hp2 > 0)
            score += memo[(hp2-1)%2][wounded][hp1+1] * hp2 / (hp2 + hp1 + 2.0);
          if(hp1 > 0)
            score += memo[hp2%2][wounded][hp1-1] * hp1 / (hp2 + hp1 + 2.0);
        }
        memo[hp2%2][wounded][hp1] = score;
      }
    }
  }
  return memo[(B-1)%2][0][H-1];
}

int main(void)
{
  in >> B >> H >> T;
  if(B == 0 || H == 0)
    out << 0 <<endl;
  else{
    double p = solve();
    out << scientific << setprecision(10) << p * (B*H) << endl;
  }
  return 0;
}

