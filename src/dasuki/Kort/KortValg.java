package dasuki.Kort;

public abstract class KortValg {

    protected String feltNavn, beskrivelse, kortType;
    protected KortValg(String kortType, String feltNavn, String beskrivelse) {
        this.kortType = kortType;
        this.feltNavn = feltNavn;
        this.beskrivelse = beskrivelse;
    }
}