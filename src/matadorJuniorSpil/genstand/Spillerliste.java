package matadorJuniorSpil.genstand;

import java.util.Arrays;

public class Spillerliste {
    private Spiller[] spiller;

    public Spillerliste(int antalAfSpiller) {
        this.spiller = new Spiller[antalAfSpiller];
    }

    public void addSpiller(Spiller spiller, int i){
        this.spiller[i] = spiller;
    }

    public Spiller getSpiller(int i) {
        return spiller[i];
    }

    public int antalAfSpiller() {
        return spiller.length;
    }

    //Metode der kan sortere penge ikke lavet!!!
    public void sorterEfterPenge() {
    }

    @Override
    public String toString() {
        return "Spillerliste: " + Arrays.toString(spiller);
    }

}
