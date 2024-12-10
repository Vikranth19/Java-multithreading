package com.selfLearning.multithreading.ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class Client {

    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();

        SharedResource resource1 = new SharedResource();
        Thread thread1 = new Thread(() -> {
            resource1.produce(lock);
        });

        SharedResource resource2 = new SharedResource();
        Thread thread2 = new Thread(() -> {
            resource2.produce(lock);
        });

        thread1.start();
        thread2.start();
    }

}
