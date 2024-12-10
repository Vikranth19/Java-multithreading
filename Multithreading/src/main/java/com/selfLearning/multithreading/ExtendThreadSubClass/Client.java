package com.selfLearning.multithreading.ExtendThreadSubClass;

public class Client {

    public static void main(String[] args){
        System.out.println("Inside main method : " + Thread.currentThread().getName());

        MultiThreadingLearning multithreadingLearning = new MultiThreadingLearning();
        multithreadingLearning.start();

        System.out.println("Finished main method : " + Thread.currentThread().getName());
    }
}
