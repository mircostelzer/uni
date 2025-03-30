#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>

void *tbody(void *arg)
 {
    int j;
    static pthread_key_t key;
    char *private_data;

	 pthread_key_create(&key, NULL);
	 private_data = malloc(100);
	 pthread_setspecific(key, private_data);
	 sprintf(private_data, "Questi sono dati solo miei");
	 printf("T2: %s\n", private_data);
	 j=25;
     printf("T2: ciao sono un thread, mi hanno appena creato\n");
     printf("T2: Il thread creato ha assegnato %d ad j\n",j);
     *(int *)arg = 10;
     sleep(5); /* faccio aspettare un pò il mio creatore, poi termino */
     free(private_data);
     pthread_exit((int *)50); /* oppure return ((int *)50); */
}


int main(int argc, char **argv)
{

 int i;
 pthread_t mythread;
//  pthread_attr_t *attr;
 void *result;

 i=1;
 printf("T1: i=%d \n", i);
//  int pthread_attr_init(pthread_attr_t *attr);
 printf("T1: sono il primo thread, ora ne creo un altro \n");
 pthread_create(&mythread, NULL, tbody, (void *) &i);
 printf("T1: ora aspetto la terminazione del thread che ho creato \n");
 pthread_join(mythread, &result);
 printf("T1: Il thread creato ha assegnato %d ad i\n",i);
 printf("T1: Il thread ha restituito %d \n", *(int *)&result);
 

}

