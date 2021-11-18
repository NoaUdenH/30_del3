package dasuki.Spil;

import dasuki.Felt.Felt;
import dasuki.Spiller.Spiller;
import dasuki.GUI.View;
import java.util.ArrayList;

public class Program {

    private View GUI;
    public Program(Felt[] felter) {
        GUI = new View(felter);
    }
    public void sendMessageInfo(String message) {
        GUI.sendMessage(message);
    }

    public String getPlayerOptions(String message, ArrayList<String> options) {
        String[] optionList = options.toArray( new String [options.size()]);
        return GUI.getPlayerOptions(message, optionList);
    }

    public String getPlayerInput(String message) {
        return GUI.getUserInput(message);
    }

    public void moveCar(Spiller player, int newFieldIndex) {
        GUI.moveCar(player, newFieldIndex);
    }

    public void addPlayers(ArrayList<Spiller> players) {GUI.addPlayers(players);  }

}