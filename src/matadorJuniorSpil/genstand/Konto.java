package matadorJuniorSpil.genstand;

public class Konto {

    private int penge;

    public Konto(int penge) {
        this.penge = penge;
    }

    public int getBalance() { return penge; }

    //bruges til at sættes konto i 0.
    public void setFallit(int penge) {
        this.penge = penge;
    }

    public void givPenge(int penge){
        this.penge = this.penge + penge;
    }

    public void tagPenge(int penge){
        int temp = getBalance() - penge;
        if (temp < 0){
            setFallit(0);
        } else {
            this.penge = this.penge - penge;
        }
    }

    public String toString(){
        return "["+penge+"]";
    }
}

