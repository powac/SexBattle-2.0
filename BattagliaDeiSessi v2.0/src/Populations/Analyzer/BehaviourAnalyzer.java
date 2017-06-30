package Populations.Analyzer;


import Humans.PeopleFactory;
import Populations.Population;

import java.util.HashMap;
import java.util.Map;

public class BehaviourAnalyzer {



    private static Population popolazioneDaAnalizzare;



    /** Imposta la popolazione di persone da analizzare
     *
     * @param popolazioneDaAnalizzare la popolazione di persone da analizzare
     *
     * @throws NullPointerException se la popolazioneDaAnalizzare è null
     *
     * @throws IllegalStateException se l'insieme delle persone della popolazioneDaAnalizzare è vuoto */

    public BehaviourAnalyzer(Population popolazioneDaAnalizzare) {
        if(popolazioneDaAnalizzare == null) {
            throw new NullPointerException("Population popolazioneDaAnalizzare nulla");
        }
        if(popolazioneDaAnalizzare.getPopulation().isEmpty()) {
            throw new IllegalStateException("Set<People> popolazioneDaAnalizzare vuota");
        }
        BehaviourAnalyzer.popolazioneDaAnalizzare=popolazioneDaAnalizzare;
    }





    /** Ritorna una mappa dove la chiave corrisponde al carattere della persona,
     *  e come valore il numero di persone con quel carattere
     *
     * @return
     *          La mappa che associa un Behaviour di una persona al numero di persone nella popolazione di quel Behaviour
     *          o
     *          la mappa vuota se nella popolazione non sono presenti persone di quel Behaviour */

    public synchronized Map<PeopleFactory.Behaviour,Integer> behaviourCounter() {
        Map<PeopleFactory.Behaviour,Integer> behaviourMap = new HashMap<>();
        Integer morigerato = 0;
        Integer avventuriero = 0;
        Integer prudente = 0;
        Integer spregiudicata = 0;

        for (PeopleFactory p : popolazioneDaAnalizzare.getPopulation()) {
            if(p.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                morigerato++;
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero)) {
                avventuriero++;
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) {
                prudente++;
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                spregiudicata++;
            }
        }

        behaviourMap.put(PeopleFactory.Behaviour.Morigerato,morigerato);
        behaviourMap.put(PeopleFactory.Behaviour.Avventuriero,avventuriero);
        behaviourMap.put(PeopleFactory.Behaviour.Prudente,prudente);
        behaviourMap.put(PeopleFactory.Behaviour.Spregiudicata,spregiudicata);

        return behaviourMap;
    }





    /** Ritorna una mappa dove la chiave corrisponde al carattere della persona,
     *  e come valore il numero in % di persone con quel carattere
     *
     * @return
     *          La mappa che associa un Behaviour di una persona al numero di persone nella popolazione di quel Behaviour in %
     *          o
     *          la mappa vuota se nella popolazione non sono presenti persone di quel Behaviour */

    public synchronized Map<PeopleFactory.Behaviour,Double> behaviourCounterX100() {
        Map<PeopleFactory.Behaviour,Double> behaviourMapX100 = new HashMap<>();

        Map<PeopleFactory.Behaviour,Integer> behaviourMap = behaviourCounter();

        double morigeratoSuTotale = (double)behaviourMap.get(PeopleFactory.Behaviour.Morigerato) / popolazioneDaAnalizzare.getPopulation().size();
        behaviourMapX100.put(PeopleFactory.Behaviour.Morigerato,morigeratoSuTotale * 100);

        double avventurieroSuTotale = (double)behaviourMap.get(PeopleFactory.Behaviour.Avventuriero) / popolazioneDaAnalizzare.getPopulation().size();
        behaviourMapX100.put(PeopleFactory.Behaviour.Avventuriero,avventurieroSuTotale * 100);

        double prudenteSuTotale = (double)behaviourMap.get(PeopleFactory.Behaviour.Prudente) / popolazioneDaAnalizzare.getPopulation().size();
        behaviourMapX100.put(PeopleFactory.Behaviour.Prudente,prudenteSuTotale * 100);

        double spregiudicataSuTotale = (double)behaviourMap.get(PeopleFactory.Behaviour.Spregiudicata) / popolazioneDaAnalizzare.getPopulation().size();
        behaviourMapX100.put(PeopleFactory.Behaviour.Spregiudicata,spregiudicataSuTotale * 100);

        return behaviourMapX100;
    }

}
