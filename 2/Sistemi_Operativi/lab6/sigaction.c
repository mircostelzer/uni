#include <signal.h> 
#include <unistd.h> 
#include <stdlib.h> 
#include <stdio.h>
#include <bits/sigaction.h>

void handler(int signo){
	printf("signal %d received\n",signo);
	sleep(2);
	printf("Signal done\n");
}

int main(){
	printf("Process id: %d\n",getpid());
	struct sigaction sa;
	sa.sa_handler = handler;
	sa.sa_flags = 0; //Initialise flags
	sigemptyset(&sa.sa_mask);
	sigaddset(&sa.sa_mask,SIGUSR2); // Block SIGUSR2 only in handler
	sigaction(SIGUSR1,&sa,NULL);
	while(1);
}