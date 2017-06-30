package Populations.Strategy;

import Humans.PeopleFactory;
import java.util.List;
import java.util.concurrent.ExecutorService;


public interface MeetingStrategyFactory
{
    /**     La fabbrica delle strategie evolutive della popolazione
     *
     *
     *      Una generazione g0 può adottare una strategia evolutiva
     *      che porterà a creare una nuova generazione g1.
     *      In questo caso g1 sono i figli dei genitori in g0 che
     *      hanno adottato questa strategia evolutiva.
     *
     *      Se tutte le generazioni da g0 a gN-1 dove N è il numero di
     *      generazioni totali che formeranno la popolazione P, adottano
     *      la stessa strategia, si dice che la popolazione P ha
     *      una strategia evolutiva statica.
     *
     *      Se almeno una generazione tra g0 e gN-1 dove N è il numero di
     *      generazioni totali che formeranno la popolazione P, adotta
     *      una strategia evolutiva diversa da tutte quelle scelte in precedenza,
     *      si dice che la popolazione P ha una strategia evolutiva dinamica.
     *
    **/



    /** Adotta una strategia di accoppiamento per due persone
     *
     * @param primaPersonaRandom è una persona presa dalla popolazione che adotterà la strategia di accoppiamento
     *
     * @param secondaPersonaRandom è una persona presa dalla popolazione che adotterà la strategia di accoppiamento
     *
     * @param a premio per il successo nella generazione di figli
     *
     * @param b costo del crescere figli
     *
     * @param c costo del corteggiamento
     *
     * @param year anno corrente
     *
     *
     * @throws NullPointerException se primaPersonaRandom o secondaPersonaRandom sono nulli */

    public void MeetingStrategy(PeopleFactory primaPersonaRandom, PeopleFactory secondaPersonaRandom,
                                     int a, int b, int c, int year);





    /** Ritorna la lista delle persone che formeranno la prossima generazione
     *
     * @return
     *          La lista delle persone che formeranno la prossima generazione
     *          o
     *          null se la lista è vuota */

    public List<PeopleFactory> getNuovaPopolazione();



    /** Imposta le persone di questa popolazione
     *
     * @param nuovaPopolazione è la popolazione attuale
     *
     * @param exec è l'executor service per il meeting parallelo */

    public void setNuovaPopolazione(List<PeopleFactory> nuovaPopolazione, ExecutorService exec);
}
