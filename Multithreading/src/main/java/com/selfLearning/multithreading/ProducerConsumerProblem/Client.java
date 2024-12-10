package com.selfLearning.multithreading.ProducerConsumerProblem;

public class Client {

    public static void main(String[] args){
        SharedResource sharedResource = new SharedResource(3);

        Thread producerThread = new Thread(() -> {
            try {
                for(int i=1; i<=6; i++){
                    sharedResource.produce(i);
                }
            } catch (Exception e){
                System.out.println("Exception occurred");
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for(int i=1; i<=6; i++){
                    sharedResource.consume();
                }
            } catch (Exception e){
                System.out.println("Exception occurred");
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
