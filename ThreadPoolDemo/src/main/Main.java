package main;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

       new Main().run();
    }

    private void run() {

        try {
            ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

            for (int i = 0; i < 8; i++) {
                service.execute(new Worker());
                service.execute(this::methodWorker);
                service.execute(()->methodWorker());
            }

            service.shutdown();
            System.out.println("Hello world!");
            service.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);


            System.out.println("Hello world!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void methodWorker() {
        Random random = new Random();
        try {
            int duration = random.nextInt(2000);
            Thread.sleep(duration);

            System.out.println("Thread " + Thread.currentThread().getId() + " terminatetd");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        Random random = new Random();
        try {
            int duration = random.nextInt(2000);
            Thread.sleep(duration);

            System.out.println("Thread " + Thread.currentThread().getId() + " terminatetd");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}