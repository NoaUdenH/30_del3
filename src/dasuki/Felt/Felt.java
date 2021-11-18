package dasuki.Felt;

import java.awt.*;

public abstract class Felt {

    protected int pris, feltNummer;
    protected String feltNavn, beskrivelse, tekst;
    protected Color farvePunkt;

    public Color getFarvePunkt() { return farvePunkt; }
    public String getFeltNavn() { return feltNavn; }
    public String getTekst() {        return tekst;    }
    public String getDescription() { return beskrivelse; }
    public String toString() {
        return "";
    }
    public int getFeltNummer() { return feltNummer; }
    public int getPris() { return pris; }

    protected Felt(int feltNummer, String feltNavn, String beskrivelse, int pris, Color farvePunkt) {
        this.feltNummer = feltNummer;
        this.feltNavn = feltNavn;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
        this.farvePunkt = farvePunkt;
    }
}