#include <stdlib.h> <stdio.h> //system.c
#include <sys/wait.h> /* For WEXITSTATUS */

int main(){
    int outcome = system("echo ciao ; echo $0");
    printf("Outcome = %d %d %d\n",outcome,WEXITSTATUS(outcome), WIFEXITED(outcome));
    outcome = system("notExistingCommand");
    printf("Outcome = %d %d %d\n", outcome, WEXITSTATUS(outcome), WIFEXITED(outcome));
    outcome = system("exit 23");
    printf("Outcome = %d %d %d\n",outcome, WEXITSTATUS(outcome), WIFEXITED(outcome));

    return 0;
}