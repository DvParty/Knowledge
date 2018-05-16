package com.dvparty.thread;

public class MethodSync {

    private String curDate;
    private String tName;

    public MethodSync(String curDate, String tName) {
        this.curDate = curDate;
        this.tName = tName;
    }

    public synchronized void test(){
        for(int i = 0; i < 5; i++) {
            System.out.println("[" + curDate + "] " + tName);
        }
    }
}
