package Humans;

public class People implements PeopleFactory
{

    /** Crea una persona con le seguenti caratteristiche
     *
     *
     * @param kind il carattere di questa persona
     *
     * @param age l'età di questa persona
     *
     * @param hp la vita di questa persona
     *
     * @param yearOfBirth l'anno di nascita di questa persona
     *
     *
     * @throws IllegalStateException se l'età di questa persona è <0
     *
     * @throws IllegalStateException se la vita di questa persona è <0
     *
     * @throws IllegalStateException se l'anno di nascita di questa persona è <0 */


    public People(Behaviour kind, int age, int hp, int yearOfBirth)
    {
        if(age<0)
        {
            throw new IllegalStateException("L'età della persona deve essere >=0");
        }
        if(hp<0)
        {
            throw new IllegalStateException("La vita della persona deve essere >=0");
        }
        if(yearOfBirth<0)
        {
            throw new IllegalStateException("L'anno di nascita della persona deve essere >=0");
        }

        if(kind.equals(Behaviour.Morigerato) || kind.equals(Behaviour.Avventuriero))
        {
            this.sex=Sexuality.Maschio;
        }
        else if(kind.equals(Behaviour.Prudente) || kind.equals(Behaviour.Spregiudicata))
        {
            this.sex=Sexuality.Femmina;
        }

        this.kind=kind;
        this.age=age;
        this.hp=hp;
        this.yearOfBirth=yearOfBirth;
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
    private Sexuality sex;

    /** Carattere della persona  */
    private Behaviour kind;

    /** Età della persona  */
    private int age;

    /** Vita della persona  */
    private float hp;

    /** Anno di nascita della persona  */
    private int yearOfBirth;

}

