package com.selfLearning.multithreading.CompletableFuture;

import java.util.concurrent.*;

public class Client {

    public static void main(String[] args){

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //1
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Inside supply async thread " + Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (Exception e){

            }
            return "Ans1";
        }, threadPoolExecutor);


        //Thenapply vs thenapplyasync
        CompletableFuture<String> stringCompletableFuture2 = stringCompletableFuture.thenApplyAsync((String ans) -> {
            System.out.println("Inside thenapply " + Thread.currentThread());
            return ans + "Ans2";
        }, threadPoolExecutor);

        //thencompose vs thencomposeasync

        //thenaccept vs thenacceptasync
    }
}
