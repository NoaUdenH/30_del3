package dasuki;

// En gade der kan bebygges

public class Gade extends Felt
{
    Spiller ejer;
    double pris;
    double grundleje;
    int antalHuse;
    double huspris;

    public Gade(String navn, double pris, double leje, double huspris)
    {
        this.navn=navn;
        this.pris=pris;
        this.grundleje=leje;
        this.huspris=huspris;
        antalHuse = 0;
    }

    public void landet(Spiller sp)
    {
        System.out.println(sp.navn+" er landet på "+navn);

        if (sp==ejer)
        {                                        // eget felt
            System.out.println("Dette er "+sp.navn+"s egen grund");
            if (antalHuse<5 && sp.konto>huspris)
            {                                     // byg et hus
                System.out.println(ejer.navn+" bygger et hus på "+navn+" for "+huspris);
                ejer.transaktion( -huspris );
                antalHuse = antalHuse + 1;
            }
        }
        else if (ejer==null)
        {                                        // ingen ejer grunden, så køb den
            if (sp.konto > pris)
            {
                System.out.println(sp.navn+" køber "+navn+" for "+pris);
                ejer=sp;
                sp.transaktion( -pris );
            }
            else System.out.println(sp.navn+" har ikke penge nok til at købe "+navn);
        }
        else
        {                                        // felt ejes af anden spiller
            double leje = grundleje + antalHuse * huspris;
            System.out.println("Husleje: "+leje);
            sp.betal(ejer, leje);                 // spiller betaler til ejeren
        }
    }
}