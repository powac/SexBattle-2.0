package Populations;

import Humans.PeopleFactory;
import java.util.List;



/**
 *      La morte in % di ogni Behaviour della popolazione passata
 *
 *      Ogni Behaviour alla fine sarà diminuito della % scelta
 *      e la nuova popolazione sarà formata dai Behaviour iniziali
 *      diminuiti della % scelta.
 *
 */

public class DeadPercentage {



    private static List<PeopleFactory> popolazionePassata;



    public DeadPercentage(List<PeopleFactory> popolazionePassata) {
        if(popolazionePassata == null) {
            throw new NullPointerException("Popolazione passata in DeadPercentage nulla!");
        }
        DeadPercentage.popolazionePassata = popolazionePassata;
    }





    /**
     * Imposta la popolazione di persone
     *
     * @param percentageDeathBehaviour lista delle persone che formeranno la nuova popolazione dopo la morte
     *
     * @throws IllegalStateException se percentageDeathBehaviour ha valore negativo
     *
     * @return
     *          La lista delle persone che formeranno la nuova popolazione dopo la morte.
     */

    public synchronized List<PeopleFactory> afterDeath(int percentageDeathBehaviour) {
        if(percentageDeathBehaviour < 0) {
            throw new IllegalStateException("La % della popolazione da eliminare è negativa");
        }

        int morigeratiNumero = 0;
        int avventurieriNumero = 0;
        int prudentiNumero = 0;
        int spregiudicateNumero = 0;

        for(int i = 0; i < popolazionePassata.size(); i++) {
            if(popolazionePassata.get(i).getBehaviour().equals(PeopleFactory.Behaviour.Morigerato)) {
                morigeratiNumero++;
            }
            if(popolazionePassata.get(i).getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero)) {
                avventurieriNumero++;
            }
            if(popolazionePassata.get(i).getBehaviour().equals(PeopleFactory.Behaviour.Prudente)) {
                prudentiNumero++;
            }
            if(popolazionePassata.get(i).getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata)) {
                spregiudicateNumero++;
            }
        }





        int quantiMorigerati = (morigeratiNumero*percentageDeathBehaviour) / 100;
        int quantiAvventurieri = (avventurieriNumero*percentageDeathBehaviour) / 100;
        int quantiPrudenti = (prudentiNumero*percentageDeathBehaviour) / 100;
        int quantiSpregiudicate = (spregiudicateNumero*percentageDeathBehaviour) / 100;

        int tuttiUccisi = 0;

        for(int i = 0; i < popolazionePassata.size(); i++) {
            if(popolazionePassata.get(i).getBehaviour().equals(PeopleFactory.Behaviour.Morigerato) && quantiMorigerati != 0) {
                popolazionePassata.remove(i);
                quantiMorigerati--;
                if(quantiMorigerati == 0) {
                    tuttiUccisi++;
                }
            }
            if(popolazionePassata.get(i).getBehaviour().equals(PeopleFactory.Behaviour.Avventuriero) && quantiAvventurieri != 0) {
                popolazionePassata.remove(i);
                quantiAvventurieri--;
                if(quantiAvventurieri == 0) {
                    tuttiUccisi++;
                }
            }
            if(popolazionePassata.get(i).getBehaviour().equals(PeopleFactory.Behaviour.Prudente) && quantiPrudenti != 0) {
                popolazionePassata.remove(i);
                quantiPrudenti--;
                if(quantiPrudenti == 0) {
                    tuttiUccisi++;
                }
            }
            if(popolazionePassata.get(i).getBehaviour().equals(PeopleFactory.Behaviour.Spregiudicata) && quantiSpregiudicate != 0) {
                popolazionePassata.remove(i);
                quantiSpregiudicate--;
                if(quantiSpregiudicate == 0) {
                    tuttiUccisi++;
                }
            }
        }

        return popolazionePassata;
    }
}
