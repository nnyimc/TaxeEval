package app;

import metier.Voiture;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import presentation.IQuestionnaire;
import presentation.Questionnaire;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        IQuestionnaire questionnaire = (IQuestionnaire) context.getBean("q");
        ArrayList<Voiture> flotteVoiture  = questionnaire.recupererProprietes();
        float taxe =0;
        for(Voiture v: flotteVoiture) {
            System.out.print(v.afficherVoiture() + "\r\n");
            taxe += v.calculerTaxeVoiture();
        }
        if (flotteVoiture.size() > 0)
        System.out.print("Taxe totale à payer " + taxe + " €");
    }
}
