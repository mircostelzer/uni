#include <fcntl.h>
#include <sys/stat.h>
#include <stdio.h>
#include <unistd.h>


int main()
{
    char *fifo = "/tmp/clients.fifo";
    mkfifo(fifo, S_IRUSR | S_IWUSR);
    int fd2 = open(fifo, O_WRONLY);
    char buffer[10];

    sprintf(buffer, "%d", 20394);
    write(fd2, buffer, sizeof(pid_t));
    sleep(1);
    sprintf(buffer, "%d", 34282);
    write(fd2, buffer, sizeof(pid_t));

    close(fd2);
}
