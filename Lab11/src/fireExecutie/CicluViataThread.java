package fireExecutie;

import fireExecutie.threads.FirExecutare;

/*
sunt 3 fire de executie: 1 si 2 sunt din FirExecutare, 0 este thread ul principal
Firele de executie 1 si 2 vor incepe sa ruleze. Join va face thread ul principal sa astepte ca
firExecutare1 si firExecutare2 sa termine
 */
public class CicluViataThread {

    public static void main(String[] args) {
        FirExecutare firExecutare1 = new FirExecutare('1');
        FirExecutare firExecutare2 = new FirExecutare('2');
        firExecutare1.start();
        firExecutare2.start();

       try {
            firExecutare1.join();
            firExecutare2.join();
        }catch (InterruptedException e){
            System.out.println("exceptie " + e.getMessage());
        }

        for (int i = 0; i < 10000; i++) {
            System.out.print("0 ");
        }
    }
}
