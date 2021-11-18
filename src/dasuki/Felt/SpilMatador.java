package dasuki.Felt;

import java.awt.*;

public class SpilMatador {

    private static Felt[] feltArea;

    public Felt[] getFeltArea() {
        return feltArea;
    }

    public SpilMatador() {
        feltArea = new Felt[24];
        SpilInfo.openGameBoard();
    }

    public String toString() {
        StringBuilder info = new StringBuilder();
        int i = 0, feltAreaLength = feltArea.length;
        while (i < feltAreaLength) {
            Felt f = feltArea[i];
            StringBuilder append = info.append(f.toString());
            i++;
        }
        return info.toString();
    }

    public static void addHus(int feltNummer, String feltNavn, String beskrivelse, int leje, Color color) {
        int index = feltNummer - 1;
        feltArea[index] = new Gade(feltNummer,feltNavn,beskrivelse,leje,color);
    }

    public Felt getFeltOperation(int operationFelt) {
        Felt op;
        op = feltArea[operationFelt];
        return op;
    }
}