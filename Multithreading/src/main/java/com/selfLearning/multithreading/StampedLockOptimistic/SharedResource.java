package com.selfLearning.multithreading.StampedLockOptimistic;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    int a = 10;

    StampedLock lock = new StampedLock();

    public void producer() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic lock");
            a = 11;
            Thread.sleep(6000);
            if (lock.validate(stamp)) {
                System.out.println("updated a value successfully");
            } else {
                System.out.println("Rollback of work");
                a = 10; //rollback
            }
        } catch (Exception e) {
            //Handle exception
        }
    }


    public void consume() {

        long stamp = lock.writeLock();
        System.out.println("write lock acquired by : " + Thread.currentThread().getName());
        try {
            a = 9;
            System.out.println("performing work");
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("write lock released by : " + Thread.currentThread().getName());
        }
    }

}
