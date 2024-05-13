package fireExecutie.threads;

//utilizare interrupted
public class FirExecutareInterrupted2 implements Runnable{
    private int cnt;

    private boolean stop;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run(){
       while (!stop){
           System.out.println(++cnt + " " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
       }
    }


}
