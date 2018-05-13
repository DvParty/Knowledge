package com.dvparty.thread;

public class Main {

    public static void main(String[] args){

        ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        Thread imlRunnable = new Thread(implementsRunnable, "implementsRunnalbe");
        imlRunnable.start();

        ExtendsThread extendsThread = new ExtendsThread();
        extendsThread.setName("extendsThread");
        extendsThread.start();
    }
}
