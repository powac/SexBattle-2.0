package Test;

import Gui.OpeningPage;
import Humans.People;
import Humans.PeopleFactory;
import Populations.Analyzer.*;
import Populations.Population;
import Populations.Strategy.OverXvalueStrategy;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.util.*;
import java.util.concurrent.ExecutionException;



public class FXmain extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public synchronized void start(Stage primaryStage) throws ExecutionException, InterruptedException {
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public synchronized void handle(WindowEvent event) {       // gestisce l'uscita inaspettata dalla GUI
                primaryStage.close();
                Thread.currentThread().interrupt();
            }
        });

        OpeningPage openingPage = new OpeningPage(primaryStage);
        openingPage.startOpeningPage();
    }
}




/*
    public synchronized Population inizio() throws ExecutionException, InterruptedException {
        List<PeopleFactory> personeIniziali = new ArrayList<>();

        for(int i = 0; i < 31; i++) {
            personeIniziali.add(new People(0, 0.0));
        }

        int a = 15;
        int b = 20;
        int c = 3;

        Population popolazioneUniverso = new Population(personeIniziali);
        popolazioneUniverso.setABC(a,b,c);

        long inizio = System.currentTimeMillis();

        OverXvalueStrategy overXvalueStrategy = new OverXvalueStrategy();

        for(int i = 0; i < 250; i++) {
            popolazioneUniverso.populationMeeting(overXvalueStrategy);
            //popolazioneUniverso.parallelPopulationMeeting(overXvalueStrategy);

            // mettere qui il suspend !


            if(t.isInterrupted()==true)
            {
                break;
            }
            }
        long fine = System.currentTimeMillis();

        System.out.println("Tempo: " + String.valueOf( (fine - inizio)/1000 ) + " secondi.");

        System.out.println("\n\n\n\nSize nel FXmain " + popolazioneUniverso.getPopulation().size());

        for(int i = 0; i < 1; i++) {
            System.out.println("\n\n\n\nAnalisi sulla popolazione :");

            SexualityAnalyzer sexualityAnalyzer = new SexualityAnalyzer(popolazioneUniverso);

            System.out.println("\nMaschi: " + sexualityAnalyzer.sexualityCounter().get(PeopleFactory.Sexuality.Maschio) + " ovvero il "+
                    sexualityAnalyzer.sexualityCounterX100().get(PeopleFactory.Sexuality.Maschio) + " %");
            System.out.println("Femmine: " + sexualityAnalyzer.sexualityCounter().get(PeopleFactory.Sexuality.Femmina) + " ovvero il "+
                    sexualityAnalyzer.sexualityCounterX100().get(PeopleFactory.Sexuality.Femmina) + " %");


            BehaviourAnalyzer behaviourAnalyzer = new BehaviourAnalyzer(popolazioneUniverso);

            System.out.println("\nMorigerati: " + behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Morigerato) +
                    " ovvero il " + behaviourAnalyzer.behaviourCounterX100().get(PeopleFactory.Behaviour.Morigerato) + " %" +
            "       Punteggio in ottavi: " + (((behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Morigerato) * 100) /
                    sexualityAnalyzer.sexualityCounter().get(PeopleFactory.Sexuality.Maschio)) * 800) / 100 + " / 800"+
                    "   Deve essere 500/800");

            System.out.println("Avventurieri: " + behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Avventuriero) +
                    " ovvero il " + behaviourAnalyzer.behaviourCounterX100().get(PeopleFactory.Behaviour.Avventuriero) + " %" +
                    "       Punteggio in ottavi: " + (((behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Avventuriero) * 100) /
                    sexualityAnalyzer.sexualityCounter().get(PeopleFactory.Sexuality.Maschio)) * 800) / 100 + " / 800" +
                    "   Deve essere 300/800");

            System.out.println("Prudenti: " + behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Prudente) + " ovvero il " +
                    behaviourAnalyzer.behaviourCounterX100().get(PeopleFactory.Behaviour.Prudente) + " %" +
                    "       Punteggio in sesti: " + (((behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Prudente) * 100) /
                    sexualityAnalyzer.sexualityCounter().get(PeopleFactory.Sexuality.Femmina)) * 600) / 100 + " / 600" +
                    "   Deve essere 500/600");

            System.out.println("Spregiudicate: " + behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Spregiudicata) +
                    " ovvero il " + behaviourAnalyzer.behaviourCounterX100().get(PeopleFactory.Behaviour.Spregiudicata) + " %" +
                    "       Punteggio in sesti: " + (((behaviourAnalyzer.behaviourCounter().get(PeopleFactory.Behaviour.Spregiudicata) * 100) /
                    sexualityAnalyzer.sexualityCounter().get(PeopleFactory.Sexuality.Femmina)) * 600) / 100 + " / 600" +
                    "   Deve essere 100/600");


            AgeAnalyzer ageAnalyzer = new AgeAnalyzer(popolazioneUniverso);

            System.out.println("\nEtà media Morigerati: " + ageAnalyzer.ageCounter().get(PeopleFactory.Behaviour.Morigerato));
            System.out.println("Età media Avventurieri: " + ageAnalyzer.ageCounter().get(PeopleFactory.Behaviour.Avventuriero));
            System.out.println("Età media Prudenti: " + ageAnalyzer.ageCounter().get(PeopleFactory.Behaviour.Prudente));
            System.out.println("Età media Spregiudicate: " + ageAnalyzer.ageCounter().get(PeopleFactory.Behaviour.Spregiudicata));

            System.out.println("Età massima della popolazione: " + ageAnalyzer.maximumAgeAnalyzer());
            System.out.println("Età minima della popolazione: " + ageAnalyzer.minimumAgeAnalyzer());
            System.out.println("Età media della popolazione: " + ageAnalyzer.mediumAgeAnalyzer());


            HpAnalyzer hpAnalyzer = new HpAnalyzer(popolazioneUniverso);

            System.out.println("\nGli hp medi dei Morigerati: " + hpAnalyzer.hpCounter().get(PeopleFactory.Behaviour.Morigerato));
            System.out.println("Gli hp medi dei Avventurieri: " + hpAnalyzer.hpCounter().get(PeopleFactory.Behaviour.Avventuriero));
            System.out.println("Gli hp medi delle Prudenti: " + hpAnalyzer.hpCounter().get(PeopleFactory.Behaviour.Prudente));
            System.out.println("Gli hp medi delle Spregiudicate: " + hpAnalyzer.hpCounter().get(PeopleFactory.Behaviour.Spregiudicata));

            System.out.println("Gli hp massimi della popolazione: " + hpAnalyzer.maximumHpAnalyzer());
            System.out.println("Gli hp minimi della popolazione: " + hpAnalyzer.minimumHpAnalyzer());
            System.out.println("Gli hp medi popolazione: " + hpAnalyzer.mediumHpAnalyzer());
        }
        return popolazioneUniverso;
    }
}




     La tabella MAPS dei costi e benefici.
 *
 *      Diamo un nome ai costi e ai benefici evolutivi che incontriamo nella battaglia dei sessi:
 *
 *      a : premio per il successo nella generazione di figli
 *      b : costo del crescere figli
 *      c : costo del corteggiamento
 *
 *
 *      Descriviamo il risultato dell’incontro tra una donna di tipo X ed un uomo di tipo Y
 *      mediante una coppia (x,y), dove x `e il payoff di X e y quello di Y.
 *      In base alla descrizione dei quattro tipi,
 *      la battaglia dei sessi può essere sintetizzata nella seguente tabella MAPS,
 *      che può essere usata nella definizione delle regole evolutive.
 *
 *
 *          |              M              A
 *      ____|_______________________________________
 *          |
 *          |
 *       P  |    (a-b/2-c,a-b/2-c)       (0,0)
 *          |
 *          |
 *       S  |    (a - b/2, a - b/2)    (a - b, a)
 *          |
 *          |
 *
 *
 *  */



/**     Il caso studio di Dawkins.
 *
 *      Dawkins ha descritto la battaglia dei sessi adottando, a titolo esemplificativo,
 *      i seguenti valori: a = 15, b = 20 e c = 3. Ecco la corrispondente tabella MAPS:
 *
 *
 *
 *
 *          |              M              A
 *      ____|_______________________________________
 *          |
 *          |
 *       P  |           (2, 2)           (0,0)
 *          |
 *          |
 *       S  |           (5, 5)         (-5, 15)
 *          |
 *          |
 *
 *
 *      Con tali valori il sistema converge a uno stato di stabilità evolutiva in cui
 *      i 5/6 delle donne è di tipo P e i 5/8 degli uomini è di tipo M.
 *
 *      È facile verificare la stabilità della soluzione:
 *      con queste proporzioni, il guadagno medio di una donna prudente, che è di 2 · 5/8
 *      è lo stesso che per una spregiudicata, che è di (5·5)/8 − (5·3)/8 ;
 *
 *      Dunque a nessuna delle due conviene cambiare strategia evolutiva.
 *      Stesso per gli uomini.
 *
 *  */













/**
 *
 *
 *
 *
 *      Tipologia            |      Guadagno medio
 *      _____________________|____________________________________________________________
 *                           |
 *       Morigerato          |      ((a-(b/2))-c) * 5 / 6   +     (a - (b/2)) * 1 / 6
 *                           |
 *       Avventuriero        |      0 * 5 / 6               +     a * 1 / 6
 *                           |
 *       Spregiudicata       |      (a - (b/2)) * 5 / 8     +     (a - b) * 3 / 8
 *                           |
 *       Prudente            |      ((a-(b/2))-c) * 5 / 8   +     0 * 3 / 8
 *                           |
 *
 *
 *
 *      Tipologia            |      Guadagno medio con valori    a=15  b=20  c=3
 *      _____________________|____________________________________________________________
 *                           |
 *       Morigerato          |      2,5
 *                           |
 *       Avventuriero        |      2,5
 *                           |
 *       Spregiudicata       |      1,25
 *                           |
 *       Prudente            |      1,25
 *                           |
 *                           |
 *
 *
 *
 *      Tipologia       |       Numero individui
 *      ________________|_______________________________
 *                      |
 *      Prudente        |       5 / 6
 *                      |
 *      Spregiudicata   |       1 / 6
 *                      |
 *      Morigerato      |       5 / 8
 *                      |
 *      Avventuriero    |       3 / 8
 *                      |
 *
 *
 *
 *
 *
 *          |              M              A
 *      ____|_______________________________________
 *          |
 *          |
 *       P  |           (2, 2)           (0,0)
 *          |
 *          |
 *       S  |           (5, 5)         (-5, 15)
 *          |
 *          |
 *
 *
 *
 *
 *
 *
 *      Tipologia            |      Numero di figli per incontro medio
 *      _____________________|____________________________________________________________
 *                           |
 *       Morigerato          |      2 prudente      +   5 spregiudicata     =   7   /   2   =   3,5
 *                           |
 *       Avventuriero        |      0 prudente      +   15 spregiudicata    =   15  /   2   =   7,5
 *                           |
 *       Spregiudicata       |      5 morigerati    +   -5 avventurieri     =   0   /   2   =   0
 *                           |
 *       Prudente            |      2 morigerati    +   0 avventurieri      =   2   /   2   =   1
 *                           |
 *                           |                                              Somma               12  /   4   =   3
 *                           |
 *                           |                                                        Media =   3 * 2 = 6 ??
 *
 *      Tipologia            |      Numero di figli per incontro medio
 *      _____________________|____________________________________________________________
 *                           |
 *       Morigerato          |      2 prudente      /   5 spregiudicata     =   range 5 - 2 = 3
 *                           |
 *       Avventuriero        |      0 prudente      /   15 spregiudicata    =   range 15 - 0 = 15
 *                           |
 *       Spregiudicata       |      5 morigerati    /   -5 avventurieri     =   range 5 - -5 = 10
 *                           |
 *       Prudente            |      2 morigerati    /   0 avventurieri      =   range 2 - 0 = 2
 *                           |
 *                           |
 *
 *          |              M              A
 *      ____|_______________________________________
 *          |
 *          |
 *       P  |        (2+2) = 4          (0+0) = 0
 *          |
 *          |
 *       S  |        (5+5) = 10        (-5+15) = 10
 *          |
 *          |
 *
 *
 *          se è superiore a 3,5 fa un figlio morigerato
 *          se è superiore a 1 fa un figlio avventuriero
 *          se entrambi gli if sono soddisfatti fanno un figlio morigerato e avventuriero
 *
 *  */