package com.dvparty.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){

        /*
        // Runnable
        ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        Thread imlRunnable = new Thread(implementsRunnable, "implementsRunnalbe");
        imlRunnable.start();

        // Thread
        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.setName("extendsThread");
        extendsThread.start();
        */

        /*
        // Thread Pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);  // MAX Thread number: 3

        // Execute 10 implementsRunnable by executorService
        for(int i = 0; i < 10; i++){
            RunnableForThreadPool runnableForThreadPool = new RunnableForThreadPool(i);

            executorService.execute(runnableForThreadPool);

            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        */


        // Synchronization
        ImplementsRunnable syncRunnable0 = new ImplementsRunnable();
        ImplementsRunnable syncRunnable1 = new ImplementsRunnable();
        ImplementsRunnable syncRunnable2 = new ImplementsRunnable();

        Thread t0 = new Thread(syncRunnable0, "syncRunnable0");
        Thread t1 = new Thread(syncRunnable1, "syncRunnable1");
        Thread t2 = new Thread(syncRunnable2, "syncRunnable2");

        t0.start();
        t1.start();
        t2.start();
    }
}
