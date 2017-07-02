package Populations.Strategy;

import Humans.People;
import Humans.PeopleFactory;
import Populations.Population;

import java.util.List;
import java.util.concurrent.ExecutorService;



/** Strategia secondo la quale un figlio ha sempre sesso e carattere del genitore con un certo numero di hp.
 * Se entrambi i genitori hanno hp sopra una certa soglia, si generano due figli dall'accoppiamento.
 */

public class AverageGainStrategy implements MeetingStrategyFactory {



    private static List<PeopleFactory> nuovaPopolazione;

    private static int quantiSono = 0;

    private volatile ExecutorService exec;



    public AverageGainStrategy() {}





    @Override
    public synchronized void MeetingStrategy(PeopleFactory primaPersonaRandom, PeopleFactory secondaPersonaRandom,
                                               int a, int b, int c, int year) {
        quantiSono = quantiSono - 2;

        if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))) {

            int guadagnoPrudente = 0;
            int guadagnoAvventuriero = 0;



        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))) {

            int guadagnoAvventuriero = a;
            int guadagnoSpregiudicata = a - b;


            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > (0+a)/2 ) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + (guadagnoAvventuriero)));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > ((a-(b/2))+(a-b))/2  ) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + (guadagnoSpregiudicata));
                }
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > ((a-(b/2))+(a-b))/2 ) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + (guadagnoSpregiudicata));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > (0+a)/2 ) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + (guadagnoAvventuriero)));
                }
            }





        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))) {

            int guadagnoMorigerato = (a - (b / 2)) - c;
            int guadagnoPrudente = (a - (b / 2)) - c;

            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > (((a-(b/2))-c)+(a-(b/2)))/2  ) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + (guadagnoMorigerato)));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > (((a-(b/2))-c) + 0)/2  ) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + (guadagnoPrudente));
                }
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > (((a-(b/2))-c) + 0)/2 ) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + (guadagnoPrudente));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > (((a-(b/2))-c)+(a-(b/2)))/2 ) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + (guadagnoMorigerato)));
                }
            }





        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))) {


            int guadagnoMorigerato = a - (b / 2);
            int guadagnoSpregiudicata = a - (b / 2);


            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > (((a-(b/2))-c)+(a-(b/2)))/2 ) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + (guadagnoMorigerato)));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > ((a-(b/2))+(a-b))/2 ) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + (guadagnoSpregiudicata));
                }
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > ((a-(b/2))+(a-b))/2 ) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + (guadagnoSpregiudicata));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > (((a-(b/2))-c)+(a-(b/2)))/2 ) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), Population.year, 0.0));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + (guadagnoMorigerato)));
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
    public synchronized void setNuovaPopolazione(List<PeopleFactory> nuovaPopolazione, ExecutorService exec)
    {
        AverageGainStrategy.nuovaPopolazione = nuovaPopolazione;

        quantiSono = nuovaPopolazione.size();

        if(exec != null) {
            this.exec = exec;
        }
    }
}











































































































/**         MODELLO BASATO SU :     50 E 50
 *
 *          Morigerati: 193983 ovvero il 39.905411771482406 %       Punteggio in ottavi: 632 / 800   Deve essere 500/800
 *          Avventurieri: 49402 ovvero il 10.162783090965569 %       Punteggio in ottavi: 160 / 800   Deve essere 300/800
 *          Prudenti: 25415 ovvero il 5.228272787678432 %       Punteggio in sesti: 60 / 600   Deve essere 500/600
 *          Spregiudicate: 217307 ovvero il 44.70353234987358 %       Punteggio in sesti: 534 / 600   Deve essere 100/600
 *
 *
 *          30 giri     1000 persone iniziali
 *
 *          Morigerati: 192375 ovvero il 41.44190916062765 %       Punteggio in ottavi: 656 / 800   Deve essere 500/800
 *          Avventurieri: 39869 ovvero il 8.588680838596824 %       Punteggio in ottavi: 136 / 800   Deve essere 300/800
 *          Prudenti: 32196 ovvero il 6.935743767826215 %       Punteggio in sesti: 78 / 600   Deve essere 500/600
 *          Spregiudicate: 199764 ovvero il 43.03366623294931 %       Punteggio in sesti: 516 / 600   Deve essere 100/600
 * */

    /*
                if(randomFiglio<0.5)
                {
                    nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                }
                else if(randomFiglio>=0.5)
                {
                    nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente,0,0, year));
                }
     */






/**         MODELLO BASATO SU :     25 X 4
 *
 *          Morigerati: 102271 ovvero il 24.993890279189802 %       Punteggio in ottavi: 400 / 800   Deve essere 500/800
 *          Avventurieri: 102058 ovvero il 24.941835457886917 %       Punteggio in ottavi: 392 / 800   Deve essere 300/800
 *          Prudenti: 102594 ovvero il 25.07282787205756 %       Punteggio in sesti: 300 / 600   Deve essere 500/600
 *          Spregiudicate: 102261 ovvero il 24.991446390865725 %       Punteggio in sesti: 294 / 600   Deve essere 100/600
 *
 * */

    /*
                if(randomFiglio<0.5)
                {
                    if(randomFiglio<0.25)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero,0,0, year));
                    }
                    else if (randomFiglio>=0.25 && randomFiglio<0.5)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                    }
                }
                else if(randomFiglio>=0.5)
                {
                    if(randomFiglio>=0.5 && randomFiglio<0.75)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                    }
                    else if (randomFiglio>=0.75)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente,0,0, year));
                    }
                }
     */






/**         MODELLO BASATO SU :     VALORE DI 'a'
 *
 *          Morigerati: 53338 ovvero il 45.638743903482506 %       Punteggio in ottavi: 624 / 800   Deve essere 500/800
 *          Avventurieri: 14220 ovvero il 12.167365448789253 %       Punteggio in ottavi: 168 / 800   Deve essere 300/800
 *          Prudenti: 49008 ovvero il 41.933772567810394 %       Punteggio in sesti: 594 / 600   Deve essere 500/600
 *          Spregiudicate: 304 ovvero il 0.26011807991785746 %       Punteggio in sesti: 0 / 600   Deve essere 100/600
 *
 * */
                /*
                if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > a)
                {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                }
                else if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > a)
                {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                }
                */






/**         MODELLO BASATO SU :     CONFRONTO HP
 *
 *          Morigerati: 141795 ovvero il 44.854660082689854 %       Punteggio in ottavi: 608 / 800   Deve essere 500/800
 *          Avventurieri: 44599 ovvero il 14.108205402361754 %       Punteggio in ottavi: 184 / 800   Deve essere 300/800
 *          Prudenti: 27739 ovvero il 8.774804584320561 %       Punteggio in sesti: 126 / 600   Deve essere 500/600
 *          Spregiudicate: 101988 ovvero il 32.26232993062783 %       Punteggio in sesti: 468 / 600   Deve essere 100/600
 *
 * */

                 /*
                if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()
                        > nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp())
                {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                }
                else if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()
                        < nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp())
                {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                }
                else
                {
                    if(randomFiglio<0.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                    }
                    else if(randomFiglio>=0.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                    }
                }
     */





/**         MODELLO BASATO SU :     VALORE NEGATIVO DI 'b' E 'c'
 *
 *          Morigerati: 1620062 ovvero il 36.94823795579153 %         Punteggio in ottavi: 576 / 800   Deve essere 500/800
 *          Avventurieri: 626669 ovvero il 14.29224025470502 %        Punteggio in ottavi: 216 / 800   Deve essere 300/800
 *          Prudenti: 284171 ovvero il 6.480997473019697 %            Punteggio in sesti: 78 / 600   Deve essere 500/600
 *          Spregiudicate: 1853778 ovvero il 42.278524316483754 %     Punteggio in sesti: 516 / 600   Deve essere 100/600
 *
 * */

                /*
                if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()
                        > nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp())
                {
                    for(int i=0 ; i<20 ; i++)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                    }

                }
                else if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()
                        < nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp())
                {
                    for(int i=0 ; i<20 ; i++)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                    }
                }
                else
                {
                    if(randomFiglio<0.5)
                    {
                        for(int i=0 ; i<20 ; i++)
                        {
                            nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        }
                    }
                    else if(randomFiglio>=0.5)
                    {
                        for(int i=0 ; i<20 ; i++)
                        {
                            nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        }
                    }
                }

                int guadagnoMorigerato=-10;
                int guadagnoSpregiudicata=-10;

                int guadagnoMorigerato=-13;
                int guadagnoPrudente=-13;

                int guadagnoAvventuriero=0;
                int guadagnoSpregiudicata=-20;

                */






/**         MODELLO BASATO SU :     MEDIA GUADAGNI 6
 *
 *          Morigerati: 48410 ovvero il 42.780512376390746 %       Punteggio in ottavi: 544 / 800   Deve essere 500/800
 *          Avventurieri: 22353 ovvero il 19.75362101114361 %       Punteggio in ottavi: 248 / 800   Deve essere 300/800
 *          Prudenti: 41863 ovvero il 36.99484795729902 %       Punteggio in sesti: 588 / 600   Deve essere 500/600
 *          Spregiudicate: 533 ovvero il 0.47101865516662395 %       Punteggio in sesti: 6 / 600   Deve essere 100/600
 *
 * */

    /*
                if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 6)
                {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                }
                else if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 6)
                {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                }

                int guadagnoAvventuriero=15;
                int guadagnoSpregiudicata=-5;

                int guadagnoMorigerato=5;
                int guadagnoSpregiudicata=5;

                int guadagnoMorigerato=2;
                int guadagnoPrudente=2;

     */






/**         MODELLO BASATO SU :     MEDIA FIGLI PER INCONTRO
 *
 *
 *
 *
 *      1 000 iniziali
 *
 *      Morigerati: 81511 ovvero il 42.59429574741594 %       Punteggio in ottavi: 600 / 800   Deve essere 500/800
 *      Avventurieri: 26711 ovvero il 13.958069876571596 %       Punteggio in ottavi: 192 / 800   Deve essere 300/800
 *      Prudenti: 79790 ovvero il 41.69497193858888 %       Punteggio in sesti: 570 / 600   Deve essere 500/600
 *      Spregiudicate: 3354 ovvero il 1.7526624374235757 %       Punteggio in sesti: 24 / 600   Deve essere 100/600
 *
 *
 *      100 GIRI
 *
 *      Morigerati: 108252 ovvero il 41.345804958349405 %       Punteggio in ottavi: 544 / 800   Deve essere 500/800
 *      Avventurieri: 50456 ovvero il 19.271181456032938 %       Punteggio in ottavi: 248 / 800   Deve essere 300/800
 *      Prudenti: 96222 ovvero il 36.751062748977354 %       Punteggio in sesti: 558 / 600   Deve essere 500/600
 *      Spregiudicate: 6891 ovvero il 2.6319508366403 %       Punteggio in sesti: 36 / 600   Deve essere 100/600
 *
 *
 *
 *      10 000 iniziali
 *
 *      Morigerati: 50927 ovvero il 28.564777941060992 %       Punteggio in ottavi: 288 / 800   Deve essere 500/800
 *      Avventurieri: 90359 ovvero il 50.682050189022135 %       Punteggio in ottavi: 504 / 800   Deve essere 300/800
 *      Prudenti: 22436 ovvero il 12.584274704687973 %       Punteggio in sesti: 360 / 600   Deve essere 500/600
 *      Spregiudicate: 14564 ovvero il 8.168897165228902 %       Punteggio in sesti: 234 / 600   Deve essere 100/600
 *
 *
 *
 *
 *
 * Con morti :
 *
 Morigerati: 27978 ovvero il 40.6656976744186 %       Punteggio in ottavi: 520 / 800   Deve essere 500/800
 Avventurieri: 14769 ovvero il 21.46656976744186 %       Punteggio in ottavi: 272 / 800   Deve essere 300/800
 Prudenti: 24870 ovvero il 36.14825581395349 %       Punteggio in sesti: 570 / 600   Deve essere 500/600
 Spregiudicate: 1183 ovvero il 1.7194767441860463 %       Punteggio in sesti: 24 / 600   Deve essere 100/600
 *
 *
 *
 *
 *
 *
 *
 * 50 000 iniziali con morti:
 *
 Morigerati: 1460 ovvero il 41.08047270680923 %       Punteggio in ottavi: 520 / 800   Deve essere 500/800
 Avventurieri: 757 ovvero il 21.29994372537985 %       Punteggio in ottavi: 272 / 800   Deve essere 300/800
 Prudenti: 1272 ovvero il 35.79065841305571 %       Punteggio in sesti: 570 / 600   Deve essere 500/600
 Spregiudicate: 65 ovvero il 1.8289251547552055 %       Punteggio in sesti: 24 / 600   Deve essere 100/600
 *
 *
 *
 *
 *
 *
 *
 * 100 000 iniziali
 *
 Morigerati: 71911 ovvero il 28.786047107424785 %       Punteggio in ottavi: 392 / 800   Deve essere 500/800
 Avventurieri: 72303 ovvero il 28.942965109762543 %       Punteggio in ottavi: 400 / 800   Deve essere 300/800
 Prudenti: 52964 ovvero il 21.201543560757692 %       Punteggio in sesti: 300 / 600   Deve essere 500/600
 Spregiudicate: 52634 ovvero il 21.069444222054987 %       Punteggio in sesti: 294 / 600   Deve essere 100/600
 *
 *
 *
 *          differiscono anche con il modello 50 50 ? o 25 25
 *
 *          non penso, sarebbe meglio piu giri per la stabilità evolutiva !!!
 *
 * */


    /*
                    if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }






                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 1)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 1)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }






                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 7.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 7.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }
     */




/**         MODELLO BASATO SU :     RANGE TAB GUADAGNI
 *
 *          Morigerati: 316952 ovvero il 28.381617746480636 %       Punteggio in ottavi: 448 / 800   Deve essere 500/800
 *          Avventurieri: 241310 ovvero il 21.608218841979994 %       Punteggio in ottavi: 344 / 800   Deve essere 300/800
 *          Prudenti: 2495 ovvero il 0.2234159629138456 %       Punteggio in sesti: 0 / 600   Deve essere 500/600
 *          Spregiudicate: 555994 ovvero il 49.786747448625526 %       Punteggio in sesti: 594 / 600   Deve essere 100/600
 *
 * */

    /*
                for(int i = 0 ; i < new Random().nextInt(10) ; i++)
                {
                    double randomFiglio = Math.random();

                    if(randomFiglio<0.5)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                    }
                    else if(randomFiglio>=0.5)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                    }
                }

                for(int i = 0 ; i < new Random().nextInt(4) ; i++)
                {
                    double randomFiglio = Math.random();

                    if(randomFiglio<0.5)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                    }
                    else if(randomFiglio>=0.5)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente,0,0, year));
                    }
                }



                for(int i = 0 ; i < new Random().nextInt(10) ; i++)
                {
                    double randomFiglio = Math.random();

                    if(randomFiglio<0.5)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero,0,0, year));
                    }
                    else if(randomFiglio>=0.5)
                    {
                        nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                    }
                }
     */






/**         MODELLO BASATO SU :     FIGLIO RANDOMICO SOPRA SOGLIA DI HP MEDI
 *
 *          Morigerati: 486889 ovvero il 44.017618293806386 %       Punteggio in ottavi: 704 / 800   Deve essere 500/800
 *          Avventurieri: 64919 ovvero il 5.869057961908395 %       Punteggio in ottavi: 88 / 800   Deve essere 300/800
 *          Prudenti: 96141 ovvero il 8.69170969232174 %       Punteggio in sesti: 102 / 600   Deve essere 500/600
 *          Spregiudicate: 458174 ovvero il 41.42161405196348 %       Punteggio in sesti: 492 / 600   Deve essere 100/600
 *
 * */

    /*


                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }






                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 1)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 1)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Prudente,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }






                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 7.5)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-a);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 7.5)
                    {
                        double randomFiglio = Math.random();

                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Avventuriero,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        // levare a?? o qualcosaltro??
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-a);
                    }
                }
     */








/**         MODELLO BASATO SU :     TANTI CICLI CON HP SENZA AUMENTARE LA POPOLAZIONE
 *
 *          Morigerati:
 *          Avventurieri:
 *          Prudenti:
 *          Spregiudicate:
 *
 *
 *


 Gli hp medi dei Morigerati:        169 356
 Gli hp medi dei Avventurieri:      372 451
 Gli hp medi delle Prudenti:        55 473
 Gli hp medi delle Spregiudicate:   139 56


 169356 + 372451 = 541807
 55473 + 13956 = 69429

 Morigerati         31 %        2,48 / 8        SU  5 / 8
 Avventurieri       68 %        5,44 / 8        SU  3 / 8
 Prudenti           79 %        4,74 / 6        SU  5 / 6
 Spregiudicate      21 %        1,26 / 6        SU  1 / 6

 * */











/**         MODELLO BASATO SU :     HP SUPERANO UN CERTO X E POI CALANO DI X
 *
 *          Morigerati: 132655 ovvero il 40.98933050708673 %       Punteggio in ottavi: 768 / 800   Deve essere 500/800
 *          Avventurieri: 5513 ovvero il 1.7034727608124016 %       Punteggio in ottavi: 24 / 800   Deve essere 300/800
 *          Prudenti: 135343 ovvero il 41.81990093717266 %       Punteggio in sesti: 432 / 600   Deve essere 500/600
 *          Spregiudicate: 50122 ovvero il 15.487295794928205 %       Punteggio in sesti: 162 / 600   Deve essere 100/600
 *
 *
 * */











/**         MODELLO BASATO SU :     VALORI TAB MAPS
 *
 *          Morigerati: 293928 ovvero il 48.54133878098365 %       Punteggio in ottavi: 776 / 800   Deve essere 500/800
 *          Avventurieri: 6990 ovvero il 1.1543778002744742 %       Punteggio in ottavi: 16 / 800   Deve essere 300/800
 *          Prudenti: 67427 ovvero il 11.135369376124032 %       Punteggio in sesti: 132 / 600   Deve essere 500/600
 *          Spregiudicate: 237176 ovvero il 39.16891404261785 %       Punteggio in sesti: 462 / 600   Deve essere 100/600
 *
 *
 * */

/*
                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > Math.abs( (-b/2)) )
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()- Math.abs( (-b/2))) );
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > Math.abs( (-b/2)))
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()- Math.abs( (-b/2))) );
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > Math.abs( (-b/2)))
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()- Math.abs( (-b/2))) );
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > Math.abs( (-b/2)))
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()- Math.abs( (-b/2))) );
                    }
                }







                nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()+ a );
                nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()+ a );

 */


/**         MODELLO BASATO SU :     MEDIA GUADAGNO 12
 *
 *          200 giri     1000 persone iniziali
 *
 *
 *          Morigerati: 6301 ovvero il 15.833647443146123 %       Punteggio in ottavi: 136 / 800   Deve essere 500/800
 *          Avventurieri: 29344 ovvero il 73.73790677220757 %       Punteggio in ottavi: 656 / 800   Deve essere 300/800
 *          Prudenti: 3827 ovvero il 9.616786028395527 %       Punteggio in sesti: 552 / 600   Deve essere 500/600
 *          Spregiudicate: 323 ovvero il 0.8116597562507852 %       Punteggio in sesti: 42 / 600   Deve essere 100/600
 *
 *
 *          220 giri     1000 persone iniziali
 *
 *          Morigerati: 12604 ovvero il 23.247749741773646 %       Punteggio in ottavi: 224 / 800   Deve essere 500/800
 *          Avventurieri: 32212 ovvero il 59.41419507156559 %       Punteggio in ottavi: 568 / 800   Deve essere 300/800
 *          Prudenti: 9058 ovvero il 16.707245093699278 %       Punteggio in sesti: 576 / 600   Deve essere 500/600
 *          Spregiudicate: 342 ovvero il 0.6308100929614874 %       Punteggio in sesti: 18 / 600   Deve essere 100/600
 *
 *
 *          240 giri     1000 persone iniziali
 *
 *          Morigerati: 13195 ovvero il 22.48291843445961 %       Punteggio in ottavi: 216 / 800   Deve essere 500/800
 *          Avventurieri: 35525 ovvero il 60.530934246622024 %       Punteggio in ottavi: 576 / 800   Deve essere 300/800
 *          Prudenti: 9635 ovvero il 16.417045783707337 %       Punteggio in sesti: 576 / 600   Deve essere 500/600
 *          Spregiudicate: 334 ovvero il 0.5691015352110277 %       Punteggio in sesti: 18 / 600   Deve essere 100/600
 *
 *
 *          280 giri     1000 persone iniziali
 *
 *          Morigerati: 230220 ovvero il 47.44593241087658 %       Punteggio in ottavi: 704 / 800   Deve essere 500/800
 *          Avventurieri: 31099 ovvero il 6.409178403465601 %       Punteggio in ottavi: 88 / 800   Deve essere 300/800
 *          Prudenti: 223578 ovvero il 46.077085729124164 %       Punteggio in sesti: 594 / 600   Deve essere 500/600
 *          Spregiudicate: 329 ovvero il 0.06780345653365648 %       Punteggio in sesti: 0 / 600   Deve essere 100/600
 *
 *
 *
 *
 *
 *
 *
 * */

/*
        CODICE UGUALE AL SOLITO
 */



/**         MODELLO BASATO SU :     MEDIA GUADAGNO 3
 *
 *
 *          80 giri     1000 persone iniziali
 *
 *          Morigerati: 33448 ovvero il 34.8769068746546 %       Punteggio in ottavi: 344 / 800   Deve essere 500/800
 *          Avventurieri: 43173 ovvero il 45.01736129213893 %       Punteggio in ottavi: 448 / 800   Deve essere 300/800
 *          Prudenti: 16192 ovvero il 16.88372626508034 %       Punteggio in sesti: 498 / 600   Deve essere 500/600
 *          Spregiudicate: 3090 ovvero il 3.2220055681261273 %       Punteggio in sesti: 96 / 600   Deve essere 100/600
 *
 *
 *          90 giri     1000 persone iniziali
 *
 *          Morigerati: 47219 ovvero il 36.71173447570769 %       Punteggio in ottavi: 376 / 800   Deve essere 500/800
 *          Avventurieri: 51794 ovvero il 40.268696402609216 %       Punteggio in ottavi: 416 / 800   Deve essere 300/800
 *          Prudenti: 26798 ovvero il 20.834855894449582 %       Punteggio in sesti: 540 / 600   Deve essere 500/600
 *          Spregiudicate: 2810 ovvero il 2.1847132272335 %       Punteggio in sesti: 54 / 600   Deve essere 100/600
 *
 *
 *          100 giri     1000 persone iniziali
 *
 *          Morigerati: 102134 ovvero il 42.268583087434976 %       Punteggio in ottavi: 488 / 800   Deve essere 500/800
 *          Avventurieri: 63835 ovvero il 26.41838174737513 %       Punteggio in ottavi: 304 / 800   Deve essere 300/800
 *          Prudenti: 70367 ovvero il 29.12167726823131 %       Punteggio in sesti: 558 / 600   Deve essere 500/600
 *          Spregiudicate: 5295 ovvero il 2.1913578969585856 %       Punteggio in sesti: 36 / 600   Deve essere 100/600
 *
 *
 *          110 giri     1000 persone iniziali
 *
 *          Morigerati: 228818 ovvero il 44.871201543698916 %       Punteggio in ottavi: 560 / 800   Deve essere 500/800
 *          Avventurieri: 94317 ovvero il 18.495560296816905 %       Punteggio in ottavi: 232 / 800   Deve essere 300/800
 *          Prudenti: 168012 ovvero il 32.947147137724926 %       Punteggio in sesti: 534 / 600   Deve essere 500/600
 *          Spregiudicate: 18797 ovvero il 3.6860910217592515 %       Punteggio in sesti: 60 / 600   Deve essere 100/600
 *
 *
 *
 *
 *
 * */

/*
        CODICE UGUALE AL SOLITO
 */





/**         MODELLO BASATO SU :     HP MEDIA 12 CON FIGLI RANDOMICI
 *
 *
 *          Morigerati: 6396 ovvero il 1.6150291644572383 %       Punteggio in ottavi: 24 / 800   Deve essere 500/800
 *          Avventurieri: 192013 ovvero il 48.48445824811252 %       Punteggio in ottavi: 768 / 800   Deve essere 300/800
 *          Prudenti: 581 ovvero il 0.1467060576218973 %       Punteggio in sesti: 0 / 600   Deve essere 500/600
 *          Spregiudicate: 197040 ovvero il 49.75380652980835 %       Punteggio in sesti: 594 / 600   Deve essere 100/600
 *
 *
 * */

/*

                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 12)
                    {
                        double randomFiglio = Math.random();
                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-12);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 12)
                    {
                        double randomFiglio = Math.random();
                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-12);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 12)
                    {
                        double randomFiglio = Math.random();
                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-12);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 12)
                    {
                        double randomFiglio = Math.random();
                        if(randomFiglio<0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Morigerato,0,0, year));
                        }
                        else if(randomFiglio>=0.5)
                        {
                            nuovaPopolazione.add(new People(PeopleFactory.Behaviour.Spregiudicata,0,0, year));
                        }

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-12);
                    }
                }
 */



/**         MODELLO BASATO SU :     FIGLIO HP MEDI CON RIDUZIONE 3
 *
 *          Morigerati: 119358 ovvero il 45.2125624543075 %       Punteggio in ottavi: 672 / 800   Deve essere 500/800
 *          Avventurieri: 22649 ovvero il 8.579394150602477 %       Punteggio in ottavi: 120 / 800   Deve essere 300/800
 *          Prudenti: 26825 ovvero il 10.161254275681554 %       Punteggio in sesti: 126 / 600   Deve essere 500/600
 *          Spregiudicate: 95161 ovvero il 36.046789119408466 %       Punteggio in sesti: 468 / 600   Deve essere 100/600
 *
 * */


    /*


                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-3);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-3);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-3);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-3);
                    }
                }
     */


/**         MODELLO BASATO SU :     MEDIA HP PERSONA PIU DECREMENTO DI ESSI
 *
 *          Morigerati: 178066 ovvero il 42.10842447531776 %       Punteggio in ottavi: 720 / 800   Deve essere 500/800
 *          Avventurieri: 18405 ovvero il 4.3523499852202185 %       Punteggio in ottavi: 72 / 800   Deve essere 300/800
 *          Prudenti: 112934 ovvero il 26.706237067691397 %       Punteggio in sesti: 294 / 600   Deve essere 500/600
 *          Spregiudicate: 113470 ovvero il 26.83298847177062 %       Punteggio in sesti: 300 / 600   Deve essere 100/600
 *
 * */


    /*

                    if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-3.5));
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-0);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-0);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-3.5));
                    }
                }

     */





/**         MODELLO BASATO SU :     SUPERAMENTO MEDIA HP PIU DECREMENTO DI UN VALORE X
 *
 *
 *          VALORE X 50     CON 150 GIRI
 *
 *          Morigerati: 27613 ovvero il 39.85652632034757 %       Punteggio in ottavi: 496 / 800   Deve essere 500/800
 *          Avventurieri: 16917 ovvero il 24.41795008732553 %       Punteggio in ottavi: 296 / 800   Deve essere 300/800
 *          Prudenti: 23480 ovvero il 33.89096577705287 %       Punteggio in sesti: 564 / 600   Deve essere 500/600
 *          Spregiudicate: 1271 ovvero il 1.834557815274029 %       Punteggio in sesti: 30 / 600   Deve essere 100/600
 *
 *
 *
 *          VALORE X 100     CON 200 GIRI
 *
 *          Morigerati: 26269 ovvero il 37.54108668934176 %       Punteggio in ottavi: 416 / 800   Deve essere 500/800
 *          Avventurieri: 23478 ovvero il 33.55246234315603 %       Punteggio in ottavi: 376 / 800   Deve essere 300/800
 *          Prudenti: 17914 ovvero il 25.60093749106811 %       Punteggio in sesti: 528 / 600   Deve essere 500/600
 *          Spregiudicate: 2313 ovvero il 3.305513476434104 %       Punteggio in sesti: 66 / 600   Deve essere 100/600
 *
 *
 *          VALORE X 200     CON 250 GIRI
 *
 *          Morigerati: 21272 ovvero il 32.91605415860735 %       Punteggio in ottavi: 320 / 800   Deve essere 500/800
 *          Avventurieri: 31352 ovvero il 48.513733075435205 %       Punteggio in ottavi: 472 / 800   Deve essere 300/800
 *          Prudenti: 8893 ovvero il 13.760928433268859 %       Punteggio in sesti: 444 / 600   Deve essere 500/600
 *          Spregiudicate: 3108 ovvero il 4.809284332688589 %       Punteggio in sesti: 150 / 600   Deve essere 100/600
 *
 *
 *          VALORE X 10     CON 70 GIRI
 *
 *          Morigerati: 144685 ovvero il 35.63950853269223 %       Punteggio in ottavi: 376 / 800   Deve essere 500/800
 *          Avventurieri: 160626 ovvero il 39.566172703267256 %       Punteggio in ottavi: 416 / 800   Deve essere 300/800
 *          Prudenti: 60997 ovvero il 15.025075868048713 %       Punteggio in sesti: 360 / 600   Deve essere 500/600
 *          Spregiudicate: 39660 ovvero il 9.769242895991802 %       Punteggio in sesti: 234 / 600   Deve essere 100/600
 *
 *
 *
 *
 *
 *
 *
 *          VALORE X -23 sarebbe -(b+c)     CON 120 GIRI
 *
 *
 *          Morigerati: 78859 ovvero il 42.20150591609896 %       Punteggio in ottavi: 560 / 800   Deve essere 500/800
 *          Avventurieri: 33444 ovvero il 17.89760412708776 %       Punteggio in ottavi: 232 / 800   Deve essere 300/800
 *          Prudenti: 69474 ovvero il 37.17910982912615 %       Punteggio in sesti: 558 / 600   Deve essere 500/600
 *          Spregiudicate: 5086 ovvero il 2.721780127687129 %       Punteggio in sesti: 36 / 600   Deve essere 100/600
 *
 *
 *          VALORE X -23 sarebbe -(b+c)     CON 130 GIRI
 *
 *          Morigerati: 177918 ovvero il 42.37535190133901 %       Punteggio in ottavi: 568 / 800   Deve essere 500/800
 *          Avventurieri: 72591 ovvero il 17.289252182860082 %       Punteggio in ottavi: 224 / 800   Deve essere 300/800
 *          Prudenti: 148882 ovvero il 35.45974629759302 %       Punteggio in sesti: 522 / 600   Deve essere 500/600
 *          Spregiudicate: 20471 ovvero il 4.875649618207888 %       Punteggio in sesti: 72 / 600   Deve essere 100/600
 *
 *
 *
 *
 * */

    /*

                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-50));
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-50);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-50);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-50));
                    }
                }





                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-50));
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 1)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-50);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 1)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-50);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-50));
                    }
                }



                 if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 7.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-50));
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-50);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-50);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 7.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-50));
                    }
                }
     */



/**         MODELLO BASATO SU :     SUPERAMENTO MEDIA HP PIU DECREMENTO DI UN VALORE X
 *
 *
 *          VALORE X -23 sarebbe -(b+c)     CON 1000 GIRI   E 5% MORTI OGNI BEHAVIOUR OGNI GIRO
 *
 *          Morigerati: 1182 ovvero il 46.280344557556774 %       Punteggio in ottavi: 528 / 800   Deve essere 500/800
 *          Avventurieri: 605 ovvero il 23.688332028191073 %       Punteggio in ottavi: 264 / 800   Deve essere 300/800
 *          Prudenti: 662 ovvero il 25.92012529365701 %       Punteggio in sesti: 516 / 600   Deve essere 500/600
 *          Spregiudicate: 105 ovvero il 4.111198120595145 %       Punteggio in sesti: 78 / 600   Deve essere 100/600
 *
 *
 *
 *          VALORE X -23 sarebbe -(b+c)     CON 1100 GIRI   E 5% MORTI OGNI BEHAVIOUR OGNI GIRO
 *
 *          Morigerati: 935 ovvero il 46.56374501992032 %       Punteggio in ottavi: 552 / 800   Deve essere 500/800
 *          Avventurieri: 414 ovvero il 20.617529880478088 %       Punteggio in ottavi: 240 / 800   Deve essere 300/800
 *          Prudenti: 621 ovvero il 30.926294820717132 %       Punteggio in sesti: 564 / 600   Deve essere 500/600
 *          Spregiudicate: 38 ovvero il 1.8924302788844622 %       Punteggio in sesti: 30 / 600   Deve essere 100/600
 *
 *
 *
 *
 *
 *
 *
 *
 *          VALORE X -23 sarebbe -(b+c)     CON 120 GIRI   E MORTI A 100 ANNI
 *
 *          Morigerati: 68692 ovvero il 42.33687311634443 %       Punteggio in ottavi: 560 / 800   Deve essere 500/800
 *          Avventurieri: 28650 ovvero il 17.657826454074243 %       Punteggio in ottavi: 232 / 800   Deve essere 300/800
 *          Prudenti: 61929 ovvero il 38.168639946749174 %       Punteggio in sesti: 570 / 600   Deve essere 500/600
 *          Spregiudicate: 2980 ovvero il 1.836660482832155 %       Punteggio in sesti: 24 / 600   Deve essere 100/600
 *
 *          Morigerati: 80334 ovvero il 38.18428119875467 %       Punteggio in ottavi: 432 / 800   Deve essere 500/800
 *          Avventurieri: 65783 ovvero il 31.26791358699527 %       Punteggio in ottavi: 360 / 800   Deve essere 300/800
 *          Prudenti: 60499 ovvero il 28.756327684958528 %       Punteggio in sesti: 564 / 600   Deve essere 500/600
 *          Spregiudicate: 3769 ovvero il 1.791477529291537 %       Punteggio in sesti: 30 / 600   Deve essere 100/600
 *
 *          Morigerati: 90344 ovvero il 42.33135445902699 %       Punteggio in ottavi: 560 / 800   Deve essere 500/800
 *          Avventurieri: 38521 ovvero il 18.04930161511754 %       Punteggio in ottavi: 232 / 800   Deve essere 300/800
 *          Prudenti: 77755 ovvero il 36.43268469363371 %       Punteggio in sesti: 546 / 600   Deve essere 500/600
 *          Spregiudicate: 6801 ovvero il 3.1866592322217593 %       Punteggio in sesti: 48 / 600   Deve essere 100/600
 *
 *
 *          VALORE X -23 sarebbe -(b+c)     CON 130 GIRI   E MORTI A 100 ANNI      :)
 *
 *          Morigerati: 147395 ovvero il 41.99838155427777 %       Punteggio in ottavi: 544 / 800   Deve essere 500/800
 *          Avventurieri: 67284 ovvero il 19.17174330539045 %       Punteggio in ottavi: 248 / 800   Deve essere 300/800
 *          Prudenti: 125703 ovvero il 35.817514546065865 %       Punteggio in sesti: 552 / 600   Deve essere 500/600
 *          Spregiudicate: 10572 ovvero il 3.0123605942659153 %       Punteggio in sesti: 42 / 600   Deve essere 100/600
 *
 *
 *          Morigerati: 110467 ovvero il 42.35616648453826 %       Punteggio in ottavi: 568 / 800   Deve essere 500/800
 *          Avventurieri: 44657 ovvero il 17.122754548417397 %       Punteggio in ottavi: 224 / 800   Deve essere 300/800
 *          Prudenti: 101906 ovvero il 39.07363739192117 %       Punteggio in sesti: 576 / 600   Deve essere 500/600
 *          Spregiudicate: 3775 ovvero il 1.4474415751231764 %       Punteggio in sesti: 18 / 600   Deve essere 100/600
 *
 *
 **/










/**         MODELLO BASATO SU :     SUPERAMENTO MEDIA HP PIU DECREMENTO DI UN VALORE X
 *                                  VALORE X -23 sarebbe -(b+c)
 *                                  CON ANNI DI STOP 23 CHE SI DECREMENTANO OGNI ANNO FINO A 0 CHE PUO FIGLIARE DI NUOVO
 *
 *
 *          80 GIRI         FIGLIANO SOLO I FIGLI, I GENITORI SONO IL STOP PERENNE
 *
 *          Morigerati: 5606 ovvero il 35.716106014271155 %       Punteggio in ottavi: 408 / 800   Deve essere 500/800
 *          Avventurieri: 5281 ovvero il 33.64551478083588 %       Punteggio in ottavi: 384 / 800   Deve essere 300/800
 *          Prudenti: 3881 ovvero il 24.72604485219164 %       Punteggio in sesti: 480 / 600   Deve essere 500/600
 *          Spregiudicate: 928 ovvero il 5.9123343527013255 %       Punteggio in sesti: 114 / 600   Deve essere 100/600
 *
 *
 *
 *          100 GIRI         FIGLIANO SOLO I FIGLI, I GENITORI SONO IL STOP PERENNE
 *
 *          Morigerati: 8407 ovvero il 39.923069617247606 %       Punteggio in ottavi: 464 / 800   Deve essere 500/800
 *          Avventurieri: 6021 ovvero il 28.59245892297464 %       Punteggio in ottavi: 328 / 800   Deve essere 300/800
 *          Prudenti: 5873 ovvero il 27.88963814227372 %       Punteggio in sesti: 528 / 600   Deve essere 500/600
 *          Spregiudicate: 757 ovvero il 3.5948333175040363 %       Punteggio in sesti: 66 / 600   Deve essere 100/600
 *
 *
 *          120 GIRI         FIGLIANO SOLO I FIGLI, I GENITORI SONO IL STOP PERENNE
 *
 *          Morigerati: 15298 ovvero il 43.9130809197118 %       Punteggio in ottavi: 560 / 800   Deve essere 500/800
 *          Avventurieri: 6288 ovvero il 18.04977466486781 %       Punteggio in ottavi: 232 / 800   Deve essere 300/800
 *          Prudenti: 12648 ovvero il 36.30622613887534 %       Punteggio in sesti: 570 / 600   Deve essere 500/600
 *          Spregiudicate: 603 ovvero il 1.7309182765450526 %       Punteggio in sesti: 24 / 600   Deve essere 100/600
 *
 *
 *          150 GIRI         FIGLIANO SOLO I FIGLI, I GENITORI SONO IL STOP PERENNE
 *
 *          Morigerati: 23164 ovvero il 44.874949146632055 %       Punteggio in ottavi: 656 / 800   Deve essere 500/800
 *          Avventurieri: 5001 ovvero il 9.68829307038106 %       Punteggio in ottavi: 136 / 800   Deve essere 300/800
 *          Prudenti: 23237 ovvero il 45.01636994130068 %       Punteggio in sesti: 594 / 600   Deve essere 500/600
 *          Spregiudicate: 217 ovvero il 0.4203878416862008 %       Punteggio in sesti: 0 / 600   Deve essere 100/600
 *
 *
 *          NON VA BENE I VALORI NON CONVERGONO
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *          100 GIRI         I GENITORI SI SVEGLIANO DALLO STOP DOPO 23 ANNI
 *
 *          Morigerati: 38903 ovvero il 45.16357472892336 %       Punteggio in ottavi: 560 / 800   Deve essere 500/800
 *          Avventurieri: 16491 ovvero il 19.1448605725696 %       Punteggio in ottavi: 232 / 800   Deve essere 300/800
 *          Prudenti: 24268 ovvero il 28.17339617822564 %       Punteggio in sesti: 468 / 600   Deve essere 500/600
 *          Spregiudicate: 6476 ovvero il 7.518168520281408 %       Punteggio in sesti: 126 / 600   Deve essere 100/600
 *
 *
 *          110 GIRI         I GENITORI SI SVEGLIANO DALLO STOP DOPO 23 ANNI
 *
 *          Morigerati: 42586 ovvero il 46.044892310353774 %       Punteggio in ottavi: 616 / 800   Deve essere 500/800
 *          Avventurieri: 12295 ovvero il 13.293616469163567 %       Punteggio in ottavi: 176 / 800   Deve essere 300/800
 *          Prudenti: 33523 ovvero il 36.24578323674423 %       Punteggio in sesti: 534 / 600   Deve essere 500/600
 *          Spregiudicate: 4084 ovvero il 4.4157079837384305 %       Punteggio in sesti: 60 / 600   Deve essere 100/600
 *
 *
 *          120 GIRI         I GENITORI SI SVEGLIANO DALLO STOP DOPO 23 ANNI
 *
 *          Morigerati: 72798 ovvero il 45.92151494698064 %       Punteggio in ottavi: 616 / 800   Deve essere 500/800
 *          Avventurieri: 20835 ovvero il 13.142871561311322 %       Punteggio in ottavi: 176 / 800   Deve essere 300/800
 *          Prudenti: 55485 ovvero il 35.000346944053696 %       Punteggio in sesti: 510 / 600   Deve essere 500/600
 *          Spregiudicate: 9409 ovvero il 5.935266547654343 %       Punteggio in sesti: 84 / 600   Deve essere 100/600
 *
 *
 *          130 GIRI         I GENITORI SI SVEGLIANO DALLO STOP DOPO 23 ANNI
 *
 *          Morigerati: 100991 ovvero il 46.06013892246156 %       Punteggio in ottavi: 640 / 800   Deve essere 500/800
 *          Avventurieri: 24188 ovvero il 11.031702233431695 %       Punteggio in ottavi: 152 / 800   Deve essere 300/800
 *          Prudenti: 82184 ovvero il 37.482611888223516 %       Punteggio in sesti: 522 / 600   Deve essere 500/600
 *          Spregiudicate: 11896 ovvero il 5.425546955883225 %       Punteggio in sesti: 72 / 600   Deve essere 100/600
 *
 **/

/*



                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5 && nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0 && nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0 && nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5 && nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                }





                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5  && nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 1  && nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 1  && nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5  && nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                }





                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 7.5 && nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0 && nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0  && nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 7.5  && nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getStop()==0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year,0));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()-23);

                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setStop(23);
                    }
                }
 */




/**         MODELLO BASATO SU :     SUPERAMENTO MEDIA HP PIU DECREMENTO DI UN VALORE X
 *                                  VALORE X -23 sarebbe -(b+c) +- GUADAGNO MAPS
 *
 *
 *          110 GIRI         CON MORTI A 40 ANNI
 *
 *          Morigerati: 35185 ovvero il 37.40299776761986 %       Punteggio in ottavi: 400 / 800   Deve essere 500/800
 *          Avventurieri: 35161 ovvero il 37.37748485170618 %       Punteggio in ottavi: 392 / 800   Deve essere 300/800
 *          Prudenti: 15495 ovvero il 16.471776336770493 %       Punteggio in sesti: 390 / 600   Deve essere 500/600
 *          Spregiudicate: 8229 ovvero il 8.747741043903476 %       Punteggio in sesti: 204 / 600   Deve essere 100/600
 *
 *
 *
 *
 *          100 GIRI         CON MORTI A 50 ANNI
 *
 *          Morigerati: 55601 ovvero il 37.99699309779266 %       Punteggio in ottavi: 424 / 800   Deve essere 500/800
 *          Avventurieri: 48684 ovvero il 33.27000615048179 %       Punteggio in ottavi: 368 / 800   Deve essere 300/800
 *          Prudenti: 23883 ovvero il 16.32132850406615 %       Punteggio in sesti: 336 / 600   Deve essere 500/600
 *          Spregiudicate: 18162 ovvero il 12.4116722476594 %       Punteggio in sesti: 258 / 600   Deve essere 100/600
 *
 *
 *          Morigerati: 38776 ovvero il 40.22406639004149 %       Punteggio in ottavi: 480 / 800   Deve essere 500/800
 *          Avventurieri: 25353 ovvero il 26.29979253112033 %       Punteggio in ottavi: 312 / 800   Deve essere 300/800
 *          Prudenti: 21030 ovvero il 21.815352697095435 %       Punteggio in sesti: 390 / 600   Deve essere 500/600
 *          Spregiudicate: 11241 ovvero il 11.660788381742739 %       Punteggio in sesti: 204 / 600   Deve essere 100/600
 *
 *          Morigerati: 63775 ovvero il 38.58486856036543 %       Punteggio in ottavi: 440 / 800   Deve essere 500/800
 *          Avventurieri: 50190 ovvero il 30.36573191759688 %       Punteggio in ottavi: 352 / 800   Deve essere 300/800
 *          Prudenti: 26254 ovvero il 15.884079015034638 %       Punteggio in sesti: 306 / 600   Deve essere 500/600
 *          Spregiudicate: 25066 ovvero il 15.165320507003056 %       Punteggio in sesti: 288 / 600   Deve essere 100/600
 *
 *          Morigerati: 51168 ovvero il 39.121957932885294 %       Punteggio in ottavi: 456 / 800   Deve essere 500/800
 *          Avventurieri: 38520 ovvero il 29.45156776842443 %       Punteggio in ottavi: 336 / 800   Deve essere 300/800
 *          Prudenti: 23197 ovvero il 17.735929842267435 %       Punteggio in sesti: 336 / 600   Deve essere 500/600
 *          Spregiudicate: 17906 ovvero il 13.690544456422844 %       Punteggio in sesti: 258 / 600   Deve essere 100/600
 *
 *          110 GIRI         CON MORTI A 50 ANNI
 *
 *          Morigerati: 67076 ovvero il 39.21357707844937 %       Punteggio in ottavi: 448 / 800   Deve essere 500/800
 *          Avventurieri: 51444 ovvero il 30.074889069469695 %       Punteggio in ottavi: 344 / 800   Deve essere 300/800
 *          Prudenti: 32348 ovvero il 18.911097729943354 %       Punteggio in sesti: 366 / 600   Deve essere 500/600
 *          Spregiudicate: 20185 ovvero il 11.800436122137583 %       Punteggio in sesti: 228 / 600   Deve essere 100/600
 *
 *
 *          120 GIRI         CON MORTI A 50 ANNI
 *
 *          Morigerati: 120913 ovvero il 37.87253768836351 %       Punteggio in ottavi: 416 / 800   Deve essere 500/800
 *          Avventurieri: 109025 ovvero il 34.14896182770944 %       Punteggio in ottavi: 376 / 800   Deve essere 300/800
 *          Prudenti: 52985 ovvero il 16.596035243670578 %       Punteggio in sesti: 354 / 600   Deve essere 500/600
 *          Spregiudicate: 36340 ovvero il 11.382465240256465 %       Punteggio in sesti: 240 / 600   Deve essere 100/600
 *
 *          Morigerati :            In aumento piu dei avventurieri
 *          Avventurieri :          In aumento meno dei morigerati
 *          Prudenti :              In aumento piu delle spregiudicate
 *          Spregiudicate :         In aumento meno delle prudenti
 *
 *
 *
 *
 *
 *
 *
 *
 *          100 GIRI         CON MORTI A 60 ANNI
 *
 *
 *          Morigerati: 69894 ovvero il 37.186560612912665 %       Punteggio in ottavi: 400 / 800   Deve essere 500/800
 *          Avventurieri: 68053 ovvero il 36.20707084142481 %       Punteggio in ottavi: 392 / 800   Deve essere 300/800
 *          Prudenti: 27135 ovvero il 14.436966295123831 %       Punteggio in sesti: 324 / 600   Deve essere 500/600
 *          Spregiudicate: 22873 ovvero il 12.169402250538692 %       Punteggio in sesti: 270 / 600   Deve essere 100/600
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *          100 GIRI         CON MORTI A 80 ANNI
 *
 *
 *          Morigerati: 102597 ovvero il 38.07193059276686 %       Punteggio in ottavi: 432 / 800   Deve essere 500/800
 *          Avventurieri: 84993 ovvero il 31.53939780764578 %       Punteggio in ottavi: 360 / 800   Deve essere 300/800
 *          Prudenti: 37953 ovvero il 14.08368647998753 %       Punteggio in sesti: 276 / 600   Deve essere 500/600
 *          Spregiudicate: 43939 ovvero il 16.304985119599824 %       Punteggio in sesti: 318 / 600   Deve essere 100/600
 *
 *          Morigerati: 89749 ovvero il 37.32791535306986 %       Punteggio in ottavi: 408 / 800   Deve essere 500/800
 *          Avventurieri: 85106 ovvero il 35.39682407646173 %       Punteggio in ottavi: 384 / 800   Deve essere 300/800
 *          Prudenti: 33692 ovvero il 14.012993170683014 %       Punteggio in sesti: 306 / 600   Deve essere 500/600
 *          Spregiudicate: 31887 ovvero il 13.262267399785388 %       Punteggio in sesti: 288 / 600   Deve essere 100/600
 *
 *
 **/


/*

                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 7.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()- (23+15)));
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()- (23-5) );
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()- (23-5) );
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 7.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()- (23+15)));
                    }
                }




                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()- (23+2)));
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 1)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()- (23+2) );
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 1)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()- (23+2) );
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()- (23+2)));
                    }
                }



                if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()- (23+5) ));
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()- (23+5) );
                    }
                }
                else if(primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                        secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) )
                {
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0)
                    {
                        nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp()- (23+5) );
                    }
                    if(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5)
                    {
                        nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(),0,0, year));
                        nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp()- (23+5) ));
                    }
                }
 */






/*
if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))) {

            int guadagnoPrudente = 0;

            int guadagnoAvventuriero = 0;


        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero))) {



            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 7.5) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() - (23 + 15)));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() - (23 - 5));
                }
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() - (23 - 5));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 7.5) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() - (23 + 15)));
                }
            }



            int guadagnoAvventuriero = a;
            int guadagnoSpregiudicata = a - b;


            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + guadagnoAvventuriero);
                nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + guadagnoSpregiudicata);
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero)) {
                nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + guadagnoSpregiudicata);
                nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + guadagnoAvventuriero);
            }


        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))) {
            //System.out.println("Si sono incontrati: "+PeopleFactory.Behaviour.Morigerato+" "+PeopleFactory.Behaviour.Prudente+"-> "+primaPersonaRandom.getBehaviour()+"-> "+secondaPersonaRandom.getBehaviour());



            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() - (23 + 2)));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 1) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() - (23 + 2));
                }
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 1) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() - (23 + 2));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() - (23 + 2)));
                }
            }


            int guadagnoMorigerato = (a - (b / 2)) - c;
            int guadagnoPrudente = (a - (b / 2)) - c;


            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) {
                nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + guadagnoMorigerato);
                nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + guadagnoPrudente);
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Prudente) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + guadagnoPrudente);
                nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + guadagnoMorigerato);
            }


        } else if ((primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) ||
                (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato))) {
            //System.out.println("Si sono incontrati: "+PeopleFactory.Behaviour.Morigerato+" "+PeopleFactory.Behaviour.Spregiudicata+"-> "+primaPersonaRandom.getBehaviour()+"-> "+secondaPersonaRandom.getBehaviour());



            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 3.5) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() - (23 + 5)));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 0) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() - (23 + 5));
                }
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() > 0) {
                    nuovaPopolazione.add(new People(primaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() - (23 + 5));
                }
                if (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() > 3.5) {
                    nuovaPopolazione.add(new People(secondaPersonaRandom.getBehaviour(), 0, 0, year));
                    nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp((float) (nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() - (23 + 5)));
                }
            }


            int guadagnoMorigerato = a - (b / 2);
            int guadagnoSpregiudicata = a - (b / 2);


            if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + guadagnoMorigerato);
                nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + guadagnoSpregiudicata);
            } else if (primaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) &&
                    secondaPersonaRandom.getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(primaPersonaRandom)).getHp() + guadagnoSpregiudicata);
                nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).setHp(nuovaPopolazione.get(nuovaPopolazione.indexOf(secondaPersonaRandom)).getHp() + guadagnoMorigerato);
            }


        }

 */





