package dasuki.Spiller;

public class Konto {

    private int penge;

    public Konto(int penge) {
        this.penge = penge;
    }

    public int getKonto() { return penge; }

    //bruges til at sættes konto i 0.
    public void setPenge(int penge) {
        this.penge = penge;
    }

    public void givPenge(int penge){
        this.penge = this.penge + penge;
    }

    public void tagPenge(int penge){
        int temp = getKonto() - penge;
        if (temp < 0){
            setPenge(0);
        } else {
            this.penge = this.penge - penge;
        }
    }

    public String toString(){
        return "["+penge+"]";
    }
}

