package fireExecutie;

import fireExecutie.threads.CounterX;

public class SynchronizedMethodDemo {
    public static void main(String[] args) {
        CounterX counter = new CounterX();

        Runnable r = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
            }

            System.out.println("Exiting " + Thread.currentThread().getName());
        };
        new Thread(r).start();
        new Thread(r).start();
        System.out.println("Exiting thread " + Thread.currentThread().getName());
    }
}
