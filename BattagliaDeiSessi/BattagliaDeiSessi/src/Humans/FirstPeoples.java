package Humans;


public class FirstPeoples implements PeopleFactory
{
    /** Crea una persona random con le seguenti caratteristiche
     *
     * sex la sessualità casuale di questa persona che dipende dal Behaviour scelto
     *
     * kind il carattere casuale di questa persona tra quelli disponibili
     *
     * age l'età casuale di questa persona tra 0-99 anni
     *
     * hp la vita casuale di questa persona calcolata come 100-l'età
     *
     * yearOfBirth l'anno di nascita di questa persona calcolato come l'anno 2000 meno l'età  */

    public FirstPeoples()
    {
        double randomBehaviour = Math.random();

        if(randomBehaviour<0.25)
        {
            this.sex= PeopleFactory.Sexuality.Maschio;
            this.kind= PeopleFactory.Behaviour.Morigerato;
        }
        else if(randomBehaviour>=0.25 && randomBehaviour<0.5)
        {
            this.sex= PeopleFactory.Sexuality.Maschio;
            this.kind= PeopleFactory.Behaviour.Avventuriero;
        }
        else if(randomBehaviour>=0.5 && randomBehaviour<0.75)
        {
            this.sex= PeopleFactory.Sexuality.Femmina;
            this.kind= PeopleFactory.Behaviour.Prudente;
        }
        else if(randomBehaviour>=0.75 && randomBehaviour<1)
        {
            this.sex= PeopleFactory.Sexuality.Femmina;
            this.kind= PeopleFactory.Behaviour.Spregiudicata;
        }
        //this.age= (int) (Math.random()*100);
        this.age=0;
        //this.hp=  (100-this.age);
        this.hp= 0;
        //this.yearOfBirth=2000-this.age;
        this.yearOfBirth=2000;
    }



    @Override
    public synchronized Sexuality getSexuality()
    {
        return sex;
    }

    @Override
    public synchronized Behaviour getBehaviour() {
        return kind;
    }

    @Override
    public synchronized int getAge() {
        return age;
    }

    @Override
    public synchronized float getHp() {
        return hp;
    }

    @Override
    public synchronized int getYearOfBirth() { return yearOfBirth; }

    @Override
    public synchronized void incrementAge() { this.age=this.age+1; }

    @Override
    public synchronized void setHp(float hp)
    {
        this.hp=hp;
    }


    /** Sesso della persona  */
    private PeopleFactory.Sexuality sex;

    /** Carattere della persona  */
    private PeopleFactory.Behaviour kind;

    /** Età della persona  */
    private int age;

    /** Vita della persona  */
    private float hp;

    /** Anno di nascita della persona  */
    private int yearOfBirth;


}
