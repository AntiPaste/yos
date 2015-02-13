package com.yliopisto.yliopistosimulaattori.kayttoliittyma;

import com.yliopisto.yliopistosimulaattori.Main;
import com.yliopisto.yliopistosimulaattori.logiikka.Kartta;
import com.yliopisto.yliopistosimulaattori.logiikka.Pelaaja;
import java.util.Scanner;

public class Kayttoliittyma {
	private final Main simulaattori;
	private final Scanner lukija;
	
	public Kayttoliittyma(Main simulaattori) {
		this.simulaattori = simulaattori;
		this.lukija = new Scanner(System.in);
	}
	
	/**
	 * Lukee komennon käyttäjän syötteestä ja toimii sen mukaan.
	 * 
	 * @return Pitäisikö peli lopettaa vai ei.
	 */
	public boolean lueKomento() {
		System.out.print("Komento: ");
		String komento = this.lukija.nextLine();
		
		System.out.println("");
		
		switch (komento.toLowerCase()) {
			case "lopeta":
				return true;
			
			case "w":
				this.simulaattori.liiku(0, -1);
				break;
			
			case "a":
				this.simulaattori.liiku(-1, 0);
				break;
			
			case "s":
				this.simulaattori.liiku(0, 1);
				break;
			
			case "d":
				this.simulaattori.liiku(1, 0);
				break;
			
			case "e":
				this.simulaattori.tutki();
				break;
			
			case "f":
				this.simulaattori.kayta();
				break;
			
			default:
				this.tulostaOhjeet();
				break;
		}
		
		return false;
	}
	
	/**
	 * Tulostaa pelaajan tiedot.
	 * 
	 * @param pelaaja Pelaajaolio
	 */
	public void tulostaPelaaja(Pelaaja pelaaja) {
		System.out.println(String.format("%s the käpistelijä", pelaaja.getNimi()));
		System.out.println(String.format("Nälkä: %d", pelaaja.getNalka()));
		System.out.println("");
	}
	
	/**
	 * Tulostaa kartan.
	 * 
	 * @param kartta Karttaolio
	 */
	public void tulostaKartta(Kartta kartta) {
		System.out.println(kartta);
	}
	
	/**
	 * Tulostaa pelaajan nälkäkuoleman.
	 */
	public void tulostaNalkakuolema() {
		System.out.println("Käpistelijä kuoli nälkään!");
		System.out.println("Traagista, mutta realistista.");
	}
	
	/**
	 * Tulostaa kuvauksen objektista.
	 * 
	 * @param kuvaus Objektin kuvaus
	 */
	public void tulostaKuvaus(String kuvaus) {
		System.out.println(kuvaus);
	}
	
	/**
	 * Tulostaa objektin käyttämistä seuraavan viestin.
	 * 
	 * @param tulos Viesti
	 */
	public void tulostaAktio(String tulos) {
		System.out.println(tulos);
	}
	
	/**
	 * Tulostaa ohjeet peliin.
	 */
	public void tulostaOhjeet() {
		System.out.println("Yliopistosimulaattori");
		System.out.println("------ Komennot -----");
		System.out.println("ohje   - tulostaa tämän ohjeen");
		System.out.println("lopeta - lopettaa ohjelman");
		System.out.println("");
		System.out.println("-------- Peli -------");
		System.out.println("w      - liiku ylös");
		System.out.println("a      - liiku vasemmalle");
		System.out.println("s      - liiku alas");
		System.out.println("d      - liiku oikealle");
		System.out.println("e      - tutki objektia");
		System.out.println("f      - käytä objektia");
		System.out.println("");
	}
}
