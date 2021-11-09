package dasuki;

// Rederier

public class Rederi extends Felt
{
    Spiller ejer;
    double pris;
    double grundleje;

    public Rederi(String navn, double pris, double leje)
    {
        this.navn = navn;
        this.pris = pris;
        this.grundleje = leje;
    }

    public void landet(Spiller sp)
    {
        System.out.println(sp.navn+" er landet på "+navn);
        if (sp==ejer)
        {                                       // spiller ejer selv grunden
            System.out.println("Dette er "+sp.navn+"s egen grund");
        }
        else if (ejer==null)
        {                                       // ingen ejer grunden, så køb den
            if (sp.konto > pris)
            {
                System.out.println(sp.navn+" køber "+navn+" for "+pris);
                ejer=sp;
                sp.transaktion( -pris );
            }
            else System.out.println(sp.navn+" har ikke penge nok til at købe "+navn);
        }
        else
        {                                       // feltet ejes af anden spiller
            System.out.println("Husleje: "+grundleje);
            sp.betal(ejer, grundleje);            // spiller betaler til ejeren
        }
    }
}