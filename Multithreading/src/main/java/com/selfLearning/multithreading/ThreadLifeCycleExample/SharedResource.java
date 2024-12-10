package com.selfLearning.multithreading.ThreadLifeCycleExample;

public class SharedResource {

    private boolean isItemAvailable = false;

    //Put the monitor lock
    public synchronized void addItem(){
        isItemAvailable = true;
        System.out.println("Item added by " + Thread.currentThread().getName() + " and invoking all threads which are waiting");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consume item invoked by " + Thread.currentThread().getName());

        while (!isItemAvailable){
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " is waiting now");
                wait(); //releases monitor lock so that producer thread can call addItem
            } catch (Exception e){
                System.out.println("Exception occurred");
            }
        }

        System.out.println("Item consumed by " + Thread.currentThread().getName());
        isItemAvailable = false;
    }
}
