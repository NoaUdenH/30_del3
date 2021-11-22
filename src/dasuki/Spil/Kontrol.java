package dasuki.Spil;

import dasuki.Spiller.Bil;

import dasuki.Spiller.Konto;
import dasuki.Spiller.Spiller;
import dasuki.Spiller.Spillerliste;
import dasuki.Terning.Terning;
import gui_fields.GUI_Player;

import java.awt.Color;

public class Kontrol {

    private Spillerliste spillerliste;
    private Spilleplade spilleplade;
    private Terning terning;
    private Spil spil;

    public Kontrol() {
        spilleplade = new Spilleplade();
        terning = new Terning();
        terning.kast();
    }

    public void spilkontrol() {
        spilleplade.sendBesked("Monopoly Junior");
        opretSpillere();
        spil = new Spil(spillerliste, spilleplade);

        int nutidigSpillerInt = -1;
        do {
            nutidigSpillerInt = (nutidigSpillerInt + 1) % spillerliste.antalAfSpiller();
            spilleplade.setTerning(terning.kast());
            spil.udførSpillerTur(terning, spillerliste.getSpiller(nutidigSpillerInt));

        } while (!spillerliste.getSpiller(nutidigSpillerInt).isLost());

    }

    public void opretSpillere() {
        int antalSpillere = spilleplade.getAntalSpiller();
        spillerliste = new Spillerliste(antalSpillere);

        // opretter spillerliste med input fra gui'en
        for (int i = 0; i < antalSpillere; i++) {
            int startBeløb;
            if (antalSpillere == 2)
                startBeløb = 20;
            else if (antalSpillere == 3)
                startBeløb = 18;
            else
                startBeløb = 16;

            String navn = spilleplade.getNavn();
            // int alder = spillebræt.hentAlder();
            int farve = spilleplade.getBilFarve();

            Color farve1;
            Color farve2;
            if (farve == 1) {
                farve1 = Color.BLACK;
                farve2 = Color.white;

            } else if (farve == 2) {
                farve1 = Color.RED;
                farve2 = Color.white;

            } else if (farve == 3) {
                farve1 = Color.YELLOW;
                farve2 = Color.white;

            } else {
                farve1 = Color.BLUE;
                farve2 = Color.white;
            }

                Spiller spiller = new Spiller(navn, new Bil(farve1, farve2), new Konto(startBeløb));
                spillerliste.addSpiller(spiller, i);
                GUI_Player player = spilleplade.addSpillerTilPladen(spiller);
                spiller.setGUI_Player(player);
                spiller.opdaterSpiller();
            }
        }
    }


