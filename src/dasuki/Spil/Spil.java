package dasuki.Spil;

import java.util.ArrayList;
import java.util.Collections;
import dasuki.Felt.Felt;
import dasuki.Felt.Felter;
import dasuki.Spiller.Spiller;
import dasuki.Spiller.Spillerliste;
import dasuki.Terning.Terning;
import gui_fields.GUI_Chance;
import gui_fields.GUI_Field;
import gui_fields.GUI_Refuge;
import gui_fields.GUI_Street;

public class Spil {
    private Spillerliste spillere;
    private Spilleplade spilleplade;
    //private ChancekortBunke chancekortBunke;
    private Felt[] feltInfo;

    public Spil(Spillerliste spillere, Spilleplade spilleplade) {
        this.spillere = spillere;
        this.spilleplade = spilleplade;
        //this.chancekortBunke = chancekortBunke;
        feltInfo = Felter.getFelter();
    }

    public void udførSpillerTur(Terning terning, Spiller aktivSpiller)
    {
        int slag = terning.getVærdi();
        String besked = aktivSpiller.getNavn();

        int gammelPosition = aktivSpiller.getPosition();
        int nyPosition = (gammelPosition + slag);

        if (nyPosition >= spilleplade.getFelter().length)
        {
            spilleplade.sendBesked(besked + " har passeret start og modtaget M2");
            aktivSpiller.getKonto().givPenge(2);
            nyPosition -= spilleplade.getFelter().length;
        }

        // Fjerner spiller fra forrige felt
        spilleplade.getFelt(gammelPosition).setCar(aktivSpiller.getGUI_PLayer(), false);

        aktivSpiller.opdaterPosition(nyPosition);

        GUI_Field ramtFelt = spilleplade.getFelt(nyPosition);
        String ramtFeltNavn = ramtFelt.getTitle();


        if (ramtFeltNavn == "Start")
        {

        }
        else if (ramtFelt instanceof GUI_Chance) {
            int random = (int) (Math.random()*2)+1;
            if(random == 1 ) {
                aktivSpiller.getKonto().givPenge(1);
                besked += " er landet på chancen! de modtager M1";
            } else if(random == 2) {
                aktivSpiller.getKonto().tagPenge(1);
                besked += " er landet på chancen! der trækkes M1 fra kontoen";
            }
        }
        else if (ramtFelt instanceof GUI_Refuge)
            // Parkeringspladsen er gratis.
            besked += " parkerer gratis.";
        else if (ramtFelt == spilleplade.getFelt(6))
            // På besøg.
            besked += " er på besøg i fængslet.";
        else if (ramtFelt == spilleplade.getFelt(18))
        {
            nyPosition = 6;
            ramtFelt = spilleplade.getFelt(nyPosition);
            aktivSpiller.opdaterPosition(nyPosition);
            besked += " ryger direkte i fængsel.";
        }
        else if (ramtFelt instanceof GUI_Street){
            String ejerNavn = ((GUI_Street) ramtFelt).getOwnerName();
            int pris = feltInfo[nyPosition].getPris();
            Spiller ejer = feltInfo[nyPosition].getEjer();

            if (ejerNavn != null)
            {
                if (aktivSpiller.getNavn() != ejerNavn)
                {
                    aktivSpiller.getKonto().tagPenge(pris);
                    ejer.getKonto().givPenge(pris);
                    ejer.opdaterSpiller();
                    besked += " er landet på " + ramtFelt.getTitle() +
                            " som tilhører " + ejerNavn +
                            ", og har betalt dem M" + pris;
                }
                else
                {
                    besked += " er landet på " + ramtFelt.getTitle() +
                            " som de selv ejer.";
                }

            }
            else
            {
                aktivSpiller.getKonto().tagPenge(feltInfo[nyPosition].getPris());
                spilleplade.købFelt(nyPosition, aktivSpiller.getNavn());
                feltInfo[nyPosition].setEjer(aktivSpiller);
                besked += " har købt " + feltInfo[nyPosition].getFeltNavn() +
                        " for M" + feltInfo[nyPosition].getPris();
            }
        }
        ramtFelt.setCar(aktivSpiller.getGUI_PLayer(), true);
        aktivSpiller.opdaterSpiller();
        if (!besked.equals(aktivSpiller.getNavn()))
            spilleplade.sendBesked(besked);

        if(aktivSpiller.getKonto().getKonto() == 0) {
            spilleplade.sendBesked(aktivSpiller.getNavn() + " har tabt spillet..");
            aktivSpiller.setIsLost(true);

            ArrayList<Integer> placeringer = new ArrayList<Integer>();
            for(int i = 0; i < spillere.antalAfSpiller(); i++) {
                placeringer.add(spillere.getSpiller(i).getKonto().getKonto());
            }

            Collections.sort(placeringer);
            spilleplade.sendBesked("Vinderen er spilleren med beløbet på " + placeringer.get(placeringer.size()-1));
        }

    }
}

