package dasuki;

import dasuki.Spil.Controller;

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
        Controller c = new Controller();
        c.spilkontrol();
    }

}