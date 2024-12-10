package com.selfLearning.multithreading.StampedLockOptimistic;

public class Client {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(sharedResource::producer);

        Thread thread2 = new Thread(sharedResource::consume);

        thread1.start();
        thread2.start();
    }
}
