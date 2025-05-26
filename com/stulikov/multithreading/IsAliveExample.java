package com.stulikov.multithreading;

public class IsAliveExample {
    public static void main(String[] args) throws InterruptedException {
        RunnableExample runnableExample = new RunnableExample("1");

        Thread thread = new Thread(runnableExample);
        System.out.println("Before starting "+ thread.isAlive());
        thread.start();
        System.out.println("After starting "+ thread.isAlive());
        thread.join();
        System.out.println("After thread completed "+ thread.isAlive());

    }
}
