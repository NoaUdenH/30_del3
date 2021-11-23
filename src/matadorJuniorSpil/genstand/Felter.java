package matadorJuniorSpil.genstand;

import java.awt.*;

public class Felter {

    public static Felt[] getFelter() {

        Felt[] felter = new Felt[24];
        felter[0] = new Felt();
        felter[0].setFeltNavn("Start");
        felter[0].setPris(-1);
        felter[0].setBeskrivelse("Spillerstart");
        felter[0].setUnderBeskrivelse("");

        felter[1] = new Felt();
        felter[1].setFeltNavn("Burgerbaren");
        felter[1].setPris(1);
        felter[1].setFarve(Color.DARK_GRAY);
        felter[1].setUnderBeskrivelse("M1");
        felter[1].setBeskrivelse("");

        felter[2] = new Felt();
        felter[2].setFeltNavn("Pizzariaet");
        felter[2].setPris(1);
        felter[2].setFarve(Color.DARK_GRAY);
        felter[2].setUnderBeskrivelse("M1");
        felter[2].setBeskrivelse("");

        felter[3] = new Felt();
        felter[3].setFeltNavn("Chance");
        felter[3].setPris(-1);
        felter[3].setBeskrivelse("Tag chancen");
        felter[3].setUnderBeskrivelse("");

        felter[4] = new Felt();
        felter[4].setFeltNavn("Slikbutikken");
        felter[4].setPris(1);
        felter[4].setFarve(Color.CYAN);
        felter[4].setUnderBeskrivelse("M1");
        felter[4].setBeskrivelse("");

        felter[5] = new Felt();
        felter[5].setFeltNavn("Iskiosken");
        felter[5].setPris(1);
        felter[5].setFarve(Color.CYAN);
        felter[5].setUnderBeskrivelse("M1");
        felter[5].setBeskrivelse("");

        felter[6] = new Felt();
        felter[6].setFeltNavn("I fængsel");
        felter[6].setPris(-1);
        felter[6].setBeskrivelse("");
        felter[6].setUnderBeskrivelse("");

        felter[7] = new Felt();
        felter[7].setFeltNavn("Museet");
        felter[7].setPris(2);
        felter[7].setFarve(Color.PINK);
        felter[7].setUnderBeskrivelse("M2");
        felter[7].setBeskrivelse("");

        felter[8] = new Felt();
        felter[8].setFeltNavn("Biblioteket");
        felter[8].setPris(2);
        felter[8].setFarve(Color.PINK);
        felter[8].setUnderBeskrivelse("M2");
        felter[8].setBeskrivelse("");

        felter[9] = new Felt();
        felter[9].setFeltNavn("Chance");
        felter[9].setPris(-1);
        felter[9].setBeskrivelse("");
        felter[9].setUnderBeskrivelse("");

        felter[10] = new Felt();
        felter[10].setFeltNavn("Skaterparken");
        felter[10].setPris(2);
        felter[10].setFarve(Color.ORANGE);
        felter[10].setUnderBeskrivelse("M2");
        felter[10].setBeskrivelse("");

        felter[11] = new Felt();
        felter[11].setFeltNavn("Swimmingpoolen");
        felter[11].setPris(2);
        felter[11].setFarve(Color.ORANGE);
        felter[11].setUnderBeskrivelse("M2");
        felter[11].setBeskrivelse("");

        felter[12] = new Felt();
        felter[12].setFeltNavn("Parkeringspladsen");
        felter[12].setBeskrivelse("");
        felter[12].setPris(-1);
        felter[12].setUnderBeskrivelse("");

        felter[13] = new Felt();
        felter[13].setFeltNavn("Spillehallen");
        felter[13].setPris(3);
        felter[13].setFarve(Color.RED);
        felter[13].setUnderBeskrivelse("M3");
        felter[13].setBeskrivelse("");

        felter[14] = new Felt();
        felter[14].setFeltNavn("Biografen");
        felter[14].setPris(3);
        felter[14].setFarve(Color.RED);
        felter[14].setUnderBeskrivelse("M3");
        felter[14].setBeskrivelse("");

        felter[15] = new Felt();
        felter[15].setFeltNavn("Chance");
        felter[15].setPris(-1);
        felter[15].setBeskrivelse("Tag chancen");
        felter[15].setUnderBeskrivelse("");

        felter[16] = new Felt();
        felter[16].setFeltNavn("Legetøjsbutikken");
        felter[16].setPris(3);
        felter[16].setFarve(Color.YELLOW);
        felter[16].setUnderBeskrivelse("M3");
        felter[16].setBeskrivelse("");

        felter[17] = new Felt();
        felter[17].setFeltNavn("Dyrehandleren");
        felter[17].setPris(3);
        felter[17].setFarve(Color.YELLOW);
        felter[17].setUnderBeskrivelse("M3");
        felter[17].setBeskrivelse("");

        felter[18] = new Felt();
        felter[18].setFeltNavn("Gå i fængsel");
        felter[18].setPris(-1);
        felter[18].setBeskrivelse("");
        felter[18].setUnderBeskrivelse("");

        felter[19] = new Felt();
        felter[19].setFeltNavn("Bowlinghallen");
        felter[19].setPris(4);
        felter[19].setFarve(Color.GREEN);
        felter[19].setUnderBeskrivelse("M4");
        felter[19].setBeskrivelse("");

        felter[20] = new Felt();
        felter[20].setFeltNavn("Zoo");
        felter[20].setPris(4);
        felter[20].setFarve(Color.GREEN);
        felter[20].setUnderBeskrivelse("M4");
        felter[20].setBeskrivelse("");

        felter[21] = new Felt();
        felter[21].setFeltNavn("Chance");
        felter[21].setPris(-1);
        felter[21].setBeskrivelse("Tag chancen");
        felter[21].setUnderBeskrivelse("");

        felter[22] = new Felt();
        felter[22].setFeltNavn("Vandlandet");
        felter[22].setPris(5);
        felter[22].setFarve(Color.BLUE);
        felter[22].setUnderBeskrivelse("M5");
        felter[22].setBeskrivelse("");

        felter[23] = new Felt();
        felter[23].setFeltNavn("Strandpromenaden");
        felter[23].setPris(5);
        felter[23].setFarve(Color.BLUE);
        felter[23].setUnderBeskrivelse("M5");
        felter[23].setBeskrivelse("");

        return felter;
    }
}
