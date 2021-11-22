package dasuki.Terning;

public class Terning {
    private int øjne;
    int terningSider = 6;

    public int kast() {
        return this.øjne = (int) (Math.random() * terningSider) + 1;
    }

    public int getØjne() {
        return this.øjne;
    }
}
