package fireExecutie;

public class ThreadStates {

    private static Thread t1 = new Thread("T1") {
        @Override public void run() {
            try {
                System.out.println("sleep 1 ms");
                sleep(1);
                for (int i = 0; i < 1000; i++) {
                    System.out.print(i + " ");
                }
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {

        System.out.println("Stare initiala: " + t1.getState());
        t1.start();
        while (true) {
            Thread.State state = t1.getState();
            System.out.println(" Stare : " + state);
            if (state == Thread.State.TERMINATED) {
                break;
            }
        }
    }
}
