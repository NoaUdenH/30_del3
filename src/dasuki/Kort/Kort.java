package dasuki.Kort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Kort {

    private ArrayList<KortValg> actionAvailable;
    public Kort(int amountSets) {
        actionAvailable = new ArrayList<>();
        GameCreation(amountSets);
    }

    private int sumOfCard;
    private void GameCreation(int amountSets) {
        sumOfCard = actionAvailable.size();
    }

    public void shuffle(int amountShuffles) {
        IntStream.range(0, amountShuffles).mapToObj(i -> actionAvailable).forEach(Collections::shuffle);
    }
}