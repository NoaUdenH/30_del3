package dasuki;
// Helle. Hvis man lander her får man en gevinst.

public class Helle extends Felt
{
    double gevinst;

    public Helle (int gevinst)
    {
        navn="Helle";                   // navn er arvet fra Felt
        this.gevinst=gevinst;
    }

    public void landet(Spiller sp)    // tilsidesæt metode i Felt
    {
        System.out.println(sp.navn+" lander på helle, og får overført "+gevinst);
        sp.transaktion(gevinst);        // opdater spillers konto
        System.out.println(sp.navn+"s konto lyder nu på "+sp.konto);
    }
}