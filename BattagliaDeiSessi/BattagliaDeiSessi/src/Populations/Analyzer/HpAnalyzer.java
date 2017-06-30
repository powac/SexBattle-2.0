package Populations.Analyzer;


import Humans.PeopleFactory;
import Populations.Population;

import java.util.HashMap;
import java.util.Map;

public class HpAnalyzer
{

    /** Imposta la popolazione di persone da analizzare
     *
     * @param popolazioneDaAnalizzare la popolazione di persone da analizzare
     *
     * @throws NullPointerException se la popolazioneDaAnalizzare è null
     *
     * @throws IllegalStateException se l'insieme delle persone della popolazioneDaAnalizzare è vuoto */

    public HpAnalyzer(Population popolazioneDaAnalizzare)
    {
        if(popolazioneDaAnalizzare==null)
        {
            throw new NullPointerException("Population popolazioneDaAnalizzare nulla");
        }
        if(popolazioneDaAnalizzare.getPopulation().isEmpty())
        {
            throw new IllegalStateException("Set<People> popolazioneDaAnalizzare vuota");
        }
        this.popolazioneDaAnalizzare=popolazioneDaAnalizzare;
    }









    /** Ritorna il valore degli hp medi della popolazione
     *
     * @return
     *          Il valore degli hp medi della popolazione
     *          o
     *          0 se la popolazione non ha nessuna persona */

    public synchronized double mediumHpAnalyzer()
    {
        if(popolazioneDaAnalizzare.getPopulation().size()==0)
        {
            return 0;
        }
        else
        {
            double sommaHp=0;

            for(PeopleFactory p : popolazioneDaAnalizzare.getPopulation())
            {
                sommaHp = sommaHp + p.getHp();
            }
            return sommaHp/popolazioneDaAnalizzare.getPopulation().size();
        }
    }



    /** Ritorna il valore degli hp più piccolo della popolazione
     *
     * @return
     *          Il valore il valore degli hp più piccolo della popolazione
     *          o
     *          0 se la popolazione non ha nessuna persona */

    public synchronized float minimumHpAnalyzer()
    {
        if(popolazioneDaAnalizzare.getPopulation().size()==0)
        {
            return 0;
        }
        else
        {
            float hpMinimi=100;

            for(PeopleFactory p : popolazioneDaAnalizzare.getPopulation())
            {
                if(p.getHp()<hpMinimi)
                {
                    hpMinimi = p.getHp();
                }
            }
            return hpMinimi;
        }
    }

    /** Ritorna il valore degli hp più grande della popolazione
     *
     * @return
     *          Il valore degli hp più grande della popolazione
     *          o
     *          0 se la popolazione non ha nessuna persona */

    public synchronized float maximumHpAnalyzer()
    {
        if(popolazioneDaAnalizzare.getPopulation().size()==0)
        {
            return 0;
        }
        else
        {
            float hpMassimi=0;

            for(PeopleFactory p : popolazioneDaAnalizzare.getPopulation())
            {
                if(p.getHp()>hpMassimi)
                {
                    hpMassimi = p.getHp();
                }
            }
            return hpMassimi;
        }
    }



    /** Ritorna una mappa dove la chiave corrisponde al carattere della persona,
     *  e come valore gli hp medi delle persone di quel carattere
     *
     * @return
     *          La mappa che associa un Behaviour di una persona con gli hp medi di persone con quel Behaviour
     *          o
     *          la mappa vuota se nella popolazione non sono presenti persone di quel Behaviour */

    public synchronized Map<PeopleFactory.Behaviour,Double> hpCounter()
    {
        Map<PeopleFactory.Behaviour,Double> behaviourMap = new HashMap<>();

        double morigerato=0;
        double sommaHpMorigerato=0;

        double avventuriero=0;
        double sommaHpAvventuriero=0;

        double prudente=0;
        double sommaHpPrudente=0;

        double spregiudicata=0;
        double sommaHpSpregiudicata=0;

        for (PeopleFactory p : popolazioneDaAnalizzare.getPopulation())
        {
            if(p.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))
            {
                morigerato++;
                sommaHpMorigerato = sommaHpMorigerato + p.getHp();
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))
            {
                avventuriero++;
                sommaHpAvventuriero = sommaHpAvventuriero + p.getHp();
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Prudente))
            {
                prudente++;
                sommaHpPrudente = sommaHpPrudente + p.getHp();
            }
            else if(p.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata))
            {
                spregiudicata++;
                sommaHpSpregiudicata = sommaHpSpregiudicata + p.getHp();
            }
        }

        behaviourMap.put(PeopleFactory.Behaviour.Morigerato,sommaHpMorigerato/morigerato);
        behaviourMap.put(PeopleFactory.Behaviour.Avventuriero,sommaHpAvventuriero/avventuriero);
        behaviourMap.put(PeopleFactory.Behaviour.Prudente,sommaHpPrudente/prudente);
        behaviourMap.put(PeopleFactory.Behaviour.Spregiudicata,sommaHpSpregiudicata/spregiudicata);

        return behaviourMap;
    }



    private static Population popolazioneDaAnalizzare;

}
