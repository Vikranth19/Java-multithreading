package com.selfLearning.multithreading.SemaphoreLock;

import java.util.concurrent.Semaphore;

public class SharedResource {

    boolean isAvailable = true;

    Semaphore lock = new Semaphore(2);

    public void produce() {
        try {
            lock.acquire();
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
            // Do exception handling
        } finally {
            lock.release();
            System.out.println("Lock released by " + Thread.currentThread().getName());
        }
    }

}
