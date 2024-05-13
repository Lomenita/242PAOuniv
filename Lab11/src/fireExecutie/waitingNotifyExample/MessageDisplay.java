package fireExecutie.waitingNotifyExample;

public class MessageDisplay {
    private String message;

    public synchronized void displayMessage() {
        String threadName = Thread.currentThread().getName();
        while (this.message == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + ": " + this.message);
        this.message = null;
        notifyAll();
    }

    public synchronized void setMessage(String message) {
        String threadName = Thread.currentThread().getName();
        while (this.message != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        System.out.println(threadName + ": Mesajul setat este " + this.message);
        notifyAll();
    }
}
