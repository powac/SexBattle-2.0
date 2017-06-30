package Humans;

public class InfoPeople {
	private String infoPersona = null;

    /** Richiede il carattere della persona.
     *
     * @param kind il carattere che si vuole conoscere della persona in questione.
     *
     * @throws NullPointerException se per qualche motivo il kind è nullo */

    public InfoPeople(PeopleFactory.Behaviour kind) {
        if(kind.equals(PeopleFactory.Behaviour.Morigerato)) {
            infoPersona = "Uomini morigerati, sono disposti a corteggiare la donna amata\n" +
                    "e contribuiscono al pari di lei a crescere la prole;";
            
        } else if(kind.equals(PeopleFactory.Behaviour.Avventuriero)) {
            infoPersona = "Gli avventurieri, uomini senza scrupoli:\n" +
                    "se una donna non gli si concede immediatamente,\n" +
                    "tentano la sorte altrove senza perdere tempo nel corteggiarla;\n" +
                    "se gli si concede, partono comunque subito dopo per una nuova avventura,\n" +
                    "lasciando a lei l'incombenza di crescere la prole;";
            
        } else if(kind.equals(PeopleFactory.Behaviour.Prudente)) {
            infoPersona = "Donne prudenti, accettano un compagno con cui fare un figlio\n" +
                    "solo dopo un congruo periodo di corteggiamento;";
            
        } else if(kind.equals(PeopleFactory.Behaviour.Spregiudicata)) {
            infoPersona = "Donne spregiudicate, si concedono ad un uomo anche al primo incontro, se cos� credono.";
        }
    }


    /** Ritorna il tipo di carattere della persona.
     *
     * @return uno dei quattro possibili tipi di Behaviour, considerati nel quadro MAPS. */

    public String getInfoPeople() {
        return infoPersona;
    }
}
