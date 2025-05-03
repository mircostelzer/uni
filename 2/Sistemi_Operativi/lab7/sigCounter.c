#include <unistd.h>
#include <stdio.h>
#include <signal.h>
#include <bits/sigaction.h>
#include <stdlib.h>
#include <fcntl.h>

#define MAX_P 20

struct Proc {
    pid_t pid;
    int count1;
    int count2;
};

struct Proc counter[MAX_P] = {0};

void add_signal(int signum, struct Proc counter[], int i) {
    if (signum == SIGUSR1) {
        counter[i].count1++;
    } else {
        counter[i].count2++;
    }
}


__sighandler_t sigusr_handler(int signum, siginfo_t *info, void *empty) {
    int pid = info->si_pid;
    printf("Signal %d received from [%d]\n", signum, pid);
    for(int i=0; i<MAX_P; i++) {
        if (counter[i].pid == 0) {
            counter[i].pid = pid;
            add_signal(signum, counter, i);
            break;
        } else if (counter[i].pid == pid) {
            add_signal(signum, counter, i);
            break;
        }
    }
}

void term_handler(int signum) {
    int i = 0;
    printf("\n");
    while((counter[i].pid != 0) && (i<MAX_P)) {
        printf("PID: %d SIGUSR1 emitted: %d\n", counter[i].pid, counter[i].count1);
        printf("PID: %d SIGUSR2 emitted: %d\n", counter[i].pid, counter[i].count2);
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