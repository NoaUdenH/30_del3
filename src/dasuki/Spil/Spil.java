package dasuki.Spil;

import dasuki.Felt.SpilMatador;
import dasuki.Kort.Kort;
import dasuki.Spiller.Spiller;
import dasuki.Terning.Raffle;

import java.util.ArrayList;
import java.util.Objects;

public class Spil {

    private boolean isOutOfGame = false;
    private static int startingPoint = 20;
    private final static int startingField = 0;
    int maxPlayers = 2; //TODO- få den ændret så man kan bestemme spillere imellem 2-4..

    public void GameStartingPoint(int maxPlayers) {
        if (maxPlayers == 2) {
            startingPoint = 20;
        } else if (maxPlayers == 3) {
            startingPoint = 20;
        } else if (maxPlayers == 4) {
            startingPoint = 20;
        }
    }

    public void Start() throws InterruptedException {
        int x, i = 0;
        SpilMatador Matador = new SpilMatador();
        Program programHandler = new Program(Matador.getFeltArea());
        GameStartingPoint(maxPlayers);
        ArrayList<String> addCars = new ArrayList<>();

        addCars.add("Bil1");
        addCars.add("Bil2");
        addCars.add("Bil3");
        addCars.add("Bil4");

        ArrayList<Spiller> players = new ArrayList<>();
        {
        while (i < maxPlayers) {
            String playerName = programHandler.getPlayerInput("Brugernavn af Spiller" + Integer.toString(i + 1)+":");
            String carsSelected = programHandler.getPlayerOptions("Tryk på OK!", addCars);
            int j = 0;
            while (j < addCars.size()) {
                if (!Objects.equals(addCars.get(j), carsSelected)) {
                } else {
                    addCars.remove(j);
                }
                j++;
            }
            Spiller player;
            player = new Spiller(playerName, carsSelected, startingPoint, startingField);
            players.add(player);
            i++;
         }
        }
        programHandler.sendMessageInfo("Spillet starter nu!");
        programHandler.addPlayers(players);
        Raffle raffle = new Raffle(1,6);
        Kort kort = new Kort(1);
        kort.shuffle(10);
        Operation op = new Operation();
            if (!isOutOfGame) do {
                x = i % maxPlayers;
                Spiller playersTurn = players.get(x);
                op.Operation(playersTurn, raffle, programHandler, kort);
                if (playersTurn.isLost()) {
                    isOutOfGame = true;
                }
                i++;
            } while (!isOutOfGame);
    }
}