#include<iostream>
using namespace std;

int main()
{
    float celsius, fahrenheit;

    cout <<"Inserisci la tua temperatura in Fahrenheit: ";

    cin >> fahrenheit;

    celsius=(fahrenheit-32)/1.8;

    cout <<"La tua temperatura in Celsius è: " <<celsius << endl;


}