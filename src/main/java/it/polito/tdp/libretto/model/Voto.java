package it.polito.tdp.libretto.model;

import java.time.LocalDate;

/**
 * Classe voto contiene le informazioni su un esame superato
 * 
 * @author user
 *
 */

public class Voto {
		
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
	
	
	
}
