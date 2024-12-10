package com.selfLearning.multithreading.ReentrantLockExample;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable = true;

    public void produce(ReentrantLock lock){
        try {
            lock.lock();
            System.out.println("Lock acquired by " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(4000);
        } catch (Exception e) {
            // Do exception handling
        } finally {
            lock.unlock();
            System.out.println("Lock released by " + Thread.currentThread().getName());
        }
    }
}
