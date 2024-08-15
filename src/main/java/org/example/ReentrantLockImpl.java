package org.example;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// задача - заставить ноги робота шагать по очереди начиная с правой ноги
public class ReentrantLockImpl {
    public static void main(String[] args) {
        RobotReentrantLock r = new RobotReentrantLock();
        r.go();
    }
}

class RobotReentrantLock {

    private final Thread rightLeg = new Thread(this::rightStep);
    private final Thread leftLeg = new Thread(this::leftStep);
    private final Thread thirdLeg = new Thread(this::thirdStep);
//    private final ReentrantLock re = new ReentrantLock(true);
    private final ReentrantLock re = new ReentrantLock();
    private final Condition condition = re.newCondition();

    public void go() {
        rightLeg.start();
        leftLeg.start();
        thirdLeg.start();
    }

    private void rightStep() {

            while (true) {
                re.lock();
                try{
                    condition.signalAll();
                System.out.println("right");

                condition.await();
                    Thread.sleep(1000);
            }
         catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            re.unlock();
        }}
    }

    private void leftStep() {
        while (true) {
            re.lock();
            try{
                condition.signalAll();
                System.out.println("left");
                condition.await();
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                re.unlock();
            }}
    }

    private void thirdStep() {
        while (true) {
            re.lock();
            try {
                condition.signalAll();
                System.out.println("third");
                condition.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                re.unlock();
            }
        }
    }
}
