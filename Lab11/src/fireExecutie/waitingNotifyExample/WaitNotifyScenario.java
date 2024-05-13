package fireExecutie.waitingNotifyExample;

/*
daemon thread : atunci cand ultimul non daemon thread se termina de executat, se vor termina si daemon threadurile
 t1, t2, t3, t4 se vor incheia atunci cand thread ul principal se incheie
 */
public class WaitNotifyScenario {

    public static void main(String[] args) throws InterruptedException {
        MessageDisplay md = new MessageDisplay();
        Thread t1 = new Thread(() -> { while (true) md.setMessage("Hi!"); }, "t1");
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(() -> { while (true) md.setMessage("Salut!"); }, "t2");
        t2.setDaemon(true);
        t2.start();

        Thread t3 = new Thread(() -> { while (true) md.displayMessage(); }, "t3");
        t3.setDaemon(true);
        t3.start();

        Thread t4 = new Thread(() -> { while (true) md.displayMessage(); }, "t4");
        t4.setDaemon(true);
        t4.start();

        Thread.sleep(50);
        System.out.println("Exit from main.");
    }
}
