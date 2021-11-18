package dasuki;

import dasuki.Spil.Spil;

public class Main {

    public static void main(String[] args) {
        Spil thisGame = new Spil();
        try {
            thisGame.Start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}