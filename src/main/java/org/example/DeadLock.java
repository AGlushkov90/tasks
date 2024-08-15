package org.example;


import java.security.spec.RSAOtherPrimeInfo;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

//написать дедлок и предложить его пути решения
public class DeadLock {
    public static void main(String[] args) {
        Work work = new Work();
        work.start();
    }

}

class Work{
    private final Thread first = new Thread(this::firstJob);
    private final Thread second = new Thread(this::secondJob);
    private final Object a = new Object();
    private final Object b = new Object();
    private final CountDownLatch countDownLatch = new CountDownLatch(2);

    public void start(){
        first.start();
        second.start();
    }

    private void firstJob() {
        synchronized (a){
                countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (b){
                System.out.println(b);
            }
        }

    }

    private void secondJob() {
        synchronized (b){
            countDownLatch.countDown();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (a){
                System.out.println(a);
            }
        }
    }
}