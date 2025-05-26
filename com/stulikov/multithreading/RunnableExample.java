package com.stulikov.multithreading;

public class RunnableExample implements Runnable {

    private String localeName;

    public RunnableExample(String localeName) {
        this.localeName = localeName;
    }

    @Override
    public void run() {
        System.out.println("Thread "+ localeName + " run");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableExample("1"));
        Thread thread2 = new Thread(new RunnableExample("2"));
        Thread thread3 = new Thread(new RunnableExample("3"));
        Thread thread4 = new Thread(new RunnableExample("4"));
        Thread thread5 = new Thread(new RunnableExample("5"));
        Thread thread6 = new Thread(new RunnableExample("6"));
        Thread thread7 = new Thread(new RunnableExample("7"));

        thread1.setPriority(Thread.MAX_PRIORITY);
//        thread2.setPriority(Thread.MIN_PRIORITY);
//        thread3.setPriority(Thread.NORM_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();


    }
}
