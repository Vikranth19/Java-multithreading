package com.selfLearning.multithreading.RunnableVsCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Client {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        Future<?> future = threadPoolExecutor.submit(() -> {
            try {
                System.out.println("Task 1 being executed right now by the thread");
            } catch (Exception e) {

            }
        });

        try {
            Object o = future.get();
            System.out.println(o);
        } catch (Exception e) {

        }

        List<Integer> list1 = new ArrayList<>();

        Future<List<Integer>> future2 = threadPoolExecutor.submit(() -> {
            System.out.println("Task 2 being executed right now by the thread");
            list1.add(200);
        }, list1);

        try {
            List<Integer> list2 = future2.get();
            System.out.println(list2.getFirst());
        } catch (Exception e) {

        }

        Future<List<Integer>> future3 = threadPoolExecutor.submit(() -> {
            System.out.println("Task 3 being executed right now by the thread");
            list1.add(300);
            return list1;
        });

        try {
            List<Integer> list3 = future3.get();
            System.out.println(list3.get(1));
        } catch (Exception e) {

        }

    }
}
