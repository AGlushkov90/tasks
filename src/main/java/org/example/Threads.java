package org.example;


import java.util.concurrent.CountDownLatch;

// задача - заставить ноги робота шагать по очереди начиная с правой ноги
public class Threads {
    public static void main(String[] args) {
        Robot r = new Robot();
        r.go();
    }
}

class Robot {

    private final Thread rightLeg = new Thread(this::rightStep);
    private final Thread leftLeg = new Thread(this::leftStep);
    private final Thread thirdLeg = new Thread(this::thirdStep);


    public void go() {
        rightLeg.start();
        leftLeg.start();
        thirdLeg.start();
    }

    // TODO после первой иттерации работают всгда два потока. Почему?
    private void rightStep() {
        synchronized (this) {
            while (true) {
                notifyAll();
                System.out.println("right");
                try {
                    wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void leftStep() {
        synchronized (this) {
            while (true) {
                notifyAll();
                System.out.println("left");
                try {
                    wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void thirdStep() {
        synchronized (this) {
            while (true) {
                notifyAll();
                System.out.println("third");
                try {
                    wait();
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
