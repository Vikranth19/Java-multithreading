package com.selfLearning.multithreading.OddEvenExample;

public class Counter {

    public volatile static int cnt = 1;

    public int maxLimit;

    Counter(int maxLimit){
        this.maxLimit = maxLimit;
    }

    public synchronized void printOdd() {
        while (cnt<=maxLimit){
            if(cnt%2==1){
                System.out.println("Printing odd num in curr thread " + Thread.currentThread().getName() + " " + cnt);
                cnt++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (Exception e){
                    //Handle exception
                }
            }
        }
    }

    public synchronized void printEven() {
        while (cnt<=maxLimit){
            if(cnt%2==0){
                System.out.println("Printing even num in curr thread " + Thread.currentThread().getName() + " " + cnt);
                cnt++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (Exception e){
                    //Handle exception
                }
            }
        }
    }
}
