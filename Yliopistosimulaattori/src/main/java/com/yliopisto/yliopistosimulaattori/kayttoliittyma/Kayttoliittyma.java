package com.yliopisto.yliopistosimulaattori.kayttoliittyma;

import com.yliopisto.yliopistosimulaattori.Main;
import com.yliopisto.yliopistosimulaattori.logiikka.Kartta;
import java.util.Scanner;

public class Kayttoliittyma {
	private final Main simulaattori;
	private final Scanner lukija;
	
	public Kayttoliittyma(Main simulaattori) {
		this.simulaattori = simulaattori;
		this.lukija = new Scanner(System.in);
	}
	
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
			
			default:
				this.tulostaOhjeet();
				break;
		}
		
		return false;
	}
	
	public void tulostaKartta(Kartta kartta) {
		System.out.println(kartta);
	}
	
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
		System.out.println("");
	}
}
