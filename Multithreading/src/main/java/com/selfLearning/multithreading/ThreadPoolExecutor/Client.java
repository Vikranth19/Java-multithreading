package com.selfLearning.multithreading.ThreadPoolExecutor;

import java.util.concurrent.*;

public class Client {

    public static void main(String[] args){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1,
                TimeUnit.MINUTES, new ArrayBlockingQueue<>(2), new CustomThreadFactory(),
                new CustomRejectedHandler());

        for (int i=1; i<=7; i++){
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (Exception e){
                    //handle exception here
                }

                System.out.println("Task processed by " + Thread.currentThread().getName());
            });
        }

        threadPoolExecutor.shutdown();
    }
}

class CustomRejectedHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task denied " + r.toString());
    }
}

class CustomThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r);
    }
}