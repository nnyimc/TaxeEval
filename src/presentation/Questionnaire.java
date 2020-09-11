package presentation;

import metier.Voiture;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Questionnaire implements IQuestionnaire{
    private String reponse;
    private String marque;
    private int cylindree;
    private ArrayList<Voiture> flotteVehicule = new ArrayList<>();

    public Questionnaire() {

    }


    @Override
    public ArrayList<Voiture> recupererProprietes() {
        System.out.println("Possédez vous une flotte de véhicules ? : Y = oui / N = non");
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        try {
            reponse = br.readLine();
            if(reponse.matches("Y")  || reponse.matches("y" )) {
                System.out.println("De combien de voiture(s) se constitue votre flotte ?");
                reponse = br.readLine();

                if( 1 <= Integer.parseInt(reponse) ) {
                    for (int i=0 ; i< Integer.parseInt(reponse); i++) {
                        System.out.println("Quelle est la marque du véhicule ?");
                        marque = br.readLine();

                        while (null == marque){
                            System.out.println("Veuillez renouveller votre saisie.");
                            marque = br.readLine();
                        }

                        System.out.println("Quelle est la cylindrée du véhicule ?");
                        cylindree = Integer.parseInt(br.readLine());

                        while (cylindree <= 0){
                            System.out.println("Veuillez renouveller votre saisie.");
                            cylindree = Integer.parseInt(br.readLine());
                        }

                        Voiture v = new Voiture(marque, cylindree);
                        flotteVehicule.add(v);
                        marque = "";
                        cylindree = -1;
                    }

                    return flotteVehicule;
                }

            }

            if (reponse.matches("N") || reponse.matches("n")) {
                System.out.println("Fin du programme... \r\nAu revoir !");
            }

            else {
                System.out.println("Saisie incorrecte!");
                recupererProprietes();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return flotteVehicule;
    }
}
