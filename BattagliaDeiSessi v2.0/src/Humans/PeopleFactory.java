package Humans;

public interface PeopleFactory {
    /** Iniziamo dicendo che la nostra simulazione si basa su un'evoluzione semplificata
     * del genere umano attraverso la riproduzione dei suoi individui.
     * <br> Questo ci porta inevitabilmente a creare due generi, uno maschile e uno femminile,
     * al fine di comporre i successivi accoppiamenti. Tuttavia, servirà il carattere
     * per garantire la piena compatibilità tra gli individui, e ciò nello specifico
     * è descritto nel Javadoc del Behaviour. */

    public enum Sexuality {
        /** Uomo, compatibile per figliare con persone di genere Femminile. */
        Maschio,

        /** Donna, compatibile per figliare con persone di genere Maschile. */
        Femmina
    }
    
    
    /** Nello scenario descritto in questo progetto traiamo quattro personalità, o tipi,
    * da un libro di Richard Dawkins, The Selfish Gene, 1976.
    * Due maschili, Morigerati e Avventurieri, e due femminili, Prudenti e Spregiudicate.
    *  
    *	<p> Per quanto riguarda il genere maschile:
    *   	<br><pre> tipo M: uomini morigerati. Sono disposti a corteggiare la donna amata
    *		e contribuiscono al pari di lei a crescere la prole; </pre>
    *		
    *       <pre> tipo A: gli avventurieri, uomini senza scrupoli.
    *		Se una donna non gli si concede immediatamente,
    *       tentano la sorte altrove senza perdere tempo nel corteggiarla;
    *       se gli si concede, partono comunque subito dopo per una nuova avventura,
    *       lasciando a lei l'incombenza di crescere la prole; </pre>
    *
    *	<p> mentre, per quanto riguarda il genere femminile:
    *		<br><pre> tipo P: donne prudenti. Accettano un compagno con cui fare un figlio
    *       solo dopo un congruo periodo di corteggiamento; </pre>
    *
    *		<pre> tipo S: donne spregiudicate. Si concedono ad un uomo anche al primo incontro, 
    *		se così credono. </pre>
    *
    *  */
    
    public enum Behaviour {
        /** Uomo di tipo M, secondo la tabella del MAPS. I suoi valori di guadagno saranno così calcolati:
         * <br> Fn = (a - b/2 - c) quando l'accoppiamento avverrà con una Donna Prudente;
         * <br> Fn = (a - b/2) quando l'accoppiamento avverrà con una Donna Spregiudicata.
         * 
         * <p> Ricordiamo sempre che "a, b, c" vengono intesi come illustrato sotto:
         * <br> a : premio per il successo nella generazione di ﬁgli; 
         * <br> b : costo del crescere ﬁgli;
         * <br> c : costo del corteggiamento.*/
        Morigerato,

        /** Uomo di tipo A, secondo la tabella del MAPS. È compatibile soltanto con Donne Spregiudicate,
         * generando un guadagno secondo la seguente Fn = a.
         * 
         * <p> Ricordiamo sempre che "a, b, c" vengono intesi come illustrato sotto:
         * <br> a : premio per il successo nella generazione di ﬁgli; 
         * <br> b : costo del crescere ﬁgli;
         * <br> c : costo del corteggiamento. */
        Avventuriero,

        /** Donna di tipo P, secondo la tabella del MAPS. È compatibile soltando con Uomini Morigerati,
         * generando un guadagno secondo la seguente Fn = (a - b/2 - c).
         * 
         * <p> Ricordiamo sempre che "a, b, c" vengono intesi come illustrato sotto:
         * <br> a : premio per il successo nella generazione di ﬁgli; 
         * <br> b : costo del crescere ﬁgli;
         * <br> c : costo del corteggiamento.  */
        Prudente,

        /** Donna di tipo S, secondo la tabella del MAPS. Accetta gli Uomini di entrambi i generi,
         * secondo i seguenti casi:
         * <br> Fn = (a - b/2 - c) nel caso l'accoppiamento avvenga con un Uomo Morigerato;
         * <br> Fn = (a - b) nel caso l'accoppiamento avvenga con un Uomo Avventuriero.  
         * 
         * <p> Ricordiamo sempre che "a, b, c" vengono intesi come illustrato sotto:
         * <br> a : premio per il successo nella generazione di ﬁgli; 
         * <br> b : costo del crescere ﬁgli;
         * <br> c : costo del corteggiamento. */
        Spregiudicata;
    }

    
    /** Restituisce il sesso di questa persona.
     *
     * @return sexuality, tra maschio o femmina. */

    public Sexuality getSexuality();
    
    

    /** Restituisce il carattere di questa persona.
     *
     * @return Il Behaviour, tra i quattro tipi disponibili secondo il MAPS. */

    public Behaviour getBehaviour();
    
    

    /** Restituisce l'età di questa persona.
     *
     * @return l'Age, un valore compreso tra 0 e 100. */

    public int getAge();

    
    
    /** Restituisce la felicità di una persona.
     *
     * @return Gli hp (happiness ma anche heal points) di questa persona. */

    public float getHp();
    
    

    /** Restituisce la data di nascita di questa persona.
     *
     * @return l'anno di nascita, ovvero di generazione della persona - questo aiuta a
     * calcolarne anche l'appartenenza a una data popolazione. */

    public int getYearOfBirth();



    /** Incrementa l'età di questa persona, da usare ogni volta che la lista o il set popolazione termina
     * la lettura, e quindi l'accoppiamento, di tutti i suoi elementi persona.  */

    public void incrementAge();
    
    
    
    /** Da usare in fase di creazione popolazioni. */
    public void setHp(float h);




     // anni per il quale la persona non può procreare - al momento inutilizzato
     	//public void setStop(int stop);
     	//public int getStop();
}
