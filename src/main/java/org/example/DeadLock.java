package org.example;


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

    public void start(){
        first.start();
        second.start();
    }

    private void firstJob() {

    }

    private void secondJob() {

    }
}