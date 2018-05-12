# Thread
## Overview  
 첫번째 주제는 Thread로, Thread의 개념 및 개발 시 신경써야 할 특징들에 대해서 알아볼 것입니다. 보통 Thread 실습 시 C언어를 사용하지만, 이번 Sample Code는 저희 그룹의 주력 언어인 JAVA를 사용할 것입니다. 기본적으로 Thread는 Process에 대한 이해가 필요하기 때문에 Process 선행학습 역시 포함되어 있습니다.  
   
## Contents
1. [Process](#Process)  
    1-1. Process란 무엇인가?  
    1-2. Process Address Space  
    1-3. Process Life Cycle  
    1-4. Process Scheduling  
    1-5. Fork  

2. [Thread](#Thread)  
    2-1. Thread가 필요한 이유?  
    2-2. Multi Thread  
    2-3. Thread Handling  

3. [Synchronization(동기화)](#Synchronization)  
    3-1. 동기화가 필요한 이유?  
    3-2. Critical Section Problem  
    3-3. Semaphores / Mutex

## Process
1. Process란 무엇인가?  
    - 현재 실행중인 프로그램
    - PCB(Process Control Block)을 가진 프로그램  
    ※ PCB란 PID, 프로세스 상태, 프로세스 우선순위, Program Counter, Register 등 프로세스 실행에 필요한 구조체
    - RAM에 올라온 프로그램
    - CPU를 할당받는 실체

2. Process Address Space
    - 프로세스는 단순한 프로그램 이상의 정보를 갖는다.
    - 메모리 상의 프로세스  
            ![process_address_space](https://steemitimages.com/400x0//https://raw.githubusercontent.com/DvParty/Knowledge/master/ProcessThread20180519/imgs/process_address_space.png)  
            *[그림 1] Process 메모리 구조*
    - 동적으로 변하는 영역  
    Stack: 로컬변수, 인자(Params/args)  
    Heap: 동적할당 메모리
    - 프로그램 영역  
    Data: 전역변수, Static 변수  
    Text: Program code

3. Process Life Cycle
    - 프로세스는 메모리에 올라온 순간부터 다음과 같은 생명 주기를 거친다.  
            ![process_life_cycle](https://steemitimages.com/500x0//https://raw.githubusercontent.com/DvParty/Knowledge/master/ProcessThread20180519/imgs/process_life_cycle.png)  
            *[그림2] Process 생명주기*


4. Process Scheduling  
한정된 메모리, CPU 성능으로 한번에 하나의 Process만을 실행할 수 없었던 과거 컴퓨팅 환경이, 기술 발전에 따라 Multi Process 환경으로 전환됨으로써 Process의 실행 순서를 결정하는 것이 주요 이슈로 떠올랐다.
    - Context Switch  
    : 실행중인 프로세스에서 다른 프로세스로 전환하는 과정  
    : Context Switch는 시간이 오래 걸리기 때문에 오버헤드를 줄이는 것이 주요 이슈  
    : 이는 스케쥴링 알고리즘을 활용하여 해결한다.  

5. fork() - Process의 생성  
프로세스는 시스템콜 fork()를 호출하여 부모 프로세스는 상속하여 생성한다. 부모 프로세스는 상복받기 때문에 생성된 프로세스들은 tree 형태를 갖는다. 우리가 사용하는 운영체제는 최초의 프로세서 init이 존재-커널에서 생성-하여 init 프로세스를 상속함으로써 프로세스를 생성한다.