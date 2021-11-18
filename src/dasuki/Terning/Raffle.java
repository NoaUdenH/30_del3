package dasuki.Terning;

import java.util.stream.IntStream;

public class Raffle {

    private Terning[] terning;

    public Raffle(int amountOfDies, int terningEdges) {
        terning = new Terning[amountOfDies];
        IntStream.range(0, terning.length).forEach(i -> terning[i] = new Terning());
    }

    private int raffleValue;
    public int raffleRolling() {
        int raffleValue = 0;
        for (Terning terning : terning) {
            terning.isRolling();
            raffleValue += terning.getFaceValue();
        }
        this.raffleValue = raffleValue;
        return raffleValue;
    }

    public int getRaffleValue() {return raffleValue;}
}