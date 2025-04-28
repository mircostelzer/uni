#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <bits/sigaction.h>
#include <stdlib.h>

#define MAX_P 20

int counter[MAX_P][2] = {0};

__sighandler_t sigusr_handler(int signum, siginfo_t *info, void *empty) {
    int pid = info->si_pid;
    for(int i=0; i<MAX_P; i++) {
        if (counter[i][0] == 0) {
            counter[i][0] = pid;
            counter[i][1]++;
            break;
        } else if (counter[i][0] == pid) {
            counter[i][1]++;
            break;
        }
    }
}

void term_handler(int signum) {
    int i = 0;
    while((counter[i][0] != 0) && (i<MAX_P)) {
        printf("PID: %d Signals emitted: %d\n", counter[i][0], counter[i][1]);
        i++;
    }
    exit(0);
}

int main()
{
    printf("PID: %d\n", getpid());
    struct sigaction sa;
	sa.sa_handler = sigusr_handler;
	sigemptyset(&sa.sa_mask);
	sa.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR1, &sa, NULL);
    sigaction(SIGUSR2, &sa, NULL);
    signal(SIGTERM, term_handler);
    signal(SIGINT, term_handler);
    while(1) {
        pause();
    }
    return 0;
}