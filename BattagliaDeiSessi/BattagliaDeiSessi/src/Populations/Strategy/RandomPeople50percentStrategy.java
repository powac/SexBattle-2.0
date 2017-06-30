package Populations.Strategy;

import Humans.People;
import Humans.PeopleFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;


public class RandomPeople50percentStrategy implements MeetingStrategyFactory
{

    public RandomPeople50percentStrategy() {}


    @Override
    public synchronized void MeetingStrategy(PeopleFactory primaPersonaRandom, PeopleFactory secondaPersonaRandom,
                                             int a, int b, int c, int year)
    {

        quantiSono=quantiSono-2;


        double randomFiglio = Math.random();


        if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))) {

            int guadagnoPrudente = 0;

            int guadagnoAvventuriero = 0;


        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))) {


            if(randomFiglio<0.5)
            {
                nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero,0,0, year));
            }
            else if(randomFiglio>=0.5)
            {
                nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
            }



        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))) {


            if(randomFiglio<0.5)
            {
                nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
            }
            else if(randomFiglio>=0.5)
            {
                nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente,0,0, year));
            }




        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))) {



            if(randomFiglio<0.5)
            {
                nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
            }
            else if(randomFiglio>=0.5)
            {
                nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
            }



        }

        if(quantiSono<=1 && exec!=null)
        {
            exec.shutdown();
        }

    }


    @Override
    public synchronized List<PeopleFactory> getNuovaPopolazione()
    {
        return nuovaPopolazione;
    }

    @Override
    public synchronized void setNuovaPopolazione(List<PeopleFactory> nuovaPopolazione, ExecutorService exec)
    {
        this.nuovaPopolazione=nuovaPopolazione;

        quantiSono = nuovaPopolazione.size();

        if(exec!=null)
        {
            this.exec=exec;
        }
    }


    private static List<PeopleFactory> nuovaPopolazione;

    private static int quantiSono=0;

    private volatile ExecutorService exec;
}
