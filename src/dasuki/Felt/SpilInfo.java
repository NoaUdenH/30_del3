package dasuki.Felt;

import java.awt.*;
import static dasuki.Felt.SpilMatador.*;

public class SpilInfo {

    public static void openGameBoard() {
        addHus(1, "Start", "Du vil modtage 2 når du passerer dette felt!", 0, Color.WHITE);
        addHus(2, "BURGERBAREN", "Du ser sulten ud, få købt dig en burger..!", 1, new Color(189, 122, 55));
        addHus(3, "PIZZARIAET", "Du ligner en der har brug for en ordentlig Shawarma..!", 1, new Color(189, 122, 55));
        addHus(4, "CHANCE", "Du får en chance..", 0, Color.GRAY);
        addHus(5, "SLIKBUTIKKEN", "Få dig noget sødt her i slikbutikken..", 1, new Color(127, 196, 217));
        addHus(6, "ISKIOSKEN", "Få dig noget der er cremet samtidig sødt..",1, new Color(127, 196, 217));
        addHus(7, "I FÆNGSEL PAA BESØG", "Ved du hvor du er henne..?",0, Color.GRAY);
        addHus(8, "MUSEET", "Se hvor smukt det er her i museet..",2, new Color(203, 104, 226));
        addHus(9, "BIBLIOTEKET", "Få noget viden..", 2, new Color(203, 104, 226));
        addHus(10, "CHANCE", "Du får endnu en chance..",0, Color.GRAY);
        addHus(11, "SKATEPARKEN", "Få dig hygget lidt med kammeraterne på skateparken..", 2, new Color(220, 129, 38));
        addHus(12, "SWIMMINGPOOLEN", "Keder du dig, så dyk ned i poolen..", 2, new Color(220, 129, 38));
        addHus(13, "GRATIS PARKERING", "Du kan parkere her uden bekymringer..",0, Color.GRAY);
        addHus(14, "SPILLEHALLEN", "Er det en god ide..?", 3, new Color(140, 5, 5));
        addHus(15, "BIOGRAFEN", "Det ville være rart, at få set en film..", 3, new Color(140, 5, 5));
        addHus(16, "CHANCE", "Du får squ endnu en chance..",0, Color.GRAY);
        addHus(17, "LEGETØJSBUTIKKEN", "Gør' dine yngre glad..", 3, new Color(255, 213, 0));
        addHus(18, "DYREHANDLEN", "Brug nogle penge!", 3, new Color(255, 213, 0));
        addHus(19, "GÅ I FÆNGSEL", "Oops, du er havnet i fængslet!",3, Color.GRAY);
        addHus(20, "BOWLINGHALLEN", "Få hygget lidt..", 4, new Color(10, 157, 22));
        addHus(21, "ZOO", "Ville være rat at komme ned med familien..", 4, new Color(10, 157, 22));
        addHus(22, "CHANCE", "Du får endnu en chance..",0, Color.GRAY);
        addHus(23, "VANDLANDET", "Du er havnet her i vandlandet!", 5, new Color(49, 90, 164));
        addHus(24, "STRANDPROMENADEN", "Strandpromenaden, hvad laver du her..?", 5, new Color(49, 90, 164));
    }
}