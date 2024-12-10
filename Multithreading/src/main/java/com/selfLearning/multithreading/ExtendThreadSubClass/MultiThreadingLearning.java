package com.selfLearning.multithreading.ExtendThreadSubClass;

public class MultiThreadingLearning extends Thread{

    @Override
    public void run() {
        System.out.println("Inside run of MultiThreadingLearning " + Thread.currentThread().getName());
    }
}
