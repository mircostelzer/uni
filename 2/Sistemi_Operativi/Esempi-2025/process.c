#include <sys/wait.h>
#include <stdio.h>
#include <unistd.h>
#include <fcntl.h>



int main(int argc, char **argv)
{

 int i;
 int pid, fpid, fpid1;



 i=1;
 printf("il padre assegna i=%d \n", i);
 printf("sono il  processo padre ora  creo il figlio \n");
 pid=fork();  /* genera figlio */
 
 if (pid==0)  {/* codice figlio */
    printf("ciao sono il processo figlio mi hanno appena creato\n");
     i = 10;
     fpid1=getpid();
     printf("sono il figlio con id %d che ha assegnato a i il valore %d\n", fpid1, i);
     sleep(5); /* faccio aspettare un pò il mio creatore, poi termino */
     return(0); 
 }
 else {/* codice padre */
  printf("il padre aspetta la terminazione del figlio che ha creato \n");
  fpid=wait(NULL);
  printf("sono il padre, il figlio con id %d ha terminato\n", fpid);
  printf("sono il padre e per me i= %d \n",i);
 } 

}

