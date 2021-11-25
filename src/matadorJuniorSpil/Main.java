package matadorJuniorSpil;

import matadorJuniorSpil.spil.Kontrol;

public class Main {

    public static void main(String[] args) {
        /*
        Spil thisGame = new Spil();
        try {
            thisGame.Start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

         */
        Kontrol startSpil = new Kontrol();
        startSpil.spilKontrol();
    }

}