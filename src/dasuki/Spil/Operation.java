package dasuki.Spil;

import dasuki.Felt.SpilMatador;
import dasuki.Felt.Felt;
import dasuki.Kort.Kort;
import dasuki.Terning.Raffle;
import dasuki.Spiller.Spiller;

public class Operation {

    private SpilMatador Matador = new SpilMatador();
    private int terningValue, gameFelt;
    private String fieldName, fieldAction;
    private Felt turnField;

    private int operationFelt;

    public void Operation(Spiller player, Raffle raffle, Program programHandler, Kort kort) throws InterruptedException {
        raffle(raffle, player, programHandler);
        raffleMoveCars(player,programHandler);
    }

    private void MovingController(Spiller player, Program programHandler, int upcomingFelt, int endFelt) throws InterruptedException {
        if (upcomingFelt <= endFelt) {
            int i = upcomingFelt + 1;
            while (i <= endFelt) {
                Thread.sleep(500);
                programHandler.moveCar(player, i);
                i++;
            }
        } else {
            {
                int i = upcomingFelt+1;
                while (i< Matador.getFeltArea().length) {
                    Thread.sleep(500);
                    programHandler.moveCar(player, i);
                    i++;
                }
            }
            int i = 0;
            while (i<=endFelt) {
                Thread.sleep(500);
                programHandler.moveCar(player, i);
                i++;
            }
        }
    }

    private void updateFeltInfo(int position) {
        turnField= Matador.getFeltOperation(position);
        gameFelt = turnField.getFeltNummer();
        fieldName=turnField.getFeltNavn();
        fieldAction = turnField.getTekst();
    }

    private void raffle(Raffle raffle, Spiller player, Program programHandler) {
        if (player.isLost()) {
            return;
        }
        programHandler.sendMessageInfo("Tryk på knappen for at kaste med terningerne!");
        raffle.raffleRolling();
        terningValue = raffle.getRaffleValue();
    }

    private void raffleMoveCars(Spiller player, Program programHandler) throws InterruptedException {
        if (!player.isLost()) {
            int upcomingFelt;
            upcomingFelt = player.getPosition();
            player.UpdatePosition(terningValue);
            operationFelt = player.getPosition();
            gameFelt = operationFelt + 1;
            programHandler.sendMessageInfo("Resultat: " + terningValue + ".");
            MovingController(player, programHandler, upcomingFelt, operationFelt);
            updateFeltInfo(operationFelt);
            StringBuilder  raffle_result_builder = new StringBuilder();
            raffle_result_builder.append("Du bevæger dig mod " + fieldName+".");
            String raffle_result;
            raffle_result = raffle_result_builder.toString();
            programHandler.sendMessageInfo(raffle_result);
        }
    }
}