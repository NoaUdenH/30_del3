package dasuki.GUI;

import dasuki.Felt.*;
import gui_fields.*;
import gui_main.GUI;
import dasuki.Spiller.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class View {

    private GUI gui;
    private GUI_Field[] felter;
    private ArrayList<GUI_Player> players = new ArrayList<>();
    private Color GameBoardColor = new Color(0, 190, 0);
    private Color MessageColor = Color.BLACK;

    public View(Felt[] felter) {
        this.felter = createFelter(felter);
        gui = new GUI(this.felter, GameBoardColor);
    }

    public void sendMessage(String message) {
        gui.showMessage(message);
    }

    public String getPlayerOptions(String message, String ... options) {
        return gui.getUserSelection(message, options);
    }

    public String getUserInput(String message) {
        return gui.getUserString(message);
    }

    public void moveCar(Spiller player, int i_felt ) {
        GUI_Player playerToMove = getPlayer(player);
        Arrays.stream(felter).forEachOrdered(field -> field.setCar(playerToMove, false));
        felter[i_felt].setCar (playerToMove, true);
    }

    public void addPlayers(ArrayList<Spiller> players) {
        players.forEach(this::createPlayer);
    }
    public void createPlayer(Spiller player) {
        GUI_Player newPlayer = setPlayerCars(player);
        addPlayer(newPlayer);
        felter[player.getPosition()].setCar(newPlayer, true);
    }

    private GUI_Player getPlayer(Spiller player) {
        GUI_Player getPlayer = players.stream().filter(players -> players.getName().equals(player.getNavn())).findFirst().orElse(null);
        return getPlayer;
    }

    private void setTerning() {
        //TODO- implementere Terningen...
        gui.setDice(1, 2);
    }

    private GUI_Player setPlayerCars(Spiller player) {
        GUI_Player createPlayer;
        if ("Bil1".equals(player.getCars())) {
            createPlayer = new GUI_Player(player.getNavn(), player.getKonto().getKonto(), new GUI_Car(Color.RED, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED));
        } else if ("Bil2".equals(player.getCars())) {
            createPlayer = new GUI_Player(player.getNavn(), player.getKonto().getKonto(), new GUI_Car(Color.PINK, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED));
        } else if ("Bil3".equals(player.getCars())) {
            createPlayer = new GUI_Player(player.getNavn(), player.getKonto().getKonto(), new GUI_Car(Color.BLACK, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED));
        } else if ("Bil4".equals(player.getCars())) {
            createPlayer = new GUI_Player(player.getNavn(), player.getKonto().getKonto(), new GUI_Car(Color.BLUE, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.DOTTED));
        } else {
            createPlayer = new GUI_Player(player.getNavn(), player.getKonto().getKonto(), new GUI_Car(Color.YELLOW, Color.BLACK, GUI_Car.Type.CAR, GUI_Car.Pattern.ZEBRA));
        }
        new JPanel(new GridLayout(2, 4, 1, 1));
        setTerning();
        return createPlayer;
    }

    private void addPlayer(GUI_Player player) {
        players.add(player);
        gui.addPlayer(player);
    }

    private GUI_Field[] createFelter(Felt[] felter) {
        GUI_Field[] createFelt = new GUI_Field[felter.length];
        int i = 0;
        while (i < felter.length) {
            if (!(felter[i] instanceof Gade)) {
                if (!(felter[i] instanceof Rederi)) {
                } else {
                    GUI_Refuge refuge = new GUI_Refuge();
                    refuge.setTitle(felter[i].getFeltNavn());
                    refuge.setDescription(felter[i].getDescription());
                    createFelt[i] = refuge;
                }
            } else {
                GUI_Street street = new GUI_Street(felter[i].getFeltNavn(), "Pris: " + felter[i].getPris(), felter[i].getDescription(), Integer.toString(felter[i].getPris()), felter[i].getFarvePunkt(), MessageColor);
                createFelt[i] = street;
            }
            i++;
        }
        return createFelt;
    }
}