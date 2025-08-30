/* Creare un programma che accetti come parametro un numero di ﬁgli che andranno creati. Il processo
padre deve instaurare una comunicazione bidirezionale con pipe anonime con i ﬁgli e, successivamente,
accetterà in input le seguenti opzioni:
● in --> sollecita il ﬁglio n (dove n non è l’id quanto l’n-esimo ﬁglio creato) ad inviargli il suo pid
● rn --> sollecita il ﬁglio n (dove n non è l’id quanto l’n-esimo ﬁglio creato) ad inviargli un numero random
● q --> termina il processo e tutti i ﬁgli

Il programma, quando terminato, deve aspettare la ﬁne di tutti i ﬁgli. */
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <wait.h>
#include <time.h>

#define RED "\033[0;31m"
#define GREEN "\033[32m"
#define DF "\033[0m"

#define READ_END 0
#define WRITE_END 1
#define MAX_SIZE 256

void termHandler(int signo) {
    printf("[Child terminating]\n");
    exit(0);
}

int main(int argc, char **argv)
{
    if (argc != 2) {
        fprintf(stderr, "%s[ERROR] Usage: %s <children_num>\n", RED, argv[0]);
        exit(1);
    }

    __pid_t ppid = getpid();
    int selfIndex;

    int childrenNum = atoi(argv[1]);
    int children[childrenNum];

    // bidirectional pipes, one for each child
    int parentWrite[childrenNum][2];
    int childrenWrite[childrenNum][2];

    struct sigaction sa;
    sa.sa_flags = 0;
    sigemptyset(&sa.sa_mask);
    sa.sa_handler = termHandler;

    for (int i=0; i < childrenNum; i++) {
        pipe(parentWrite[i]);
        pipe(childrenWrite[i]);
        int pid = fork();
        if (pid < 0) {
            fprintf(stderr, "[ERROR] Error in child creation\n");
        } else if (pid == 0) {
            srand(time(NULL) ^ getpid());
            printf("Child %d created\n", getpid());
            selfIndex = i;
            sigaction(SIGTERM, &sa, NULL);
            close(parentWrite[i][WRITE_END]);
            close(childrenWrite[i][READ_END]);
            break;
        } else {
            close(parentWrite[i][READ_END]);
            close(childrenWrite[i][WRITE_END]);
            children[i] = pid;
        }
    }

    char buffer[MAX_SIZE];
    if (getpid() == ppid) { //main process
        sleep(2);
        char c;
        while(1) {
            printf("\nNext command: "); 
            fflush(stdout);
            char string[MAX_SIZE];
            int bytes;
            int num = -1;
            bytes = read(STDIN_FILENO, string, MAX_SIZE-1);
            string[bytes] = 0;
            c = string[0];
            switch (c) {
                case 'i':
                    num = atoi(string + 1) - 1;
                    if (num < 0 || num >= childrenNum) {
                        fprintf(stderr, "%sInvalid paramater%s\n", RED, DF);
                    } else {
                        printf("%sChild %d sending own pid...%s\n", GREEN, num + 1, DF);
                        write(parentWrite[num][WRITE_END], "i", sizeof(char));
                        pid_t pid;
                        bytes = read(childrenWrite[num][READ_END], &pid, sizeof(pid_t));
                        printf("Received pid %d\n", pid);
                    }
                    break;
                case 'r':
                    num = atoi(string + 1) - 1;
                    if (num < 0 || num >= childrenNum) {
                        fprintf(stderr, "%sInvalid paramater%s\n", RED, DF);
                    } else {
                        printf("%sChild %d sending random number...%s\n", GREEN, num + 1, DF);
                        write(parentWrite[num][WRITE_END], "r", sizeof(char));
                        int r;
                        bytes = read(childrenWrite[num][READ_END], &r, sizeof(int));
                        printf("Received number %d\n", r);
                    }
                    break;
                case 'q':
                    printf("Terminating all children...\n");
                    for (int i=0; i < childrenNum; i++) kill(children[i], SIGTERM);
                    while(wait(NULL) > 0);
                    printf("Parent terminates\n");
                    exit(0);
                default:
                    printf("%sInvalid command%s\n", RED, DF);
                    break;
            }
        }

    } else { //child
        while(1) {
            int bytes = read(parentWrite[selfIndex][READ_END], buffer, MAX_SIZE-1);
            buffer[bytes] = 0;
            switch(buffer[0]) {
                case 'i':
                    pid_t pid = getpid();
                    write(childrenWrite[selfIndex][WRITE_END], &pid, sizeof(pid_t));
                    break;
                case 'r':
                    int r = rand();
                    write(childrenWrite[selfIndex][WRITE_END], &r, sizeof(int));
                    break;
                default:
                    break;
            }
        }
    }

    return 0;
}