#include <signal.h> <stdio.h> <stdlib.h> <unistd.h> //alarm.c

short cnt = 0;
void myHandler(int sigNum){printf("ALARM!\n"); cnt++;}

int main(){
	signal(SIGALRM,myHandler);
	alarm(0); //Clear any pending alarm
	alarm(5); //Set alarm in 5 seconds
	//Set new alarm (cancelling previous one)
	sleep(1);
	printf("Seconds remaining to previous alarm %d\n", alarm(2));
	while(cnt<1);
}