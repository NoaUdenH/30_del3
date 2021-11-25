package matadorJuniorSpil.genstand;

import gui_fields.GUI_Car;

import java.awt.*;

public class Bil {
    private GUI_Car bil;
    private Color farve;

    // Constructor for Bil har 2 variabler, farve1 og farve2
    public Bil(Color farve1, Color farve2){
        this.farve = farve1;
        bil = new GUI_Car(farve1, farve2, GUI_Car.Type.CAR, GUI_Car.Pattern.CHECKERED);
    }

    public GUI_Car getBil(){
        return bil;
    }
    /*
    public void setCar(GUI_Car bil){
        this.bil = bil;
    }

     */

    public String toString(){
        return farve + "Bil";
    }

}
