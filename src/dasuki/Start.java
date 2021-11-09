package dasuki;

// Startfeltet

public class Start extends Felt
{
    double gevinst;

    public Start(double gevinst)
    {
        navn="Start";
        this.gevinst=gevinst;
    }

    public void passeret(Spiller sp)                 // tilsidesæt metode i Felt
    {
        System.out.println(sp.navn+" passerer start og modtager "+gevinst);
        sp.transaktion(gevinst);                       // kredit/debit af konto
        System.out.println(sp.navn+"s konto lyder nu på "+sp.konto);
    }

    public void landet(Spiller sp)                   // tilsidesæt metode i Felt
    {
        System.out.println(sp.navn+" lander på start og modtager "+gevinst);
        sp.transaktion(gevinst);
        System.out.println(sp.navn+"s konto lyder nu på "+sp.konto);
    }
}