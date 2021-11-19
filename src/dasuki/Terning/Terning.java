package dasuki.Terning;

public class Terning {
    private int værdi;
    double antalSider = 6.0;

    public int kast() {
        return this.værdi = (int) (Math.random() * antalSider) + 1;
    }

    public int getVærdi() {
        return this.værdi;
    }
}
