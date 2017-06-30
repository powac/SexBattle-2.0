package Humans;


public interface PeopleFactory
{

    /**    I quattro tipi:
     *
     *      Nello scenario descritto in questo progetto, la battaglia dei sessi,
     *      tratto da un libro di Richard Dawkins del 1976, The Selfish Gene,
     *      i tipi sono quattro: due maschili, M e A, e due femminili, P e S:
     *
     *
     *      – tipo M:
     *                  Uomini morigerati, sono disposti a corteggiare la donna amata
     *                  e contribuiscono al pari di lei a crescere la prole;
     *
     *      – tipo A:
     *                  Gli avventurieri, uomini senza scrupoli:
     *                  se una donna non gli si concede immediatamente,
     *                  tentano la sorte altrove senza perdere tempo corteggiarla;
     *                  se gli si concede, partono comunque subito dopo per una nuova avventura,
     *                  lasciando a lei l’incombenza di crescere la prole;
     *
     *
     *      – tipo P:
     *                  Donne prudenti, accettano un compagno con cui fare un figlio
     *                  solo dopo un congruo periodo di corteggiamento;
     *
     *      – tipo S:
     *                  Donne spregiudicate, si concedono ad un uomo anche al primo incontro, se così credono.
     *
     *
     *  */


    public enum Sexuality
    {
        /** Uomo di tipo Maschio  */
        Maschio,

        /** Donna di tipo Femmina  */
        Femmina
    }
    public enum Behaviour
    {
        /** Uomo di tipo M  */
        Morigerato,

        /** Uomo di tipo A  */
        Avventuriero,

        /** Donna di tipo P  */
        Prudente,

        /** Donna di tipo S  */
        Spregiudicata;
    }



    /** Ritorna la Sexuality di questa persona
     *
     * @return
     *          La Sexuality di questa persona */

    public People.Sexuality getSexuality();

    /** Ritorna il carattere di questa persona
     *
     * @return
     *          Il Behaviour di questa persona */

    public People.Behaviour getBehaviour();

    /** Ritorna l'età di questa persona
     *
     * @return
     *          L'age di questa persona */

    public int getAge();

    /** Ritorna la vita di questa persona
     *
     * @return
     *          Gli hp di questa persona */

    public float getHp();

    /** Ritorna l'anno di nascita di questa persona
     *
     * @return
     *          L'anno di nascita di questa persona */

    public int getYearOfBirth();





    /** Incrementà l'età di questa persona  */

     public void incrementAge();


    /** Imposta gli hp di questa persona
     *
     * @param hp gli hp di questa persona
     *
     * @throws IllegalStateException se gli hp sono >100  */

     public void setHp(float hp);





     // anni che la persona non puo procreare

     //public void setStop(int stop);

     //public int getStop();
}
