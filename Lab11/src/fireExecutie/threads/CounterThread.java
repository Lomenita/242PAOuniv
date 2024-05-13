package fireExecutie.threads;

public class CounterThread extends Thread{
    private CounterX counter;

    public CounterThread(CounterX counter) {
        this.counter = counter;
    }

    @Override
    public void run(){
        for (int i = 0; i < 5; i++) {
            counter.increment();
        }

        System.out.println("Exiting " + Thread.currentThread().getName());
    }
}

