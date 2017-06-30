package Populations;


import Humans.PeopleFactory;
import Populations.Strategy.MeetingStrategyFactory;

import java.util.*;
import java.util.concurrent.*;



/**    Una popolazione è un insieme di individui. A loro volta, gli individui si dividono in tipi.
 *
 *      <p>Chiamiamo stato di una popolazione l'insieme delle percentuali degli individui
 *      suddivisi nei 4 tipi MAPS rispetto alla popolazione totale.
 *
 *      <p>Assumiamo che sia data una nozione di vicinanza fra stati,
 *      in modo che la differenza fra stati vicini possa essere considerata come statisticamente non rilevante.
 *
 *      <p>Le popolazioni si evolvono in base a regole evolutive che determinano in che modo,
 *      non necessariamente deterministico, gli individui di ciascun tipo prosperano (aumentano in numero)
 *      o languono (diminuiscono nel numero) a seconda dello stato attuale della popolazione.
 *
 *      <p>Rappresentiamo una linea evolutiva di una popolazione p0 con
 *      una sequenza infinita < p0, p1, ... pn > di popolazioni generatesi nel tempo,
 *      dove ciascuna p(n+1) è ottenuta dalla precedente applicando le regole evolutive del MAPS.
 *
 *      <p>Diciamo che una evoluzione raggiunge uno stato s di stabilità evolutiva se
 *      "s" è lo stato di un suo elemento pn e, per ogni m > n lo stato di pm è vicino a s.
 *
 **/

public class Population {



    private List<PeopleFactory> popolazione;

    private int a;// = 15;
    private int b;// = 20;
    private int c;// = 3;

    public static int year = 2001;



    /**
     * Imposta una popolazione, ovvero un contenitore di persone.
     *
     * @param popolazione lista delle persone che formeranno la popolazione.
     *
     * @throws NullPointerException  se la popolazione è null, ovvero non inizializzata.
     *
     * @throws IllegalStateException se l'insieme della popolazione è vuoto.
     */

    public Population(List<PeopleFactory> popolazione) {

        if (popolazione == null) {
            throw new NullPointerException("Set<People> popolazione nulla");
        }
        if (popolazione.isEmpty()) {
            throw new IllegalStateException("Set<People> popolazione vuota");
        }
        this.popolazione = new ArrayList<PeopleFactory>(popolazione);
    }





    /**
     * Imposta i valori di a, b, c per la popolazione
     *
     * @param a : premio per il successo nella generazione di figli
     *
     * @param b : costo per la crescita di figli
     *
     * @param c : costo per il corteggiamento
     */

    public synchronized void setABC(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }





    /**
     * Rimuove una persona dalla popolazione
     *
     * @param persona persona da rimuovere dalla popolazione
     *
     * @throws NullPointerException  se la persona è null
     *
     * @throws IllegalStateException se la persona non è contenuta nella popolazione
     */


    public synchronized void removePeople(PeopleFactory persona) {
        if (persona == null) {
            throw new NullPointerException("Persona nulla");
        }
        if (!popolazione.contains(persona)) {
            throw new IllegalStateException("Persona non contenuta nella popolazione");
        }
        popolazione.remove(persona);
    }





    /**
     * Ritorna la lista delle persone della popolazione
     *
     * @return La lista delle persone della popolazione
     * o
     * la lista vuota se nella popolazione non ci sono persone
     */

    public synchronized List<PeopleFactory> getPopulation() {
        return popolazione;
    }





    /**
     * Ritorna l'anno corrente
     *
     * @return L'anno corrente per questa sessione della simulazione.
     */

    public synchronized int getCurrentYear() {
        return year;
    }





    /**
     * "L'incontro tra le persone della popolazione"
     *
     * <p>Si prendono persone random dalla lista popolazione e
     * vengono fatte accoppiare in base alla strategia evolutiva scelta, sulla base del MAPS.
     *
     * <br>Ogni generazione è differenziata per anno e questo è scandito dallo scorrimento di ogni lista.
     * Alla fine l'esito di tutti gli accoppiamenti produrrà la generazione successiva
     * e ogni nuova generazione sarà formata dai figli della precedente.
     *
     * <br>La popolazione corrente è tuttavia formata dall'unione di tutte le generazioni precendenti.
     *
     * <p>Questo metodo è in modalità sequenziale, con un incontro alla volta.
     *
     */

    public synchronized void populationMeeting(MeetingStrategyFactory strategia) {

        List<PeopleFactory> nuovaPopolazione = new ArrayList<>();

        if(!popolazione.isEmpty()) {
            nuovaPopolazione.addAll(popolazione);

            System.out.println("\nAnno corrente: " + Population.year);
            System.out.println("Size prima del meeting: " + nuovaPopolazione.size());

            strategia.setNuovaPopolazione(nuovaPopolazione,null);

            while (popolazione.size() > 0) {

                PeopleFactory primaPersonaRandom;
                if (popolazione.size() > 0) {
                    primaPersonaRandom = popolazione.get(new Random().nextInt(popolazione.size()));
                    popolazione.remove(primaPersonaRandom);
                }
                else {
                    break;
                }

                PeopleFactory secondaPersonaRandom;
                if (popolazione.size() > 0) {
                    secondaPersonaRandom = popolazione.get(new Random().nextInt(popolazione.size()));
                    popolazione.remove(secondaPersonaRandom);
                }
                else {
                    break;
                }

                strategia.MeetingStrategy(primaPersonaRandom, secondaPersonaRandom, a, b, c, year);
            }

            System.out.println("Size dopo del meeting: " + nuovaPopolazione.size());


            if(!strategia.getNuovaPopolazione().isEmpty()) {
                nuovaPopolazione = strategia.getNuovaPopolazione();

                this.popolazione = nuovaPopolazione;
            }
        }

        Population.year++;
    }





    /** "L'incontro tra le persone della popolazione"
     *
     * <p>Si prendono persone random dalla lista popolazione e
     * vengono fatte accoppiare in base alla strategia evolutiva scelta, sulla base del MAPS.
     *
     * <br>Ogni generazione è differenziata per anno e questo è scandito dallo scorrimento di ogni lista.
     * Alla fine l'esito di tutti gli accoppiamenti produrrà la generazione successiva
     * e ogni nuova generazione sarà formata dai figli della precedente.
     *
     * <br>La popolazione corrente è tuttavia formata dall'unione di tutte le generazioni precendenti.
     *
     * <p>Questo metodo è in modalità parallela, con un numero di incontri pari al numero di thread creati.
     *
     */

    public synchronized void parallelPopulationMeeting(MeetingStrategyFactory strategia) {
        int np=Runtime.getRuntime().availableProcessors();
        ExecutorService exec= Executors.newFixedThreadPool(np);

        List<PeopleFactory> nuovaPopolazione = new ArrayList<>();

        if(!popolazione.isEmpty()) {
            nuovaPopolazione.addAll(popolazione);

            System.out.println("\nAnno corrente: " + Population.year);
            System.out.println("Size prima del meeting: " + nuovaPopolazione.size());

            strategia.setNuovaPopolazione(nuovaPopolazione,exec);

            while (popolazione.size() > 0) {
                PeopleFactory primaPersonaRandom;

                if (popolazione.size() > 0) {
                    primaPersonaRandom = popolazione.get(new Random().nextInt(popolazione.size()));
                    popolazione.remove(primaPersonaRandom);
                }
                else {
                    break;
                }
                PeopleFactory secondaPersonaRandom;

                if (popolazione.size() > 0) {
                    secondaPersonaRandom = popolazione.get(new Random().nextInt(popolazione.size()));
                    popolazione.remove(secondaPersonaRandom);
                }
                else {
                    break;
                }
                if(primaPersonaRandom != null && secondaPersonaRandom != null) {
                    exec.submit(()-> strategia.MeetingStrategy(primaPersonaRandom, secondaPersonaRandom, a, b, c, year));
                }

            }



            while (!exec.isShutdown()) {
                // attende lo shutdown nella strategy
            }
            //exec.shutdownNow();

            System.out.println("Size dopo del meeting: " + nuovaPopolazione.size());

            if(!strategia.getNuovaPopolazione().isEmpty()) {
                nuovaPopolazione = strategia.getNuovaPopolazione();
                this.popolazione = nuovaPopolazione;
            }
        }
        Population.year++;
    }

}