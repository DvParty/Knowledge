package com.dvparty.thread;

import java.text.SimpleDateFormat;

public class ImplementsRunnable implements Runnable{

    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy MM:mm:ss");

        String tName = Thread.currentThread().getName();
        Long threadId = Thread.currentThread().getId();

        for(int i = 0; i < 10; i++){
            System.out.println(i + " [" + dateFormat.format(System.currentTimeMillis()) + "]" + tName + "::::[ThreadId]::" + threadId);

            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
