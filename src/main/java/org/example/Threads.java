package org.example;


import java.util.concurrent.CountDownLatch;

// задача - заставить ноги робота шагать по очереди начиная с правой ноги
public class Threads {
    public static void main(String[] args) {
    Robot r = new Robot();
    r.go();
    }
}

class Robot{

   private final Thread rightLeg = new Thread(this::rightStep);
   private final Thread leftLeg = new Thread(this::leftStep);

    public void go() {
            rightLeg.start();
            leftLeg.start();
    }

    private void rightStep() {
        while (true){
            System.out.println("right");
        }
    }

    private void leftStep(){
        while (true){
            System.out.println("left");
        }
    }
}
