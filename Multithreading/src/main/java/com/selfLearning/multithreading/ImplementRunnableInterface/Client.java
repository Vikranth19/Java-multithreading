package com.selfLearning.multithreading.ImplementRunnableInterface;

public class Client {

    public static void main(String[] args){
        System.out.println("Inside main method : " + Thread.currentThread().getName());

        MultithreadingLearning multithreadingLearning = new MultithreadingLearning();
        Thread thread = new Thread(multithreadingLearning);
        thread.start();

        System.out.println("Finished main method : " + Thread.currentThread().getName());
    }
}
