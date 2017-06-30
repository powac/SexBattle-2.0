package Populations.Analyzer;


import Humans.PeopleFactory;
import Populations.Population;

import java.util.HashMap;
import java.util.Map;

public class AgeAnalyzer {



    private static Population popolazioneDaAnalizzare;



    /** Imposta la popolazione di persone da analizzare
     *
     * @param popolazioneDaAnalizzare la popolazione di persone da analizzare
     *
     * @throws NullPointerException se la popolazioneDaAnalizzare è null
     *
     * @throws IllegalStateException se l'insieme delle persone della popolazioneDaAnalizzare è vuoto */

    public AgeAnalyzer(Population popolazioneDaAnalizzare) {
        if(popolazioneDaAnalizzare == null) {
            throw new NullPointerException("Population popolazioneDaAnalizzare nulla");
        }
        if(popolazioneDaAnalizzare.getPopulation().isEmpty()) {
            throw new IllegalStateException("Set<People> popolazioneDaAnalizzare vuota");
        }
        AgeAnalyzer.popolazioneDaAnalizzare = popolazioneDaAnalizzare;
    }





    /** Ritorna il valore dell'età media della popolazione
     *
     * @return
     *          Il valore dell'età media della popolazione
     *          o
     *          0 se la popolazione non ha nessuna persona */

    public synchronized double mediumAgeAnalyzer() {
        if(popolazioneDaAnalizzare.getPopulation().size() == 0) {
            return 0;
        }
        else {
            double sommaEta = 0;

            for(PeopleFactory p : popolazioneDaAnalizzare.getPopulation()) {
                sommaEta = sommaEta + p.getAge();
            }
            return sommaEta/popolazioneDaAnalizzare.getPopulation().size();
        }
    }





    /** Ritorna il valore dell'età più piccolo della popolazione
     *
     * @return
     *          Il valore dell'età più piccolo della popolazione
     *          o
     *          0 se la popolazione non ha nessuna persona */

    public synchronized int minimumAgeAnalyzer() {
        if(popolazioneDaAnalizzare.getPopulation().size() == 0) {
            return 0;
        }
        else {
            int etaMinima = 100;

            for(PeopleFactory p : popolazioneDaAnalizzare.getPopulation()) {
                if(p.getAge() < etaMinima) {
                    etaMinima = p.getAge();
                }

            }
            return etaMinima;
        }
    }





    /** Ritorna il valore dell'età più grande della popolazione
     *
     * @return
     *          Il valore dell'età più grande della popolazione
     *          o
     *          0 se la popolazione non ha nessuna persona */

    public synchronized int maximumAgeAnalyzer() {
        if(popolazioneDaAnalizzare.getPopulation().size() == 0) {
            return 0;
        }
        else {
            int etaMassima = 0;

            for(PeopleFactory p : popolazioneDaAnalizzare.getPopulation()) {
                if(p.getAge() > etaMassima) {
                    etaMassima = p.getAge();
                }
            }
            return etaMassima;
        }
    }





    /** Ritorna una mappa dove la chiave corrisponde al carattere della persona,
     *  e come valore l'età media delle persone di quel carattere
     *
     * @return
     *          La mappa che associa un Behaviour di una persona all'età media di persone con quel Behaviour
     *          o
     *          la mappa vuota se nella popolazione non sono presenti persone di quel Behaviour */

    public synchronized Map<PeopleFactory.Behaviour,Double> ageCounter() {
        Map<PeopleFactory.Behaviour,Double> behaviourMap = new HashMap<>();

        double morigerato = 0;
        double sommaEtaMorigerato = 0;

        double avventuriero = 0;
        double sommaEtaAvventuriero = 0;

        double prudente = 0;
        double sommaEtaPrudente = 0;

        double spregiudicata = 0;
        double sommaEtaSpregiudicata = 0;

        for (PeopleFactory p : popolazioneDaAnalizzare.getPopulation()) {
            if(p.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                morigerato++;
                sommaEtaMorigerato = sommaEtaMorigerato + p.getAge();
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero)) {
                avventuriero++;
                sommaEtaAvventuriero = sommaEtaAvventuriero + p.getAge();
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) {
                prudente++;
                sommaEtaPrudente = sommaEtaPrudente + p.getAge();
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                spregiudicata++;
                sommaEtaSpregiudicata = sommaEtaSpregiudicata + p.getAge();
            }
        }

        behaviourMap.put(PeopleFactory.Behaviour.Morigerato, sommaEtaMorigerato / morigerato);
        behaviourMap.put(PeopleFactory.Behaviour.Avventuriero, sommaEtaAvventuriero / avventuriero);
        behaviourMap.put(PeopleFactory.Behaviour.Prudente, sommaEtaPrudente / prudente);
        behaviourMap.put(PeopleFactory.Behaviour.Spregiudicata, sommaEtaSpregiudicata / spregiudicata);

        return behaviourMap;
    }

}
