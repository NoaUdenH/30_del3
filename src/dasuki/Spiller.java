package dasuki;

// Definition af en spiller

import java.util.Vector;

public class Spiller
{
    String navn;
    double konto;
    int feltnr;

    public Spiller(String navn, double konto)
    {
        this.navn=navn;
        this.konto=konto;
        feltnr = 0;
    }

    public void transaktion(double kr)
    {
        konto = konto + kr;
    }

    public void betal(Spiller modtager, double kr)
    {
        System.out.println(navn+" betaler "+modtager.navn+": "+kr+" kr.");
        modtager.transaktion(kr);
        transaktion(-kr);
    }

    public void tur(Vector felter)
    {
        int slag=(int)(Math.random()*6)+1;                // terningkast
        System.out.println("***** "+navn+" på felt "+feltnr+" slår "+slag+" *****");

        // nu rykkes der
        for (int i=1;i<=slag;i=i+1)
        {
            // gå til næste felt: tæl op, hvis vi når over antal felter så tæl fra 0
            feltnr = (feltnr + 1) % felter.size();
            Felt felt;
            felt = (Felt) felter.elementAt(feltnr);
            if (i<slag) felt.passeret(this);  // kald passer() på felter vi passerer
            else felt.landet(this);           // kald land() på sidste felt
        }
        try {Thread.sleep(3000);} catch (Exception e) {}  // vent 3 sek.
    }
}