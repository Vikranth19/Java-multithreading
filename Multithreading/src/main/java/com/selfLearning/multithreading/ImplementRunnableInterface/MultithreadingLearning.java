package com.selfLearning.multithreading.ImplementRunnableInterface;

public class MultithreadingLearning implements Runnable{

    @Override
    public void run() {
        System.out.println("Inside run method of MultithreadingLearning : " + Thread.currentThread().getName());
    }
}
