package matadorJuniorSpil.genstand;


import java.awt.*;

public class Felt {

    private int pris;
    private String feltNavn, beskrivelse;
    private String prisUdskrift;
    private Color farve;
    private Spiller ejer;

    public Spiller getEjer() {
        return ejer;
    }
    public void setEjer(Spiller ejer) {
        this.ejer = ejer;
    }

    //public Color getFarvePunkt() { return farvePunkt; }

    public String getFeltNavn() {return feltNavn; }
    //Metode der giver felt et navn.
    public void setFeltNavn(String feltNavn){
        this.feltNavn = feltNavn;
    }

    //public String getTekst() {        return tekst;    }
    //public String getDescription() { return beskrivelse; }

    public String getBeskrivelse() { return beskrivelse; }
    //Metode der giver felt en beskrivelse.
    public void setBeskrivelse(String beskrivelse){
        this.beskrivelse = beskrivelse;
    }

    public String toString() {
        return "";
    }
    //public int getFeltNummer() { return feltNummer; }
    public int getPris() { return pris; }
    //Metode der giver felt en pris.
    public void setPris(int pris){
        this.pris = pris;
    }
    public String getPrisUdskrift(){return prisUdskrift;}
    //Metode der giver felt en under beskrivelse.
    public void setPrisUdskrift(String prisUdskrift){
        this.prisUdskrift = prisUdskrift;
    }
    public Color getFarve() {
        return farve;
    }
    public void setFarve(Color farve) {
        this.farve = farve;
    }

}