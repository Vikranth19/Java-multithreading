package com.selfLearning.multithreading.Future;

import java.util.concurrent.*;

public class Client {

    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS,  new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> future = threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(7000);
                System.out.println("Task being executed right now by the thread");
            } catch (Exception e){

            }
        });

        System.out.println("Is task done - " + future.isDone());

        try {
            //blocks main thread for 2 seconds
            future.get(2, TimeUnit.SECONDS);
        } catch (TimeoutException e){
            System.out.println("Timeout exception happened");
        } catch (Exception e){

        }

        try {
            future.get();
        } catch (Exception e){

        }

        System.out.println("Is task done - " + future.isDone());
        System.out.println("Is cancelled - " + future.isCancelled());
    }
}
