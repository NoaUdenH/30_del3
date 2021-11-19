package dasuki.Spiller;

import gui_fields.GUI_Player;

import java.util.ArrayList;

public class Spiller {

    private Konto konto;
    private String navn;
    private Bil bil;
    private boolean isLost = false;
    private int position;
    //Maks 12 solgt skilte pr. spiller.
    //private int solgtSkilte = 12;
    private GUI_Player spiller;

    //private ArrayList<Integer> husPris;
    public String getNavn() { return navn; }
    public void setNavn(String navn) {
        this.navn = navn; }
    public Bil getCars() { return bil;}
    public void UpdatePosition(int value) {
        position = (position + value) % 24;
    }
    public Konto getKonto() {
        return konto;
    }
    public boolean isLost() {return isLost;}
    public void setIsLost(boolean isLost){
        this.isLost = isLost;
    }

    public int getPosition() {return position;}
    //Opdater spiller position.
    public void opdaterPosition(int position){
        this.position = position;
    }

    //Bruges til at fjerne spiller fra felt.
    public GUI_Player getGUI_PLayer() {
        return spiller;
    }
    public void setGUI_Player(GUI_Player spiller) {
        this.spiller = spiller;
    }


    public void opdaterSpiller() {
        spiller.setBalance(konto.getKonto());
    }

    public Spiller(String navn, Bil bil, Konto konto) {
        this.navn = navn;
        this.bil = bil;
        this.konto = konto;
        //position = startingPosition;
        //husPris = new ArrayList<>();
        //konto = new Konto(startingPengebeholdning);
    }

    @Override
    public String toString() {
        return "\t\nSpiller: navn=" + navn + ", konto=" + konto + ", bil=" + bil;
    }

    //Metode for at se nuværende antal solgt skilte.
    /*
    public int visAntalSolgtSkilte() {
        return this.solgtSkilte;
    }
    */

    //Metode for spilleregel for maks antal eget ejendomme.
    /*
    public int opdaterSolgtSkilte(){
        this.solgtSkilte= this.solgtSkilte - 1;
        return this.solgtSkilte;
    }

     */

}