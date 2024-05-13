package fireExecutie.threads;

public class CounterX {
    private int counter;

    public synchronized void increment() {
//public void increment() {
        System.out.println(Thread.currentThread().getName()
                + ": old:" + counter + " new:" + ++counter);
    }
}
