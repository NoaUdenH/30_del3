package dasuki.Spiller;

import java.util.ArrayList;

public class Spiller {
    
    private Konto konto;
    private String navn, cars;
    private boolean isLost;
    private int position, husValue = 0;
    private int solgtSkilte = 12;


    private ArrayList<Integer> husPris;
    public String getNavn() { return navn; }
    public String getCars() { return cars;}
    public void UpdatePosition(int value) {
        position = (position + value) % 24;
    }
    public Konto getKonto() {
        return konto;
    }
    public boolean isLost() {return isLost;}
    public int getPosition() {return position;}

    //Metode for at se nuværende antal solgt skilte.
    public int visAntalSolgtSkilte() {
        return this.solgtSkilte;
    }

    //Metode for spilleregel for maks antal eget ejendomme.
    public void opdaterSolgtSkilte(){
        this.solgtSkilte= this.solgtSkilte - 1;
        return this.solgtSkilte;
    }

    public Spiller(String navn, String cars, int startingPengebeholdning, int startingPosition) {
        this.navn = navn;
        this.cars = cars;
        position = startingPosition;
        husPris = new ArrayList<>();
        konto = new Konto(startingPengebeholdning);
    }
}