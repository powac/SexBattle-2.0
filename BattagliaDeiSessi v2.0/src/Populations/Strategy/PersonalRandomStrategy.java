package Populations.Strategy;

import Humans.People;
import Humans.PeopleFactory;
import Populations.Population;

import java.util.List;
import java.util.concurrent.ExecutorService;


public class PersonalRandomStrategy implements MeetingStrategyFactory {



    private static int avventurieroSpregiudicataFiglioAvventuriero;
    private static int avventurieroSpregiudicataFiglioSpregiudicata;

    private static int morigeratoPrudenteFiglioMorigerato;
    private static int morigeratoPrudenteFiglioPrudente;

    private static int morigeratoSpregiudicataFiglioMorigerato;
    private static int morigeratoSpregiudicataFiglioSpregiudicata;



    private static List<PeopleFactory> nuovaPopolazione;

    private static int quantiSono=0;

    private volatile ExecutorService exec;

    public PersonalRandomStrategy() {}




    @Override
    public synchronized void MeetingStrategy(PeopleFactory primaPersonaRandom, PeopleFactory secondaPersonaRandom,
                                             int a, int b, int c, int year) {

        quantiSono = quantiSono - 2;


        double randomFiglio = Math.random();

        if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))) {


            // niente figli


        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))) {


            if(avventurieroSpregiudicataFiglioAvventuriero == 0 && avventurieroSpregiudicataFiglioSpregiudicata == 0) {
                // niente figli
            }
            else {
                if(avventurieroSpregiudicataFiglioAvventuriero < avventurieroSpregiudicataFiglioSpregiudicata) {
                    if(randomFiglio < (double) avventurieroSpregiudicataFiglioAvventuriero / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero ,0 ,0.0));
                    }
                    else if(randomFiglio >= (double) avventurieroSpregiudicataFiglioAvventuriero / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata, 0, 0.0));
                    }
                }
                else if(avventurieroSpregiudicataFiglioAvventuriero > avventurieroSpregiudicataFiglioSpregiudicata) {
                    if(randomFiglio < (double) avventurieroSpregiudicataFiglioSpregiudicata / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata, 0, 0.0));
                    }
                    else if(randomFiglio >= (double) avventurieroSpregiudicataFiglioSpregiudicata / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero, 0, 0.0));
                    }
                }
                else if(avventurieroSpregiudicataFiglioAvventuriero == avventurieroSpregiudicataFiglioSpregiudicata) {
                    if(randomFiglio < 0.5) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero, 0, 0.0));
                    }
                    else if(randomFiglio >= 0.5) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata, 0, 0.0));
                    }
                }
            }




        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))) {



            if(morigeratoPrudenteFiglioMorigerato == 0 && morigeratoPrudenteFiglioPrudente == 0) {
                // niente figli
            }
            else {
                if(morigeratoPrudenteFiglioMorigerato < morigeratoPrudenteFiglioPrudente) {
                    if(randomFiglio < (double) morigeratoPrudenteFiglioMorigerato / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato, Population.year, 0.0));
                    }
                    else if(randomFiglio >= (double) morigeratoPrudenteFiglioMorigerato/100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente, Population.year, 0.0));
                    }
                }
                else if(morigeratoPrudenteFiglioMorigerato > morigeratoPrudenteFiglioPrudente) {
                    if(randomFiglio < (double) morigeratoPrudenteFiglioPrudente / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente, Population.year, 0.0));
                    }
                    else if(randomFiglio >= (double) morigeratoPrudenteFiglioPrudente / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato, Population.year, 0.0));
                    }
                }
                else if(morigeratoPrudenteFiglioMorigerato == morigeratoPrudenteFiglioPrudente) {
                    if(randomFiglio < 0.5) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato, Population.year, 0.0));
                    }
                    else if(randomFiglio >= 0.5)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente, Population.year, 0.0));
                    }
                }
            }





        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))) {


            if(morigeratoSpregiudicataFiglioMorigerato == 0 && morigeratoSpregiudicataFiglioSpregiudicata == 0)
            {
                // niente figli
            }
            else {
                if(morigeratoSpregiudicataFiglioMorigerato < morigeratoSpregiudicataFiglioSpregiudicata) {
                    if(randomFiglio < (double) morigeratoSpregiudicataFiglioMorigerato / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato, Population.year, 0.0));
                    }
                    else if(randomFiglio >= (double) morigeratoSpregiudicataFiglioMorigerato / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata, Population.year, 0.0));
                    }
                }
                else if(morigeratoSpregiudicataFiglioMorigerato > morigeratoSpregiudicataFiglioSpregiudicata) {
                    if(randomFiglio < (double) morigeratoSpregiudicataFiglioSpregiudicata / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata, Population.year, 0.0));
                    }
                    else if(randomFiglio >= (double) morigeratoSpregiudicataFiglioSpregiudicata / 100) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato, Population.year, 0.0));
                    }
                }
                else if(morigeratoSpregiudicataFiglioMorigerato == morigeratoSpregiudicataFiglioSpregiudicata) {
                    if(randomFiglio < 0.5) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato, Population.year, 0.0));
                    }
                    else if(randomFiglio >= 0.5) {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata, Population.year, 0.0));
                    }
                }
            }
        }

        if(quantiSono <= 1 && exec != null) {
            exec.shutdown();
        }

    }


    @Override
    public synchronized List<PeopleFactory> getNuovaPopolazione()
    {
        return nuovaPopolazione;
    }

    @Override
    public synchronized void setNuovaPopolazione(List<PeopleFactory> nuovaPopolazione, ExecutorService exec) {
        this.nuovaPopolazione = nuovaPopolazione;

        quantiSono = nuovaPopolazione.size();

        if(exec != null) {
            this.exec = exec;
        }
    }


    public synchronized void setPercentAvventurieroSpregiudicata(int avventurieroSpregiudicataFiglioAvventuriero,
                                                    int avventurieroSpregiudicataFiglioSpregiudicata,
                                                    int morigeratoPrudenteFiglioMorigerato,
                                                    int morigeratoPrudenteFiglioPrudente,
                                                    int morigeratoSpregiudicataFiglioMorigerato,
                                                    int morigeratoSpregiudicataFiglioSpregiudicata) {
        this.avventurieroSpregiudicataFiglioAvventuriero = avventurieroSpregiudicataFiglioAvventuriero;
        this.avventurieroSpregiudicataFiglioSpregiudicata = avventurieroSpregiudicataFiglioSpregiudicata;

        this.morigeratoPrudenteFiglioMorigerato = morigeratoPrudenteFiglioMorigerato;
        this.morigeratoPrudenteFiglioPrudente = morigeratoPrudenteFiglioPrudente;

        this.morigeratoSpregiudicataFiglioMorigerato = morigeratoSpregiudicataFiglioMorigerato;
        this.morigeratoSpregiudicataFiglioSpregiudicata = morigeratoSpregiudicataFiglioSpregiudicata;

    }


}
