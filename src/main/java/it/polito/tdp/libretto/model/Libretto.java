package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * Classe Libretto, memorizza e gestisce un insieme di voti
 * 
 * @author user
 *
 */

public class Libretto {
	
	private List<Voto> voti = new ArrayList<>();
	
	/**
	 * costruttore di default, crea un libretto nuovo (e vuoto)
	 */
	public Libretto() { // nel momento in cui definisco un costruttore, java smette di usare il costruttore di default automaticamente quando chiamato, quindi devo
		                // se questo costruttore vuoto è usato devo implementarlo a mano
		super();
	}
	
	/**
	 * Copy constructor
	 * (shallow) fa una copia dell'ArrayList, creandone una nuovo,
	 * ma non degli oggetti (Voto) contenuti in esso, condivisi dai due ArrayList
	 * quindi le due liste contengono riferimenti agli stessi voti
	 * cioé cambiando i valori degli attributi di un voto in una lista essi cambiano anche nell'altra
	 * ma la copia shallow basta per avere due ordinamenti diversi degli stessi voti
	 * @param lib
	 */
	public Libretto(Libretto lib) {
		this.voti.addAll(lib.voti); // lib.voti permesso da java 
	}
	
	/**
	 * aggiunge un nuovo voto al libretto
	 * @param v nuovo voto
	 * @return restituisce {@code true} se ha inserito l'elemento, {@code false} se non l'ha inserito perché già presente o in conflitto
	 */
	public boolean add(Voto v) {
		if(this.isConflitto(v) || this.isDuplicato(v)) {
			return false;
		}
		else {
			this.voti.add(v);
			return true;
		}
	}
	
	/**
	 * Stampa solo i voti pari al valore specificato
	 * @param v valore specificato
	 * @return stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali(int voto) {
		String s = "";
		for(Voto v : this.voti) {
			if(v.getVoto() == voto) {
				s += v.toString() + "\n";
			}
		}
		return s;
	}
	
	/**
	 * Genera un nuovo libretto, a partire da quello già esistente,
	 * che conterrà esclusivamente i voti pari al valore specificato
	 * @param voto valore specificato
	 * @return nuovo Libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
			if(v.getVoto() == voto) {
				nuovo.add(v);
			}
		}
		return nuovo;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		return s;
	}
	
	/**
	 * dato il nome di un corso ricerca se quell'esame esiste nel libretto,
	 * e in caso affermativo restituisce l'oggetto {@link Voto} corrispondente.
	 * Se l'esame non esiste restituisce {@code null}
	 * @param nomeCorso nome del corso
	 * @return oggetto {@link Voto} corrispondente, oppure {@code null}
	 */
	public Voto cercaNomeCorso(String nomeCorso) {
//		Voto result = null;
//		for(Voto v : this.voti) {
//			if(v.getCorso().equals(nomeCorso)) {
//				result = v;
//				return result;
//			}
//		}
//		return result;
		
		int pos = this.voti.indexOf(new Voto(nomeCorso, 0, null));
		return pos != -1 ? this.voti.get(pos) : null;
		
	}
	
	/**
	 * Stabilisce se esiste già nel libretto il {@link Voto} specificato
	 * @param v {@link Voto} specificato
	 * @return {@code true} se esiste già, {@code false} se non esiste
	 */
	public boolean isDuplicato(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		return esiste == null ? false : esiste.getVoto() == v.getVoto();
	}
	
	/**
	 * Determina se esiste un voto con lo stesso nome corso ma diversa valutazione
	 * @param v
	 * @return
	 */
	public boolean isConflitto(Voto v) {
		Voto esiste = this.cercaNomeCorso(v.getCorso());
		return esiste == null ? false : esiste.getVoto() != v.getVoto();
	}
	
	public Libretto creaLibrettoMigliorato() {
		Libretto nuovo = new Libretto();
		for(Voto v : this.voti) {
//			Voto v2 = v; copia solo il riferimento all'oggetto, il puntatore all'oggetto, senza creare un nuovo oggetto, quindi quando modifico v2 modifica anche v
//                       perché i due riferimenti condividono lo stesso oggetto
			
//			Voto v2 = new Voto(v);
//			EQUIVALE A
			Voto v2 = v.clone();
			if(v.getVoto() >= 24) {
				v2.setVoto(v.getVoto()+2);
				if(v2.getVoto() > 30) {
					v2.setVoto(30);
				}
			}
			else if(v.getVoto() >= 18 && v.getVoto() < 24) {
				v2.setVoto(v.getVoto()+1); 
			}
			nuovo.add(v2);
		}
		return nuovo;
	}
	
	public void ordinaPerCorso() {
		Collections.sort(this.voti);
	}
	
	public void ordinaPerVoto() {
		this.voti.sort((v1, v2)->v2.getVoto()-v1.getVoto());
	}
	
	/**
	 *  elimina i voti inferiori a 25
	 */
	public void cancellaVotiScarsi() {
		this.voti.removeIf(new Predicate<Voto>() {
			@Override
			public boolean test(Voto v) {
				return v.getVoto() < 25;
			}
		});
	}
	
}
