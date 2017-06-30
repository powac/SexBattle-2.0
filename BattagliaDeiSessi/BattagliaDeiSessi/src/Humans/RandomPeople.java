package Humans;

import java.util.Objects;
import java.util.Random;

public class RandomPeople implements PeopleFactory
{
    /** Crea una persona random con i parametri dati
     *
     * @param sex il sesso di questa persona
     *
     * @param kind il carattere di questa persona
     *
     * @param age l'età di questa persona
     *
     * @param hp la vita di questa persona
     *
     * @param yearOfBirth l'anno di nascita di questa persona  */


    public RandomPeople(Sexuality sex,Behaviour kind,int age,int hp, int yearOfBirth)
    {

        // IMPLEMENTARE QUESTO COSTRUTTORE CON TUTTE COMBINAZIONI DI CASI
        // Sommatoria delle combinazioni di:
        // 5 su 0 = 1
        // 5 su 1 = 5
        // 5 su 2 = 10
        // 5 su 3 = 10
        // 5 su 4 = 5
        // 5 su 5 = 1
        // Totale 32
        /*

                Nessuno:

                null null null null     1

                Singoli:                5

                sex
                kind
                age
                hp
                yearOfBirth

                Doppi:                  10

                sex kind
                sex age
                sex hp
                sex yearOfBirth
                kind age
                kind hp
                kind yearOfBirth
                age hp
                age yearOfBirth
                hp yearOfBirth

                Tripli:                 10

                sex kind age
                sex kind hp
                sex kind yearOfBirth

                kind age hp
                kind age yearOfBirth

                age hp yearOfBirth

                sex age hp
                sex age yearOfBirth
                sex hp yearOfBirth

                kind hp yearOfBirth

                Quadrupli:              5

                sex kind age hp
                sex kind age yearOfBirth
                sex kind hp yearOfBirth
                sex age hp yearOfBirth
                kind age hp yearOfBirth

                Quintupli:              1

                sex kind age hp yearOfBirth

                Totale:                 32
         */


        if (Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(age) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.setRandomSexuality();
            this.setRandomBehaviour();
            this.setRandomAge();
            this.setRandomHP();
            this.setRandomYearOfBirth();
        }

        // caso sex null null null null
        if (!Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(age) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.sex=sex;
            this.setRandomBehaviour();
            this.setRandomAge();
            this.setRandomHP();
            this.setRandomYearOfBirth();
        }

        // caso null kind null null null
        if (!Objects.isNull(kind) && Objects.isNull(sex) && Objects.isNull(age) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.kind = kind;
            this.setRandomSexuality();
            this.setRandomAge();
            this.setRandomHP();
            this.setRandomYearOfBirth();
        }

        // caso null null age null null
        if (!Objects.isNull(age) && Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.age = age;
            this.setRandomSexuality();
            this.setRandomBehaviour();
            this.setRandomHP();
            this.setRandomYearOfBirth();
        }

        // caso null null null hp null
        if (!Objects.isNull(hp) && Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(age) && Objects.isNull(yearOfBirth)) {
            this.hp = hp;
            this.setRandomSexuality();
            this.setRandomBehaviour();
            this.setRandomAge();
            this.setRandomYearOfBirth();
        }

        // caso null null null null yearOfBirth
        if (!Objects.isNull(yearOfBirth) && Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(age) && Objects.isNull(hp)) {
            this.yearOfBirth = yearOfBirth;
            this.setRandomSexuality();
            this.setRandomBehaviour();
            this.setRandomAge();
            this.setRandomHP();
        }

        // caso sex kind null null null
        if (!Objects.isNull(sex) && !Objects.isNull(kind) && Objects.isNull(age) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            if (sex == PeopleFactory.Sexuality.Maschio && (kind == PeopleFactory.Behaviour.Morigerato || kind == PeopleFactory.Behaviour.Avventuriero)) {
                this.sex = sex;
                this.kind = kind;
            } else {
                // ERRORE!
            }
            if (sex == PeopleFactory.Sexuality.Femmina && (kind == PeopleFactory.Behaviour.Prudente || kind == PeopleFactory.Behaviour.Spregiudicata)) {
                this.sex = sex;
                this.kind = kind;
            } else {
                // ERRORE!
            }
        }

        // caso sex null age null null
        if (!Objects.isNull(sex) && !Objects.isNull(age) && Objects.isNull(kind) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.age = age;
            this.setRandomBehaviour();
            this.setRandomHP();
            this.setRandomYearOfBirth();
        }

        // caso sex null null hp null
        if (!Objects.isNull(sex) && !Objects.isNull(hp) && Objects.isNull(kind) && Objects.isNull(age) && Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.hp = hp;
            this.setRandomBehaviour();
            this.setRandomAge();
            this.setRandomYearOfBirth();
        }

        // caso sex null null null yearOfBirth
        if (!Objects.isNull(sex) && !Objects.isNull(yearOfBirth) && Objects.isNull(kind) && Objects.isNull(age) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.yearOfBirth = yearOfBirth;
            this.setRandomBehaviour();
            this.setRandomAge();
            this.setRandomHP();
        }

        // caso null kind age null null
        if (!Objects.isNull(kind) && !Objects.isNull(age) && Objects.isNull(sex) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.kind = kind;
            this.age = age;
            this.setRandomSexuality();
            this.setRandomHP();
            this.setRandomYearOfBirth();
        }

        // caso null kind null hp null
        if (!Objects.isNull(kind) && !Objects.isNull(hp) && Objects.isNull(sex) && Objects.isNull(age) && Objects.isNull(yearOfBirth)) {
            this.kind = kind;
            this.hp = hp;
            this.setRandomSexuality();
            this.setRandomAge();
            this.setRandomYearOfBirth();
        }

        // caso null kind null null yearOfBirth
        if (!Objects.isNull(kind) && !Objects.isNull(yearOfBirth) && Objects.isNull(sex) && Objects.isNull(age) && Objects.isNull(hp)) {
            this.kind = kind;
            this.yearOfBirth = yearOfBirth;
            this.setRandomSexuality();
            this.setRandomAge();
            this.setRandomHP();
        }

        // caso null null age hp null
        if (!Objects.isNull(age) && !Objects.isNull(hp) && Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(yearOfBirth)) {
            this.age = age;
            this.hp = hp;
            this.setRandomSexuality();
            this.setRandomBehaviour();
            this.setRandomYearOfBirth();
        }

        // caso null null age null yearOfBirth
        if (!Objects.isNull(age) && !Objects.isNull(yearOfBirth) && Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(hp)) {
            this.age = age;
            this.yearOfBirth = yearOfBirth;
            this.setRandomSexuality();
            this.setRandomBehaviour();
            this.setRandomHP();
        }

        // caso null null null hp YearOfBirth
        if (!Objects.isNull(hp) && !Objects.isNull(yearOfBirth) && Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(age)) {
            this.hp = hp;
            this.yearOfBirth = yearOfBirth;
            this.setRandomSexuality();
            this.setRandomBehaviour();
            this.setRandomAge();
        }

        // caso sex kind age null null
        if (!Objects.isNull(sex) && !Objects.isNull(kind) && ! Objects.isNull(age) && Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.kind = kind;
            this.age = age;
            this.setRandomHP();
            this.setRandomYearOfBirth();
        }

        // caso sex kind null hp null
        if (!Objects.isNull(sex) && !Objects.isNull(kind) && Objects.isNull(age) && !Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.kind = kind;
            this.hp = hp;
            this.setRandomAge();
            this.setRandomYearOfBirth();
        }

        // caso sex kind null null yearOfBirth
        if (!Objects.isNull(sex) && !Objects.isNull(kind) && Objects.isNull(age) && Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.kind = kind;
            this.yearOfBirth = yearOfBirth;
            this.setRandomAge();
            this.setRandomHP();
        }

        // caso null kind age hp null
        if (Objects.isNull(sex) && !Objects.isNull(kind) && !Objects.isNull(age) && !Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.kind = kind;
            this.age = age;
            this.hp = hp;
            this.setRandomSexuality();
            this.setRandomYearOfBirth();
        }

        // caso null kind age null yearOfBirth
        if (Objects.isNull(sex) && !Objects.isNull(kind) && !Objects.isNull(age) && Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.kind = kind;
            this.age = age;
            this.yearOfBirth = yearOfBirth;
            this.setRandomSexuality();
            this.setRandomHP();
        }

        // caso null null age hp yearOfBirth
        if (Objects.isNull(sex) && Objects.isNull(kind) && !Objects.isNull(age) && !Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.age = age;
            this.hp = hp;
            this.yearOfBirth = yearOfBirth;
            this.setRandomSexuality();
            this.setRandomBehaviour();
        }

        // caso sex null age hp null
        if (!Objects.isNull(sex) && Objects.isNull(kind) && !Objects.isNull(age) && !Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.age = age;
            this.hp = hp;
            this.setRandomBehaviour();
            this.setRandomYearOfBirth();
        }

        // caso sex null age null yearOfBirth
        if (!Objects.isNull(sex) && Objects.isNull(kind) && !Objects.isNull(age) && Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.age = age;
            this.yearOfBirth = yearOfBirth;
            this.setRandomBehaviour();
            this.setRandomHP();
        }

        // caso sex null null hp yearOfBirth
        if (!Objects.isNull(sex) && Objects.isNull(kind) && Objects.isNull(age) && !Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.hp = hp;
            this.yearOfBirth = yearOfBirth;
            this.setRandomBehaviour();
            this.setRandomAge();
        }

        // caso null kind null hp yearOfBirth
        if (Objects.isNull(sex) && !Objects.isNull(kind) && Objects.isNull(age) && !Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.kind = kind;
            this.hp = hp;
            this.yearOfBirth = yearOfBirth;
            this.setRandomSexuality();
            this.setRandomAge();
        }

        // caso sex kind age hp null
        if (!Objects.isNull(sex) && !Objects.isNull(kind) && !Objects.isNull(age) && !Objects.isNull(hp) && Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.kind = kind;
            this.age = age;
            this.hp = hp;
            this.setRandomYearOfBirth();
        }

        // caso sex kind age null yearOfBirth
        if (!Objects.isNull(sex) && !Objects.isNull(kind) && !Objects.isNull(age) && Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.kind = kind;
            this.age = age;
            this.yearOfBirth = yearOfBirth;
            this.setRandomHP();
        }

        // caso sex kind null hp yearOfBirth
        if (!Objects.isNull(sex) && !Objects.isNull(kind) && Objects.isNull(age) && !Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.kind = kind;
            this.hp = hp;
            this.yearOfBirth = yearOfBirth;
            this.setRandomAge();
        }

        // caso sex null age hp yearOfBirth
        if (!Objects.isNull(sex) && Objects.isNull(kind) && !Objects.isNull(age) && !Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.age = age;
            this.hp = hp;
            this.yearOfBirth = yearOfBirth;
            this.setRandomBehaviour();
        }

        // caso null kind age hp yearOfBirth
        if (Objects.isNull(sex) && !Objects.isNull(kind) && !Objects.isNull(age) && !Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.kind = kind;
            this.age = age;
            this.hp = hp;
            this.yearOfBirth = yearOfBirth;
            this.setRandomSexuality();
        }

        // caso alltypes
        if (!Objects.isNull(sex) && !Objects.isNull(kind) && !Objects.isNull(age) && !Objects.isNull(hp) && !Objects.isNull(yearOfBirth)) {
            this.sex = sex;
            this.kind = kind;
            this.age = age;
            this.hp = hp;
            this.yearOfBirth = yearOfBirth;
        }

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



    public synchronized void setRandomSexuality()
    {
        if (!Objects.isNull(this.kind)) {
            if (random < 0.5 || (this.kind == PeopleFactory.Behaviour.Avventuriero || this.kind == PeopleFactory.Behaviour.Morigerato)) {
                this.sex = PeopleFactory.Sexuality.Maschio;
            } else {
                this.sex = PeopleFactory.Sexuality.Femmina;
            }
        } else {
            if (random < 0.5) {
                this.sex = PeopleFactory.Sexuality.Maschio;
            } else {
                this.sex = PeopleFactory.Sexuality.Femmina;
            }
        }
    }

    public synchronized void setRandomBehaviour() {
        if (!Objects.isNull(this.sex)) {
            if (random < 0.5) {
                if (this.sex == PeopleFactory.Sexuality.Maschio) {
                    this.kind = PeopleFactory.Behaviour.Morigerato;
                } else if (this.sex == PeopleFactory.Sexuality.Femmina) {
                    this.kind = PeopleFactory.Behaviour.Prudente;
                }
            } else {
                if (this.sex == PeopleFactory.Sexuality.Maschio) {
                    this.kind = PeopleFactory.Behaviour.Avventuriero;
                } else {
                    this.kind = PeopleFactory.Behaviour.Spregiudicata;
                }
            }
        } else {
            if (random < 0.25) {
                this.kind = PeopleFactory.Behaviour.Morigerato;
            } else if (random >= 0.25 && random < 0.5) {
                this.kind = PeopleFactory.Behaviour.Avventuriero;
            } else if (random >= 0.5 && random < 0.75) {
                this.kind = PeopleFactory.Behaviour.Spregiudicata;
            } else {
                this.kind = PeopleFactory.Behaviour.Prudente;
            }
        }
    }

    public synchronized void setRandomAge() {
        if (!Objects.isNull(this.age))
        {
            int rmage = randomInt.nextInt(100);
            this.age = rmage;
        }
    }

    public synchronized void setRandomHP() {
        if (!Objects.isNull(this.hp)) {
            int results = randomInt.nextInt(40);
            this.hp = results;
        }
    }

    public synchronized void setRandomYearOfBirth() {
        if (!Objects.isNull(this.yearOfBirth)) {
            int birth = randomInt.nextInt(2000) + 1940;
            this.yearOfBirth = birth;
        }
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






    private double random = Math.random();

    private Random randomInt = new Random();

}

