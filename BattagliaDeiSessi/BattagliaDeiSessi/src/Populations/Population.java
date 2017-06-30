package Populations;


import Humans.PeopleFactory;
import Populations.Strategy.AverageGainStrategy;
import Populations.Strategy.MeetingStrategyFactory;

import java.util.*;
import java.util.concurrent.*;

public class Population
{

 /**    Una popolazione `e un insieme di individui
 *
 *      Gli individui si dividono in tipi
 *
 *      Chiamiamo stato di una popolazione la percentuale del numero di individui
 *      di ciascun tipo rispetto alla popolazione totale.
 *
 *      Assumiamo che sia data una nozione di vicinanza fra stati,
 *      in modo che la differenza fra stati vicini possa essere considerata come statisticamente non rilevante.
 *
 *      Le popolazioni si evolvono in base a regole evolutive che determinano in che modo,
 *      non necessariamente deterministico,
 *      gli individui di ciascun tipo prosperano (aumentano in numero)
 *      o languono (diminuiscono nel numero) a seconda dello stato attuale della popolazione.
 *
 *      Una evoluzione `e una sequenza infinita < p0,p1,··· > di popolazioni,
 *      dove p0 `e chiamata popolazione iniziale e ciascuna pn+1 `e ottenuta dalla precedente
 *      applicando le regole evolutive.
 *
 *      Diciamo che una evoluzione raggiunge uno stato s di stabilità evolutiva se
 *      s è lo stato di un suo elemento pn
 *      e, per ogni m > n lo stato di pm è vicino a s.
 *
 **/




    /**
     * Imposta la popolazione di persone
     *
     * @param popolazione lista delle persone che formeranno la popolazione
     *
     * @throws NullPointerException  se popolazione è null
     *
     * @throws IllegalStateException se l'insieme della popolazione è vuoto
     */

    public Population(List<PeopleFactory> popolazione) {

        if (popolazione == null) {
            throw new NullPointerException("Set<People> popolazione nulla");
        }
        if (popolazione.isEmpty()) {
            throw new IllegalStateException("Set<People> popolazione vuota");
        }
        this.popolazione = popolazione;

    }

    /**
     * Imposta i valori di a b c per la popolazione
     *
     * @param a : premio per il successo nella generazione di figli
     *
     * @param b : premio per il successo nella generazione di figli
     *
     * @param c : premio per il successo nella generazione di figli
     */

    public synchronized void setABC(int a, int b, int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }


    /**
     * Imposta la lista delle persone della nuova popolazione
     *
     * @param popolazione lista delle persone che formeranno la popolazione
     *
     * @throws NullPointerException  se popolazione è null
     *
     * @throws IllegalStateException se l'insieme della popolazione è vuoto
     */

    /*
    public synchronized void setPopulation(List<PeopleFactory> popolazione) {
        if (popolazione == null) {
            throw new NullPointerException("Set<People> popolazione nulla");
        }
        if (popolazione.isEmpty()) {
            throw new IllegalStateException("Set<People> popolazione vuota");
        }
        this.popolazione = popolazione;
    }
    */

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


    public synchronized List<PeopleFactory> getPopulation() { return popolazione; }



    /**
     * Ritorna l'anno corrente di questa popolazione
     *
     * @return L'anno corrente di questa popolazione
     */


    public synchronized int getCurrentYear()
    {
        return year;
    }




    /**
     * L'incontro tra le persone della popolazione
     *
     * Si prendono persone random dalla popolazione e
     * vengono fatte accoppiare in base alla strategia evolutiva scelta.
     *
     * Ogni generazione è differenziata per anno.
     *
     * Alla fine l'esito di tutti gli accoppiamenti produrrà la generazione successiva.
     *
     * Ogni nuova generazione sarà formata dai figli della precedente.
     *
     * La popolazione è formata dall'unione di tutte le generazioni precendenti .
     *
     */





    /**
     *
     *      Modalità sequenziale con un incontro alla volta.
     *
     */


    public synchronized void populationMeeting(MeetingStrategyFactory strategia)
    {
        List<PeopleFactory> nuovaPopolazione = new ArrayList<>();

        if(!popolazione.isEmpty() == true)
        {
            nuovaPopolazione.addAll(popolazione);

            System.out.println("\nAnno corrente: " + this.year);
            System.out.println("Size prima del meeting: " + nuovaPopolazione.size());

            strategia.setNuovaPopolazione(nuovaPopolazione,null);

            while (popolazione.size() > 0)
            {

                PeopleFactory primaPersonaRandom;

                if (popolazione.size() > 0)
                {
                    primaPersonaRandom = popolazione.get(new Random().nextInt(popolazione.size()));
                    popolazione.remove(primaPersonaRandom);
                } else {
                    break;
                }

                PeopleFactory secondaPersonaRandom;

                if (popolazione.size() > 0)
                {
                    secondaPersonaRandom = popolazione.get(new Random().nextInt(popolazione.size()));
                    popolazione.remove(secondaPersonaRandom);
                } else {
                    break;
                }

                strategia.MeetingStrategy(primaPersonaRandom, secondaPersonaRandom, a, b, c, year);
            }

            System.out.println("Size dopo del meeting: " + nuovaPopolazione.size());


            if(!strategia.getNuovaPopolazione().isEmpty())
            {
                nuovaPopolazione = strategia.getNuovaPopolazione();

                this.popolazione = nuovaPopolazione;
            }
        }

        this.year = this.year + 1;
    }










    /**
     *
     *      Modalità parallela, con un numero di incontri pari al numero di thread creati.
     *
     */

    public synchronized void parallelPopulationMeeting(MeetingStrategyFactory strategia)
    {
        int np=Runtime.getRuntime().availableProcessors();
        exec= Executors.newFixedThreadPool(np);

        List<PeopleFactory> nuovaPopolazione = new ArrayList<>();

        if(!popolazione.isEmpty() == true)
        {
            nuovaPopolazione.addAll(popolazione);

            System.out.println("\nAnno corrente: " + this.year);
            System.out.println("Size prima del meeting: " + nuovaPopolazione.size());

            strategia.setNuovaPopolazione(nuovaPopolazione,exec);

            while (popolazione.size() > 0)
            {
                PeopleFactory primaPersonaRandom = null;

                if (popolazione.size() > 0)
                {
                    primaPersonaRandom = popolazione.get(new Random().nextInt(popolazione.size()));
                    popolazione.remove(primaPersonaRandom);

                }
                else
                {
                    break;
                }

                PeopleFactory secondaPersonaRandom=null;


                if (popolazione.size() > 0)
                {
                    secondaPersonaRandom = popolazione.get(new Random().nextInt(popolazione.size()));
                    popolazione.remove(secondaPersonaRandom);

                }
                else
                {

                    break;
                }
                if(primaPersonaRandom!=null && secondaPersonaRandom!=null)
                {
                    PeopleFactory finalPrimaPersonaRandom = primaPersonaRandom;
                    PeopleFactory finalSecondaPersonaRandom = secondaPersonaRandom;
                    exec.submit(()-> strategia.MeetingStrategy(finalPrimaPersonaRandom, finalSecondaPersonaRandom, a, b, c, year));
                }

            }



            while (exec.isShutdown() == false)
            {
                // attende lo shutdown nella strategy
            }
            //exec.shutdownNow();

            System.out.println("Size dopo del meeting: " + nuovaPopolazione.size());


            if(!strategia.getNuovaPopolazione().isEmpty())
            {
                nuovaPopolazione = strategia.getNuovaPopolazione();
                this.popolazione = nuovaPopolazione;
            }
        }

        this.year = this.year + 1;
    }






    private static List<PeopleFactory> popolazione = new ArrayList<>();

    private static ExecutorService exec;

    private static int a;// = 15;
    private static int b;// = 20;
    private static int c;// = 3;

    private static int year = 2001;

}