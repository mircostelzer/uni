#include <signal.h> <unistd.h> <stdio.h> //sigsuspend.c
#include <bits/types/sigset_t.h>

void myHandler(int sigNum){
	printf("Continue!\n");
}

int main(){
	signal(SIGCONT,myHandler);
	signal(SIGUSR1,myHandler);
	sigset_t mask;
	sigemptyset(&mask);
	sigaddset(&mask,SIGCONT);
	while(1) sigsuspend(&mask);
}