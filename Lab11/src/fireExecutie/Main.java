package fireExecutie;

import fireExecutie.threads.FirExecutare;

/*
sunt 3 fire de executie: 1 si 2 sunt din FirExecutare, 0 este thread ul principal
Firele de executie vor rula random, in momentul in care schedulerul le da permisiunea
 */

public class Main {
    public static void main(String[] args) {
        FirExecutare firExecutare1 = new FirExecutare('1');
        FirExecutare firExecutare2 = new FirExecutare('2');
        firExecutare1.start();
        firExecutare2.start();
        for (int i = 0; i < 1000; i++) {
            System.out.print("0 ");
        }
    }
}