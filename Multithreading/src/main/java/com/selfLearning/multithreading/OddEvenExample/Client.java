package com.selfLearning.multithreading.OddEvenExample;

public class Client {

    public static void main(String[] args){
        Counter counter = new Counter(10);

        Thread tOdd = new Thread(counter::printOdd);
        tOdd.setName("Odd");
        Thread tEven = new Thread(counter::printEven);
        tEven.setName("Even");

        tOdd.start();
        tEven.start();
    }
}
