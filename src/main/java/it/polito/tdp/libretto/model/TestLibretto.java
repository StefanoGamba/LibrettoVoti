package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class TestLibretto {

	Libretto lib;
	
	private void run() {
		
		this.lib = new Libretto();
		
		// 1. aggiunti nuovi voti al libretto
		
		Voto v1 = new Voto("tecniche di programmazione", 30, LocalDate.of(2020, 06, 15));
		Voto v2 = new Voto("analisi II", 28, LocalDate.of(2020, 06, 3));
		
		lib.add(v1);
		lib.add(v2);
		lib.add(new Voto("economia", 24, LocalDate.of(2020, 02, 14)));
		
		System.out.println(this.lib);
		
		// 2. stampati voti pari a 28
		
		System.out.println(this.lib.stampaVotiUguali(28));
		
		System.out.println(this.lib.estraiVotiUguali(28));
		
		// 3. ricerca per nome corso
		
		String nomeCorso = "analisi II";
		Voto votoAnalisi = this.lib.cercaNomeCorso(nomeCorso);
		Voto votoMancante = this.lib.cercaNomeCorso("Fisica I");
		
		System.out.println("il voto di " + nomeCorso + " è " + votoAnalisi.getVoto());
		System.out.println("il voto di Fisica I è " + votoMancante);
		
		// 4. verifica voti duplicati
		
		Voto economia2 = new Voto("economia", 24, LocalDate.now());
		
		// 5. verifica voti in conflitto
		
		Voto economia3 = new Voto("economia", 21, LocalDate.now());
		
		System.out.println("economia con 24 è duplicato: " + lib.isDuplicato(economia2) + " / conflitto: " + lib.isConflitto(economia2));
		System.out.println("economia con 21 è duplicato: " + lib.isDuplicato(economia3) + " / conflitto: " + lib.isConflitto(economia3));
		
		// 7. libretto migliorato
		
		Libretto migliorato = this.lib.creaLibrettoMigliorato();
		System.out.println("\nLibretto migliorato:\n");
		System.out.println(this.lib);
		System.out.println(migliorato);
		
		// 8. ordine alfabetico
		
		Libretto alfabetico = new Libretto(this.lib);
		alfabetico.ordinaPerCorso();
		System.out.println(alfabetico);
		
		// 8. ordine per voto
		
		Libretto voto = new Libretto(this.lib);
		voto.ordinaPerVoto();
		System.out.println(voto);
		
		// 9. cancella voti < 24
		
		Libretto maggiori25 = new Libretto(lib);
		maggiori25.cancellaVotiScarsi();
		System.out.println(maggiori25);
		
	}
	
	public static void main(String[] args) {
		
		TestLibretto test = new TestLibretto();
		test.run();

	}

}
