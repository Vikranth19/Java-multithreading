package com.selfLearning.multithreading.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Client {

    public static void main(String[] args){
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            sharedResource.produce(lock);
        });

        Thread thread2 = new Thread(() -> {
            sharedResource.produce(lock);
        });

        Thread thread3 = new Thread(() -> {
            sharedResource.consume(lock);
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
