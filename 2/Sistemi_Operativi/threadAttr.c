#include <stdio.h> 
#include <pthread.h> 
#include <unistd.h>
#include <errno.h>
#include <string.h>

void * my_fun(void *param){
	printf("This is a thread that received %d\n", *(int *)param);return (void*)3;
}

int main(void){
	pthread_t t_id; pthread_attr_t attr;
	int arg=10, detachSTate;
	pthread_attr_init(&attr);
	pthread_attr_setdetachstate(&attr,PTHREAD_CREATE_DETACHED); //Set detached
	pthread_attr_getdetachstate(&attr,&detachSTate); //Get detach state
	if(detachSTate == PTHREAD_CREATE_DETACHED) printf("Detached\n");
	pthread_create(&t_id, &attr, my_fun, (void *)&arg);
	printf("Executed thread with id %ld\n",t_id);
	pthread_attr_setdetachstate(&attr,PTHREAD_CREATE_JOINABLE); //Inneffective
	sleep(3); pthread_attr_destroy(&attr);
	int esito = pthread_join(t_id, (void **)&detachSTate);
    printf("Error in join: %s\n", strerror(esito));
	printf("Esito '%d' is different 0\n", esito);
    
}