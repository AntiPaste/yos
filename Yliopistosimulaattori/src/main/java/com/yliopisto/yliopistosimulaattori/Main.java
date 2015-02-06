package com.yliopisto.yliopistosimulaattori;

import com.yliopisto.yliopistosimulaattori.kayttoliittyma.Kayttoliittyma;
import com.yliopisto.yliopistosimulaattori.logiikka.Kartta;
import com.yliopisto.yliopistosimulaattori.logiikka.Lattia;
import com.yliopisto.yliopistosimulaattori.logiikka.Pelaaja;
import com.yliopisto.yliopistosimulaattori.logiikka.Ruutu;

public class Main {
	// Tulevaisuudessa tämä voitaisiin laittaa tiedostoihin
	private final static String[] exactumKartta = {
		"#####",
		"#...#",
		"#.@.#",
		"#...#",
		"#####",
	};
	
	private Kayttoliittyma kayttoliittyma;
	private Kartta kartta;
	
	public static void main(String[] args) {
		Main simulaattori = new Main();
		simulaattori.kaynnisty();
	}
	
	public void kaynnisty() {
		Pelaaja pelaaja = new Pelaaja("Pekka");
		
		this.kartta = new Kartta();
		this.kartta.setPelaaja(pelaaja);
		
		try {
			this.kartta.lueKartta(exactumKartta);
		} catch (Exception e) {
			System.out.println("Kartan luku epäonnistui.");
			System.out.println("Virhe: " + e.getMessage());
			return;
		}
		
		this.kayttoliittyma = new Kayttoliittyma(this);
		this.kayttoliittyma.tulostaKartta(this.kartta);
		
		while (!this.kayttoliittyma.lueKomento());
	}
	
	public void liiku(int dx, int dy) {
		this.kartta.liikutaPelaajaa(dx, dy);
		this.kayttoliittyma.tulostaKartta(this.kartta);
	}
}
