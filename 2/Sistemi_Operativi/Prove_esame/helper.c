#include <fcntl.h>
#include <sys/stat.h>
#include <stdio.h>
#include <unistd.h>


int main()
{
    char *loginFifo = "/tmp/login.fifo";
    mkfifo(loginFifo, S_IRUSR | S_IWUSR);
    int fd2 = open(loginFifo, O_WRONLY);

    sleep(1);
    write(fd2, "password\n", sizeof("password\n"));
    sleep(1);
    write(fd2, "ciao", sizeof("ciao"));
    sleep(1);
    write(fd2, "password", sizeof("password"));

    close(fd2);
}