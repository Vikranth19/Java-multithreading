package com.selfLearning.multithreading.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> sharedBuffer;
    private int bufferSize;

    public SharedResource(int bufferSize){
        sharedBuffer = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void produce(int item) throws Exception {
        //If buffer is full it'll be in waiting state
        while(sharedBuffer.size()==bufferSize){
            System.out.println("Buffer is full, producer is waiting for the consumer");
            wait();
        }

        sharedBuffer.add(item);
        System.out.println("Produced item - " + item);
        //Notify consumer that there are items to consume
        notify();
    }

    public synchronized int consume() throws Exception{
        //If buffer is empty keep waiting
        while (sharedBuffer.isEmpty()){
            System.out.println("Buffer is empty, consumer is waiting to consume");
            wait();
        }

        int item = sharedBuffer.poll();
        System.out.println("Consumed item - " + item);
        notify();
        //Notify producer that there are items to produce
        return item;
    }
}
