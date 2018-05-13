package com.dvparty.thread;

import java.text.SimpleDateFormat;

public class ImplementsRunnable implements Runnable{


    @Override
    public void run() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy MM:mm:ss");

        String tName = Thread.currentThread().getName();

        for(int i = 0; i < 10; i++){
            System.out.println("[" + dateFormat.format(System.currentTimeMillis()) + "]" + tName + "::::" + i);

            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
