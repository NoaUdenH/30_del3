package dasuki.Terning;

import java.util.Random;

public class Terning {

    private int faceValue, sides;
    private final int terningEdges = 6;

    public Terning() {
        sides = terningEdges;
    }

    public void isRolling() {
        Random random = new Random();
        faceValue = random.nextInt(sides)+1;
    }

    public int getFaceValue() { return faceValue; }
}