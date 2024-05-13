package fireExecutie.threads;

public class FirExecutare extends Thread{
    private char c;

    public FirExecutare(char c){
        this.c = c;
    }

    @Override
    public void run(){
        for (int i = 0; i < 100 ; i++) {
            System.out.print(c + " ");
        }
    }
}
