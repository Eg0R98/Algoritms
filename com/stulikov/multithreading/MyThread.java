package com.stulikov.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class MyThread {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();

        Thread worker = new Thread(() -> {
       while (true){
           Runnable task = queue.get();
           task.run();
       }});
        worker.start();

        for (int i = 0; i < 10; i++) {
            queue.put(getTask());
        }
    }

    public static Runnable getTask(){
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Task start "+ this);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task finished "+ this);
            }
        };
    }

    static class BlockingQueue {
        List<Runnable> tasks = new ArrayList<>();

        synchronized void put(Runnable task) {
            tasks.add(task);
            notify();
        }

        public synchronized Runnable get(){
            while (tasks.isEmpty()){
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Runnable task = tasks.get(0);
            tasks.remove(task);
            return task;
        }
    }
}
