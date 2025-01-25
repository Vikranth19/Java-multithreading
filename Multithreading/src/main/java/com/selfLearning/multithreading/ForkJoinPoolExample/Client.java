package com.selfLearning.multithreading.ForkJoinPoolExample;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Client {

    public static void main(String[] args){
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        Future<Integer> future = forkJoinPool.submit(new ComputeTask(0,100));

        try {
            System.out.println("Result " + future.get());
        } catch (Exception e){

        }
    }
}
