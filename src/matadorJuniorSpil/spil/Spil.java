package matadorJuniorSpil.spil;

import java.util.ArrayList;
import java.util.Collections;
import matadorJuniorSpil.genstand.Felt;
import matadorJuniorSpil.genstand.Felter;
import matadorJuniorSpil.genstand.Spiller;
import matadorJuniorSpil.genstand.Spillerliste;
import matadorJuniorSpil.genstand.Terning;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Street;

public class Spil {
    private Spillerliste spillere;
    private Spilleplade plade;
    //private ChancekortBunke chancekortBunke;
    private Felt[] feltInfo;

    public Spil(Spillerliste spillere, Spilleplade plade) {
        this.spillere = spillere;
        this.plade = plade;
        //this.chancekortBunke = chancekortBunke;
        feltInfo = Felter.getFelter();
    }

    //Giver spiller en ny placering efter terningslag.
    public void spillerHandling(Terning terning, Spiller spiller)
    {
        int kast = terning.getØjne();
        String besked = spiller.getNavn();

        int forrigePosition = spiller.getPosition();
        int nyePosition = (forrigePosition + kast);

        if (nyePosition >= plade.getFelter().length)
        {
            plade.sendBesked(besked + " har passeret start og modtaget M2");
            spiller.getKonto().givPenge(2);
            nyePosition -= plade.getFelter().length;
        }

        //'Fjerner' spiller fra forrige position.
        plade.getFelt(forrigePosition).setCar(spiller.getGUI_PLayer(), false);
        //Opdater spiller nye position.
        spiller.opdaterPosition(nyePosition);

        GUI_Field landetFelt = plade.getFelt(nyePosition);
        String landetFeltNavn = landetFelt.getTitle();


        if (landetFeltNavn == "Start")
        {

        }
        else if (landetFelt instanceof GUI_Chance) {
            int random = (int) (Math.random()*2)+1;
            if(random == 1 ) {
                spiller.getKonto().givPenge(1);
                besked += " er landet på chancen! de modtager M1";
            } else if(random == 2) {
                spiller.getKonto().tagPenge(1);
                besked += " er landet på chancen! der trækkes M1 fra kontoen";
            }
        }
        else if (landetFelt instanceof GUI_Refuge)
            // Parkeringspladsen er gratis.
            besked += " parkerer gratis.";
        else if (landetFelt == plade.getFelt(6))
            // På besøg.
            besked += " er på besøg i fængslet.";
        else if (landetFelt == plade.getFelt(18))
        {
            nyePosition = 6;
            landetFelt = plade.getFelt(nyePosition);
            spiller.opdaterPosition(nyePosition);
            besked += " ryger direkte i fængsel.";
        }
        else if (landetFelt instanceof GUI_Street){
            String ejerNavn = ((GUI_Street) landetFelt).getOwnerName();
            int pris = feltInfo[nyePosition].getPris();
            Spiller ejer = feltInfo[nyePosition].getEjer();

            if (ejerNavn != null)
            {
                if (spiller.getNavn() != ejerNavn)
                {
                    spiller.getKonto().tagPenge(pris);
                    ejer.getKonto().givPenge(pris);
                    ejer.opdaterSpiller();
                    besked += " er landet på " + landetFelt.getTitle() +
                            " som tilhører " + ejerNavn +
                            ", og har betalt dem M" + pris;
                }
                else
                {
                    besked += " er landet på " + landetFelt.getTitle() +
                            " som de selv ejer.";
                }

            }
            else
            {
                spiller.getKonto().tagPenge(feltInfo[nyePosition].getPris());
                plade.købFelt(nyePosition, spiller.getNavn());
                feltInfo[nyePosition].setEjer(spiller);
                besked += " har købt " + feltInfo[nyePosition].getFeltNavn() +
                        " for M" + feltInfo[nyePosition].getPris();
            }
        }
        landetFelt.setCar(spiller.getGUI_PLayer(), true);
        spiller.opdaterSpiller();
        if (!besked.equals(spiller.getNavn()))
            plade.sendBesked(besked);

        if(spiller.getKonto().getSaldo() == 0) {
            plade.sendBesked(spiller.getNavn() + " har tabt spillet..");
            spiller.setIsLost(true);

            ArrayList<Integer> placeringer = new ArrayList<Integer>();
            for(int i = 0; i < spillere.antalAfSpiller(); i++) {
                placeringer.add(spillere.getSpiller(i).getKonto().getSaldo());
            }

            Collections.sort(placeringer);
            plade.sendBesked("Vinderen er spilleren med beløbet på " + placeringer.get(placeringer.size()-1));
        }

    }
}

