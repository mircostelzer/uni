#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <signal.h>
#include <bits/sigaction.h>
#include <unistd.h>

#define MAX_LVL 5
#define MAX_NODES 10

int leaves_lvl = 0;
struct sigaction sa1;
struct sigaction sa2;

// structs
struct Node {
    pid_t pid;
    pid_t ppid;
};

struct Level {
    pid_t leader;
    int lvl;
};

struct Level tree[MAX_LVL] = {0};

//main process logic
void child_lvl(int level) {
    if (level > leaves_lvl+1) {
        printf("You can't add children at this level yet\n");
    } else {
        union sigval value;
        if (level == leaves_lvl+1) {
            leaves_lvl++;
            tree[leaves_lvl].lvl = leaves_lvl;
            int pid = fork();
            if (pid == 0) {
                setpgid(0, getpid());
                return;
            } else {
                waitpid(pid, NULL, 0);
                tree[level].leader = pid;
            }
        }
        value.sival_int = tree[level-1].leader;
        sigqueue(tree[level-1].leader, SIGUSR1, value);
        
    }
}

void kill_lvl(int level) {
    if (level == leaves_lvl) {
        kill(-tree[level].leader, SIGTERM);
        leaves_lvl--;
    } else {
        kill_lvl(level+1);
    }

}

void print_tree() {
    for(int i=0; i<=leaves_lvl; i++) {
        union sigval value;
        value.sival_int = i;
        sigqueue(tree[i].leader, SIGUSR2, value);
    }
}

//handlers
__sighandler_t su1_handler(int signum, siginfo_t *info, void *empty) {
    printf("received signal %d", getpid());
    int isChild = !fork();
    int leader = info->si_value.sival_int;
    if (isChild) {
        printf("I'm child %d with group %d\n", getpid(), leader);
        setpgid(0, leader);
        while(1) {
            pause();
        }
    }
}

__sighandler_t su2_handler(int signum, siginfo_t *info, void *empty) {
    int lvl = info->si_value.sival_int;
    for(int i=0; i<lvl; i++) {
        printf("\t");
    }
    printf("[ID: %d - Parent: %d] depth: %d\n", getpid(), getppid(), lvl);
}

int main()
{
    tree[0].lvl = 0;
    tree[0].leader = getpgid(0);
	sa1.sa_sigaction = su1_handler;
	sigemptyset(&sa1.sa_mask);
	sa1.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR1, &sa1, NULL);

    sa2.sa_sigaction = su2_handler;
	sigemptyset(&sa2.sa_mask);
	sa2.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR2, &sa2, NULL);


    char buffer[256];
    printf("Next command:");
    while(fgets(buffer, sizeof(buffer), stdin) != NULL) {
        if (buffer[0] == 'c') {
            int lvl = buffer[1] - '0';
            child_lvl(lvl);
            sleep(2);
        } else if (buffer[0] == 'k') {
            int lvl = buffer[1] - '0';
            kill_lvl(lvl);
            sleep(2);
        } else if (buffer[0] == 'p') {
            print_tree();
            sleep(2);
        } else if (buffer[0] == 'q') {
            printf("Terminating...\n");
            kill_lvl(0);
            sleep(2);
        } else {
            printf("Invalid parameter\n");
        }
        printf("Next command:");
    }

    return 0;
}