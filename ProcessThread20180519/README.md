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
    <figure><img src="https://raw.githubusercontent.com/DvParty/Knowledge/master/ProcessThread20180519/imgs/process_address_space.png" width="400"/><figcaption><i>[그림 1] Process 메모리 구조</i></figcaption></figure>
    - 동적으로 변하는 영역  
    Stack: 로컬변수, 인자(Params/args)  
    Heap: 동적할당 메모리
    - 프로그램 영역  
    Data: 전역변수, Static 변수  
    Text: Program code

3. Process Life Cycle
    - 프로세스는 메모리에 올라온 순간부터 다음과 같은 생명 주기를 거친다.  
    <figure><img src="https://raw.githubusercontent.com/DvParty/Knowledge/master/ProcessThread20180519/imgs/process_life_cycle.png" width="500"/><figcaption><i>[그림2] Process 생명주기</i></figcaption></figure>