#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <signal.h>
#include <bits/sigaction.h>
#include <unistd.h>

#define MAX_LVL 5
#define MAX_NODES 10

int leaves_lvl = 0;
struct sigaction sa;

// structs
struct Node {
    pid_t pid;
    pid_t ppid;
};

struct Level {
    int lvl;
    struct Node nodes[MAX_NODES];
};

struct Level tree[MAX_LVL] = {0};

//main process logic
void child_lvl(int level) {
    if (level > leaves_lvl+1) {
        printf("You can't add children at this level yet\n");
    } else {
        if (level == leaves_lvl+1) {
            leaves_lvl++;
            tree[leaves_lvl].lvl = leaves_lvl;
        }
        for(int i=0; i<MAX_NODES && (tree[level-1].nodes[i].pid != 0); i++) {
            kill(tree[level-1].nodes[i].pid, SIGUSR1);
        }
    }
}

void kill_lvl(int level) {
    if (level == leaves_lvl) {
        for(int i=0; i<MAX_NODES && (tree[level].nodes[i].pid != 0); i++) {
            kill(tree[level-1].nodes[i].pid, SIGTERM);
        }
        leaves_lvl--;
    } else {
        kill_lvl(level+1);
    }

}

void print_tree() {
    for(int i=0; i<=leaves_lvl; i++) {
        for(int j=0; j<MAX_NODES; j++) {
            printf("Level: %d node: %d", tree[i].lvl, tree[i].nodes[j].pid);
            struct Node node = tree[i].nodes[j];
            if (node.pid != 0) {
                for(int k=0; k<tree[i].lvl; k++) {
                    printf("\t");
                }
                printf("[PID: %d - PPID: %d] depth: %d\n", node.pid, node.ppid, tree[i].lvl);
            }
        }
    }
}

//handlers
__sighandler_t su1_handler(int signum, siginfo_t *info, void *empty) {
    int isChild = !fork();
    int lvl = info->si_value.sival_int;
    if (isChild) {
        for (int i=0; i<MAX_NODES; i++) {
            struct Node node = tree[lvl].nodes[i];
            if (node.pid == 0) {
                printf("I'm child %d at level %d\n", getpid(), lvl);
                break;
            }
        }
        while(1) {
            pause();
        }
    }
    else {
        printf("Tree1 [PID: %d] [PPID: %d]", tree[lvl].nodes[0].pid, tree[lvl].nodes[0].pid);
    }
}

int main()
{
    tree[0].nodes[0].pid = getpid();
    tree[0].nodes[0].ppid = getppid();
    // for (int i=0; i<MAX_LVL; i++) {
    //     tree[i].lvl = 0;
    //     for (int j=0; j)
    //     tree[i].nodes[] = {0};
    // }
	sa.sa_sigaction = su1_handler;
	sigemptyset(&sa.sa_mask);
	sa.sa_flags = SA_SIGINFO;
    sigaction(SIGUSR1, &sa, NULL);

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
        printf("leaves: %d\n", leaves_lvl);
        printf("Next command:");
    }

    return 0;
}