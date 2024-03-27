#include <iostream>
#include <cstdlib>

void KochCurve(double ll, int level) {
    if (level == 0) {
        std::cout << "F(" << ll << ");";
    }
    else {
        ll /= 3;
        KochCurve(ll, level-1);
        std::cout << "RL(60);";
        KochCurve(ll, level-1);
        std::cout << "RR(120);";
        KochCurve(ll, level-1);
        std::cout << "RL(60);";
        KochCurve(ll, level-1);
    }
    
}

void SnowFlake(double line_lenght, int level) {
    KochCurve(line_lenght, level);
    std::cout << "RR(120);";
    KochCurve(line_lenght, level);
    std::cout << "RR(120);";
    KochCurve(line_lenght, level);
    std::cout << "RR(120);";
}


int main(int argc, char **argv)
{
    int level = 2;
    double line_lenght = 90.0;

    if (argc == 3) {
        level = strtol(argv[1], NULL, 10);
        line_lenght = strtod(argv[2], NULL);
    }

    std::cout << "Un fiocco di neve per ll="
            << line_lenght << " e level="
            << level << " e': " << std::endl;
    SnowFlake(line_lenght, level);
    std::cout << std::endl;

}