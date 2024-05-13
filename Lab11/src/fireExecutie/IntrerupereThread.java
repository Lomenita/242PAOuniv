package fireExecutie;

import fireExecutie.threads.FirExecutareInterrupted;
import fireExecutie.threads.FirExecutareInterrupted2;

public class IntrerupereThread {

    public static void main(String[] args) {
        interruptedThread();

        interruptedBoolean();

    }

    private static void interruptedThread(){
        System.out.println("1) exemplu Thread interrupted utilizand Thread.interrupted()");
        FirExecutareInterrupted firExecutareInterrupted = new FirExecutareInterrupted();
        Thread thread = new Thread(firExecutareInterrupted);
        thread.start();

        for (int i = 0; i < 100000; i++) {
            System.out.println(thread.getState());
        }
        thread.interrupt();

        System.out.println("Stare finala thread " + thread.getState());
    }


    private static void interruptedBoolean() {
        System.out.println("2) exemplu Thread interrupted utilizand variabila boolean");
        FirExecutareInterrupted2 firExecutareInterrupted2 = new FirExecutareInterrupted2();
        Thread thread2 = new Thread(firExecutareInterrupted2);
        thread2.start();

        for (int i = 0; i < 10000; i++) {
            System.out.println(thread2.getState());
        }

        firExecutareInterrupted2.setStop(true);

        System.out.println("Stare finala thread2 " + thread2.getState());
    }

}
