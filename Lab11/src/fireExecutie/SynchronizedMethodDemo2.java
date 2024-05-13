package fireExecutie;

import fireExecutie.threads.CounterThread;
import fireExecutie.threads.CounterX;

public class SynchronizedMethodDemo2 {
    public static void main(String[] args) {
        CounterX counter = new CounterX();
        Thread thread1 = new CounterThread(counter);
        Thread thread2 = new CounterThread(counter);

        thread1.start();
        thread2.start();
        System.out.println("Exiting thread " + Thread.currentThread().getName());
    }
}
