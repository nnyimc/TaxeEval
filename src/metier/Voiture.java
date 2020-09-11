package metier;

import java.util.ArrayList;

public class Voiture implements IVoiture {
    private String marque;
    private int cylindree;
    private float taxe;

    public Voiture() {

    }

    public Voiture(String marque, int cylindree) {
        this.marque = marque;
        this.cylindree = cylindree;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public int getCylindree() {
        return cylindree;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    @Override
    public String afficherVoiture() {
        return "Vous avez une " + marque + " de cylindrée " + cylindree;
    }


    @Override
    public float calculerTaxeVoiture() {
        taxe = 0;
        if(cylindree <= 1600)
            return taxe = 300.0f;
        if(cylindree <= 2300)
            return taxe = 500.0f;
        return taxe = 700.0f;
    }
}
