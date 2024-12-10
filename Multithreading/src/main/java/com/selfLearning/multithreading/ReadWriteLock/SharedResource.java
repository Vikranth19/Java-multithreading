package com.selfLearning.multithreading.ReadWriteLock;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    boolean isAvailable = true;

    public void produce(ReadWriteLock lock){
        try {
            lock.readLock().lock();
            System.out.println("Read lock acquired by " + Thread.currentThread().getName());
            Thread.sleep(6000);
        } catch (Exception e) {
            // Do exception handling
        } finally {
            lock.readLock().unlock();
            System.out.println("Lock released by " + Thread.currentThread().getName());
        }
    }

    public void consume(ReadWriteLock lock){
        try {
            lock.writeLock().lock();
            System.out.println("Write lock acquired by " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            // Do exception handling
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write lock released by " + Thread.currentThread().getName());
        }
    }
}
