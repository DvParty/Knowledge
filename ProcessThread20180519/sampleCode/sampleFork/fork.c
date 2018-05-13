#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>

int main()
{
	pid_t pid;

	// fork another process
	pid = fork();
	if(pid < 0){ 
		// error occured
		fprintf(stderr, "Fork Failed");
		exit(-1);
	}
	else if(pid == 0){
		// child process
		execlp("/bin/pwd", "pwd", NULL);
	}
	else{
		// parent process
		wait(NULL);
		printf("Child %d process complete", pid);
		exit(0);
	}
}
