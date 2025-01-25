package com.selfLearning.multithreading.ForkJoinPoolExample;

import java.util.concurrent.RecursiveTask;

public class ComputeTask extends RecursiveTask<Integer> {

    int start;
    int end;

    ComputeTask(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end-start <= 4){
            int totalSum = 0;
            for(int i = start; i<=end; i++){
                totalSum+=i;
            }

            return totalSum;
        } else{
            //split task
            int mid = (start + end)/2;

            ComputeTask computeTask1 = new ComputeTask(start, mid);
            ComputeTask computeTask2 = new ComputeTask(mid+1, end);

            //fork tasks for parallel execution
            computeTask1.fork();
            computeTask2.fork();

            //combine results
            int result1 = computeTask1.join();
            int result2 = computeTask2.join();

            return result1+result2;
        }
    }
}
