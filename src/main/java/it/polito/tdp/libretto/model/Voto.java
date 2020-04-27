package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Classe voto contiene le informazioni su un esame superato
 * 
 * @author user
 *
 */

public class Voto implements Comparable<Voto>{
		
	private String corso;
	private int voto;
	private LocalDate data;
	/**
	 * Costruisce un nuovo voto
	 * 
	 * @param corso nome del corso di cui si è preso il voto
	 * @param voto valore numerico del voto
	 * @param data data in cui è stato preso il voto
	 */
	public Voto(String corso, int voto, LocalDate data) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.data = data;
	}
	
	/**
	 * copy constructor di {@link Voto}
	 * @param v
	 */
	public Voto(Voto v) {
		this.corso = v.corso; // permesso da java in alternativa a v.getCorso();
		this.voto = v.voto;
		this.data = v.data; /* gli attributi di Voto sono di tipo immutabile (??), quindi per questi tipi non si pone il problema della copia del riferimento o del valore.
							 Nel caso ci fossero attributi non di tipo immutabile per creare un nuovo oggetto copia e non solo una copia del riferimento si potrebbe
							 usare un copy constructor anche per loro */
	}
	public String getCorso() {
		return corso;
	}
	public void setCorso(String corso) {
		this.corso = corso;
	}
	public int getVoto() {
		return voto;
	}
	public void setVoto(int voto) {
		this.voto = voto;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return corso + ": " + voto + " (" + data + ")";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corso == null) ? 0 : corso.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voto other = (Voto) obj;
		if (corso == null) {
			if (other.corso != null)
				return false;
		} else if (!corso.equals(other.corso))
			return false;
		return true;
	}
	
	@Override
	public Voto clone() {
		Voto v = new Voto(this.corso, this.voto, this.data);
		return v;
	}

	@Override
	public int compareTo(Voto o) { // coerente con l'override del metodo equals, cioè il confronto avviene sul nome corso per entrambi
		return this.corso.compareTo(o.corso);
	}
	
}
