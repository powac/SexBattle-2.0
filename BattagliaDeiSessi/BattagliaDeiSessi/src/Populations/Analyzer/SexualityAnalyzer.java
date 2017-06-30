package Populations.Analyzer;

import Humans.PeopleFactory;
import Populations.Population;

import java.util.HashMap;
import java.util.Map;

public class SexualityAnalyzer
{
    /** Imposta la popolazione di persone da analizzare
     *
     * @param popolazioneDaAnalizzare la popolazione di persone da analizzare
     *
     * @throws NullPointerException se la popolazioneDaAnalizzare è null
     *
     * @throws IllegalStateException se l'insieme delle persone della popolazioneDaAnalizzare è vuoto */

    public SexualityAnalyzer(Population popolazioneDaAnalizzare)
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




    /** Ritorna una mappa dove la chiave corrisponde alla Sexuality della persona,
     *  e come valore il numero di persone di quella Sexuality
     *
     * @return
     *          La mappa che associa un sesso di una persona al numero di persone nella popolazione di quel sesso
     *          o
     *          la mappa vuota se nella popolazione non sono presenti persone di quel sesso */

    public synchronized Map<PeopleFactory.Sexuality,Integer> sexualityCounter()
    {
        Map<PeopleFactory.Sexuality,Integer> sexualityMap = new HashMap<>();
        Integer maschi=0;
        Integer femmine=0;

        for (PeopleFactory p : popolazioneDaAnalizzare.getPopulation())
        {
            if(p.getSexuality().equals(PeopleFactory.Sexuality.Maschio))
            {
                maschi++;
            }
            else if(p.getSexuality().equals(PeopleFactory.Sexuality.Femmina))
            {
                femmine++;
            }
        }

        sexualityMap.put(PeopleFactory.Sexuality.Maschio,maschi);
        sexualityMap.put(PeopleFactory.Sexuality.Femmina,femmine);

        return sexualityMap;
    }




    /** Ritorna una mappa dove la chiave corrisponde alla Sexuality della persona,
     *  e come valore il numero in % di persone di quella Sexuality
     *
     * @return
     *          La mappa che associa un sesso di una persona al numero di persone nella popolazione di quel sesso in %
     *          o
     *          la mappa vuota se nella popolazione non sono presenti persone di quel sesso */

    public synchronized Map<PeopleFactory.Sexuality,Double> sexualityCounterX100()
    {
        Map<PeopleFactory.Sexuality,Double> sexualityMapX100 = new HashMap<>();

        Map<PeopleFactory.Sexuality,Integer> sexualityMap = sexualityCounter();


        double maschiSuTotale = (double)sexualityMap.get(PeopleFactory.Sexuality.Maschio) / popolazioneDaAnalizzare.getPopulation().size();
        sexualityMapX100.put(PeopleFactory.Sexuality.Maschio,maschiSuTotale*100);

        double femmineSuTotale = (double)sexualityMap.get(PeopleFactory.Sexuality.Femmina) / popolazioneDaAnalizzare.getPopulation().size();
        sexualityMapX100.put(PeopleFactory.Sexuality.Femmina,femmineSuTotale*100);

        return sexualityMapX100;
    }




    private static Population popolazioneDaAnalizzare;
}
