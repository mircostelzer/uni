#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <signal.h>
#include <bits/sigaction.h>
#include <sys/stat.h>
#include <pthread.h>
#include <string.h>
#include <sys/ipc.h>
#include <sys/msg.h>

#define MAX_SIZE 256

int fd, fd1;
pid_t lastPid;

struct msg_buffer{
	long mtype;
	char mtext[100];
} message;

void terminalStopHandler(int signo) {
    printf("Terminating...\n");
    close(fd);
    close(fd1);
    exit(0);
}

void *login(void *arg) {
    char password[MAX_SIZE];
    char toCompare[MAX_SIZE];

    pid_t pid;

    int fd3 = open("/tmp/secret.txt", O_RDONLY);
    if (fd3 < 0) {
        fprintf(stderr, "Error in opening fifo\n");
        perror("Error");
    }
    int r = read(fd3, password, MAX_SIZE-1);
    password[r] = 0;

    char *loginFifo = "/tmp/login.fifo";
    mkfifo(loginFifo, S_IRUSR | S_IWUSR);
    int fd2 = open(loginFifo, O_RDONLY);

    __key_t key = ftok(loginFifo, 51);
    int queueId = msgget(key, 0666 | IPC_CREAT);

    while(1) {
        r = read(fd2, toCompare, MAX_SIZE-1);
        if (r > 0) {
            pid = lastPid;

            printf("Passed lock\n");
            toCompare[r] = 0;
            message.mtype = pid;
            strcpy(message.mtext, toCompare);
            msgsnd(queueId, &message, sizeof(message.mtext), 0);

            if (strcmp(password, toCompare) == 0) {
                printf("OK\n");
                fprintf(stderr, "%s logged in\n", (char *)arg);
            } else {
                printf("NO\n");
            }
        }
    }
}

int main(int argc, char *argv)
{
    char username[MAX_SIZE];
    char password[MAX_SIZE];

    char buffer[MAX_SIZE];

    FILE* input = fopen("/tmp/credentials.txt", "r");
    if (input == NULL) {
        fprintf(stderr, "[Error] Credentials file not found\n");
        exit(1);
    }
    fscanf(input, "%s", username);
    fscanf(input, "%s", password);
    fclose(input);

    FILE* output = fopen("/tmp/secret.txt", "w+");
    if (output == NULL) {
        fprintf(stderr, "[Error] Couldn't create the secret file\n");
        exit(1);
    }

    fprintf(output, "%s", password);
    fclose(output);

    struct sigaction sa;
    sa.sa_flags = 0;
    sa.sa_handler = terminalStopHandler;
    sigaction(SIGTSTP, &sa, NULL);

    char *authFifo = "/tmp/authenticator.fifo"; 
    mkfifo(authFifo, S_IRUSR | S_IWUSR);
    
    sprintf(buffer, "%d", getpid());
    fd = open(authFifo, O_RDWR);
    if (fd < 0) {
        fprintf(stderr, "Error in opening fifo\n");
        perror("Error");
    }
    write(fd, buffer, sizeof(pid_t));

    pthread_t t_id;
    pthread_create(&t_id, NULL, login, (void*)username);

    char *clientsFifo = "/tmp/clients.fifo";
    mkfifo(clientsFifo, S_IRUSR | S_IWUSR);
    fd1 = open(clientsFifo, O_RDONLY);
    if (fd1 < 0) {
        fprintf(stderr, "Error in opening fifo\n");
        perror("Error");
    }

    pid_t pid;
    while(1) {
        int r = read(fd1, &pid, sizeof(pid_t));
        lastPid = pid;
        kill(pid, SIGUSR1);
    }


    close(fd);
    close(fd1);
}