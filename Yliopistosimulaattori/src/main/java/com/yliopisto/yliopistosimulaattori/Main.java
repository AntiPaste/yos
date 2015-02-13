package com.yliopisto.yliopistosimulaattori;

import com.yliopisto.yliopistosimulaattori.kayttoliittyma.Kayttoliittyma;
import com.yliopisto.yliopistosimulaattori.logiikka.Kartta;
import com.yliopisto.yliopistosimulaattori.logiikka.Pelaaja;

public class Main {
	private Kayttoliittyma kayttoliittyma;
	private Kartta kartta;
	private Tasot tasot;
	
	public static void main(String[] args) {
		Main simulaattori = new Main();
		simulaattori.kaynnisty();
	}
	
	/**
	 * Käynnistää pelin
	 */
	public void kaynnisty() {
		Pelaaja pelaaja = new Pelaaja("Pekka");
		
		this.kartta = new Kartta();
		this.kartta.setPelaaja(pelaaja);
		
		this.kartta.aloitaTaso("ulkomaailma");
		
		this.kayttoliittyma = new Kayttoliittyma(this);
		this.kayttoliittyma.tulostaKartta(this.kartta);
		
		while (!this.kayttoliittyma.lueKomento()) {
			if (this.tarkistaNalkakuolema()) {
				this.kayttoliittyma.tulostaNalkakuolema();
				break;
			}
		}
	}
	
	/**
	 * Metodi kertoo, pitäisikö pelaajan kuolla
	 * nälkäkuolema pelaajan nälän perusteella.
	 * 
	 * @return onko tapahtunut nälkäkuolema
	 */
	public boolean tarkistaNalkakuolema() {
		return (this.kartta.getPelaaja().getNalka() <= 0);
	}
	
	/**
	 * Käyttää objektia pelaajan niin komentaessa.
	 * Kutsutaan käyttöliittymästä.
	 */
	public void kayta() {
		String tulos = this.kartta.kayta();
		
		this.kayttoliittyma.tulostaPelaaja(this.kartta.getPelaaja());
		this.kayttoliittyma.tulostaAktio(tulos);
		this.kayttoliittyma.tulostaKartta(this.kartta);
	}
	
	/**
	 * Tutkii objektia pelaajan niin komentaessa.
	 * Kutsutaan käyttöliittymästä.
	 */
	public void tutki() {
		String kuvaus = this.kartta.tutki();
		
		this.kayttoliittyma.tulostaPelaaja(this.kartta.getPelaaja());
		this.kayttoliittyma.tulostaKuvaus(kuvaus);
		this.kayttoliittyma.tulostaKartta(this.kartta);
	}
	
	/**
	 * Siirtää pelaajaa kartalla pelaajan niin komentaessa.
	 * Kutsutaan käyttöliittymästä.
	 * 
	 * @param dx Relatiivinen muutos pelaajan x-koordinaattiin
	 * @param dy Relatiivinen muutos pelaajan y-koordinaattiin
	 */
	public void liiku(int dx, int dy) {
		this.kartta.liikutaPelaajaa(dx, dy);
		this.kartta.getPelaaja().vahennaNalkaa();
		
		this.kayttoliittyma.tulostaPelaaja(this.kartta.getPelaaja());
		this.kayttoliittyma.tulostaKartta(this.kartta);
	}
}
