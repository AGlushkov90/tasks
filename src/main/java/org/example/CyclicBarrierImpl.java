package org.example;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// задача - заставить ноги робота шагать по очереди начиная с правой ноги
public class CyclicBarrierImpl {
    public static void main(String[] args) {
        RobotCyclicBarrier r = new RobotCyclicBarrier();
            r.go();
    }
}

class RobotCyclicBarrier {
    private final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public void go() {
        while (true) {
        new Thread(this::rightStep).start();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        new Thread(this::leftStep).start();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void rightStep() {
                System.out.println("right");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    private void leftStep() {
        System.out.println("left");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

}
