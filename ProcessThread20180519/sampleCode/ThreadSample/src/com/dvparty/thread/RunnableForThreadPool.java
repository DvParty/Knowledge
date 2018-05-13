package com.dvparty.thread;

import java.text.SimpleDateFormat;

public class RunnableForThreadPool implements Runnable{

    private int nTask;

    public RunnableForThreadPool(int nTask){
        this.nTask = nTask;
    }

    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy MM:mm:ss");

        String tName = Thread.currentThread().getName();
        Long threadId = Thread.currentThread().getId();

        for(int i = 0; i < 2; i++) {
            System.out.println("TaskNumber:" + this.nTask + " [" + dateFormat.format(System.currentTimeMillis()) + "]" + tName + "::::[ThreadId]::" + threadId + "::LOOP-" + i);
        }
    }
}
