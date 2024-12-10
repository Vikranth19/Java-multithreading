package com.selfLearning.multithreading.MonitorLock;

public class MonitorLockExample {

    public synchronized void task1() {
        try {
            System.out.println("Inside task1");
            Thread.sleep(10000);
            System.out.println("Task1 completed");
        } catch (Exception e){
            System.out.println("Exception here");
        }
    }

    public void task2() {
        System.out.println("Inside task2, before synchronized");
        synchronized (this){
            System.out.println("Task2, inside synchronized");
        }
    }

    public void task3(){
        System.out.println("Inside task3");
    }
}
