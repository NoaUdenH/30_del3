package dasuki;
// Superklassen for alle matadorspillets felter

public class Felt
{
    String navn;

    public void passeret(Spiller sp) // kaldes når en spiller passerer dette felt
    {
        System.out.println(sp.navn+" passerer "+navn);
    }

    public void landet(Spiller sp)   // kaldes når en spiller lander på dette felt
    {
    }
}