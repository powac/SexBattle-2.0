package Humans;

import java.util.Objects;
import java.util.Random;
import Populations.Population;


public class People implements PeopleFactory {



    private Sexuality sex;
    private Behaviour kind;
    private Integer age;
    private Float hp;
    private int yearOfBirth;
    /** Fattore random per determinazione del sesso, differente da rk per non generare lo stesso valore */
    private double rs = Math.random();
	/** Fattore random per determinazione del tipo, differente da rs per non generare lo stesso valore */
    private double rk = Math.random();
    private Random randomInt = new Random();



	/**
	 * Questo costruttore genera oggetti {@link People}.
	 * <br> La funzione accetta come parametro un array (di dimensione variabile),
	 * ma costruisce effettivamente con al più cinque diversi parametri.
	 * Se vengono inseriti più volte parametri che si riferiscono ad uno stesso attributo dell'oggetto,
	 * verrà considerato solo l'ultimo inserito.
	 * <br> Gli attributi mancanti in input verranno inseriti automaticamente dalle funzioni Random integrate
	 * in questa classe.
	 * <br> Infine è necessario fare attenzione riguardo età e data di nascita: solo la prima va inserita. La seconda
	 * verrà calcolata automaticamente una volta dato un anno corrente alla popolazione.
	 *
	 * 
	 * @throws NullPointerException se gli attributi passati al costruttore sono più di 4.
	 * @throws IllegalStateException se si attribuisce a un individuo maschio un carattere proprio di una Femmina,
	 * e viceversa.
	 * @throws IllegalStateException se si inserisce un valore intero più grande di 120 come età di un individuo.
     * */
    
     public People(Object... params) {
     	if (params.length > 4) {
     		throw new NullPointerException("Al più una persona viene catalogata con 4 valori, "
     				+ "\nla data di nascita verrà automaticamente calcolata in base all'età");
     	}
    	//inserimento variabili presenti tra i parametri
    	for(Object p : params) {
    		if(p instanceof Sexuality) {
    			sex = (Sexuality)p;
    		} 
    		else if (p instanceof Behaviour) {
    			kind = (Behaviour) p;
    		}
    		else if (p instanceof String) {
    			String s = (String)p;
    			if((s.toLowerCase().equals("m")) || (s.toLowerCase().equals("maschio")) || (s.toLowerCase().equals("male") || p == Sexuality.Maschio))
    				sex = Sexuality.Maschio;
				if((s.toLowerCase().equals("f")) || (s.toLowerCase().equals("femmina")) || (s.toLowerCase().equals("female") || p == Sexuality.Femmina))
					sex = Sexuality.Femmina;
				if(((s.toLowerCase().equals("morigerato")) || p == Behaviour.Morigerato) && (sex == Sexuality.Maschio|| Objects.isNull(sex)))
					kind = Behaviour.Morigerato;
				if(((s.toLowerCase().equals("avventuriero")) || p == Behaviour.Avventuriero) && (sex == Sexuality.Maschio || Objects.isNull(sex)))
					kind = Behaviour.Avventuriero;
				if(((s.toLowerCase().equals("prudente")) || p == Behaviour.Prudente) && (sex == Sexuality.Femmina || Objects.isNull(sex)))
					kind = Behaviour.Prudente;
				if(((s.toLowerCase().equals("spregiudicata")) || p == Behaviour.Spregiudicata) && (sex == Sexuality.Femmina || Objects.isNull(sex)))
					kind = Behaviour.Spregiudicata;
    		}
    		else if (p instanceof Integer) {
    				int i = (Integer) p;
    				if(i > 120) {
    					throw new IllegalStateException("Una persona dei nostri giorni non "
    							+ "\npuò vivere per più di -NumeroACasoMoltoGrande- anni!");
    				} else {
    					this.age = i;
    				}
    		}
    		else if(p instanceof Float) {
    			hp = (Float) p;
    		}
    		if ((sex == Sexuality.Maschio && (kind == Behaviour.Prudente || kind == Behaviour.Spregiudicata)) || (sex == Sexuality.Femmina && (kind == Behaviour.Morigerato || kind == Behaviour.Avventuriero))) {
         		throw new IllegalStateException("Per questioni di chiarezza e accortezza, "
         				+ "\nnon si può associare un carattere femminile a un individuo maschile, e viceversa.");
    		}
    	}
    	// creazione casuale dei dati mancanti
		if(Objects.isNull(sex))  		   this.setRandomSexuality();
		if(Objects.isNull(kind)) 		   this.setRandomBehaviour();
		if(Objects.isNull(age))            this.setRandomAge();
		if(Objects.isNull(hp))             this.setRandomHP();
		this.setYearOfBirth();
	}
    
     
     
    //"Getters"
     
    @Override
    public synchronized Sexuality getSexuality() {
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
    public synchronized int getYearOfBirth() {
         return yearOfBirth;
     }

    
    
    //"Setters"
    
    
    /** Questo metodo è da applicarsi a ogni scorrimento di una lista popolazione.
     * <br>Ha anche la funzione opzionale (da modificare in codice) di ridurre gli hp con il passare del tempo. */
    @Override
    public synchronized void incrementAge() {
        this.age = this.age + 1;
        this.hp = this.hp - 0;
    }




    
    /** Imposta artificialmente il valore degli hp */
    @Override
    public synchronized void setHp(float h) {
        this.hp = h;
    }




    
    /** Strettamente legato a setRandomAge(), questo metodo restituisce la data di nascita di un individuo
     * <br>secondo la funzione Fn = AnnoCorrente - Età. */
    private synchronized void setYearOfBirth() {
    	this.yearOfBirth = Population.year - age;
    }
    
    

    // Da qui, i metodi setRandom.
       
    
    /** Questo metodo si serve di due fattori, rs e rk.
     * <p>
     * rs è una variabile random esattamente come rk, ma sono istanziate differentemente per evitare la creazione
     * di persone secondo un pattern identico nel tempo.
     * <br>Dalle due dipendono rispettivamente in maniera randomica il sesso e il carattere di una persona.
     * <br>Nonostante questa funzione abbia come solo scopo settare il sesso di quest'ultima, è necessario
     * fare un controllo sul carattere affinchè non si abbiano attributi ambigui.
     * 
     * <p>In assenza di entrambi i valori, così come specificato dalla chiamata del costruttore,
     * il sesso viene assegnato in base al valore casuale della variabile rs.*/
    private synchronized void setRandomSexuality() {
    	if (!Objects.isNull(this.kind)) {
    		if (this.kind == PeopleFactory.Behaviour.Avventuriero || this.kind == PeopleFactory.Behaviour.Morigerato) {
    			this.sex = PeopleFactory.Sexuality.Maschio;
    		}
    		else {
    			this.sex = PeopleFactory.Sexuality.Femmina;
            }
    	}
    	else {
    		if (rs < 0.5 ) {
    			this.sex = PeopleFactory.Sexuality.Maschio;
    		} else {
    			this.sex = PeopleFactory.Sexuality.Femmina;
            }
        }
    }




    
    /** Questo metodo si serve di due fattori, rs e rk.
     * <p>
     * rs è una variabile random esattamente come rk, ma sono istanziate differentemente per evitare la creazione
     * di persone secondo un pattern identico nel tempo.
     * <br>Dalle due dipendono rispettivamente in maniera randomica il sesso e il carattere di una persona.
     * <br>Nonostante questa funzione abbia come solo scopo settare il carattere di quest'ultima, è necessario
     * fare un controllo sul carattere affinchè non si abbiano attributi ambigui.
     * 
     * <p>In assenza di entrambi i valori, così come specificato dalla chiamata del costruttore,
     * il carattere viene assegnato in base al valore casuale della variabile rk.
	 * */
    private synchronized void setRandomBehaviour() {
    	if (!Objects.isNull(this.sex)) {
    		if (rk < 0.5) {
    			if (this.sex == PeopleFactory.Sexuality.Maschio) {
    				this.kind = PeopleFactory.Behaviour.Morigerato;
    			}
    			else if (this.sex == PeopleFactory.Sexuality.Femmina) {
    				this.kind = PeopleFactory.Behaviour.Prudente;
    			}
    		}
    		else {
    			if (this.sex == PeopleFactory.Sexuality.Maschio) {
    				this.kind = PeopleFactory.Behaviour.Avventuriero;
    			}
    			else {
    				this.kind = PeopleFactory.Behaviour.Spregiudicata;
    			}
    		}
    	}
    	else {
    		if (rk < 0.25 && rs < 0.5) {
    			this.kind = PeopleFactory.Behaviour.Morigerato;
    		}
    		else if (rk >= 0.25 && rk < 0.5 && rs < 0.5) {
    			this.kind = PeopleFactory.Behaviour.Avventuriero;
    		}
    		else if (rk >= 0.5 && rk < 0.75 && rs >= 0.5) {
    			this.kind = PeopleFactory.Behaviour.Spregiudicata;
    		}
    		else if (rk >= 0.75 && rs >= 0.5) {
    			this.kind = PeopleFactory.Behaviour.Prudente;
    		}
    	}
    } 




    
    /** Strettamente legato a setRandomYearOfBirth(), questo metodo si serve di un valore intero randomico
     * compreso in un range che va da 0 a 120. */
    private synchronized void setRandomAge() {
    	this.age = randomInt.nextInt(120);
    	}
    




    /** Semplice generazione randomica di un valore compreso tra 0 e 100. */
    private synchronized void setRandomHP() {
    	this.hp = (float) randomInt.nextInt(100);
    }
}
