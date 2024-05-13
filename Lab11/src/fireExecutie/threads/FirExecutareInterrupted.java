package fireExecutie.threads;

//utilizare interrupted
public class FirExecutareInterrupted implements Runnable{
    private int cnt;

    @Override
    public void run(){
       while (!Thread.interrupted()){
           System.out.println(++cnt + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
       }
    }
}
