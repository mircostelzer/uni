#include <sys/stat.h>
#include <sys/types.h> 
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h> //fifoRDWR3.c

void main(){
	char buffer[10], * fifoName = "/tmp/fifo1";
	int fd;
	mkfifo(fifoName,S_IRUSR|S_IWUSR); //Create pipe if it doesn’t exist
	if (fork() == 0){ //Child
		fd = open(fifoName,O_RDWR); //Open pipe in readwrite
		printf("Open write %d\n",fd);
		write(fd,"Hello",5);
	}else{
		fd = open(fifoName,O_RDONLY | O_NONBLOCK); //We need nonblock
		sleep(2);
		if(fd != -1){
			printf("Open read\n");
			int bytesRead = read(fd,buffer,10);
			printf("Read %d bytes: %s\n",bytesRead,buffer); //We will read the data because even if there is no write-side opened, the
																											//read-side was opened before the write side was closed!
		}
	}
	close(fd);
}