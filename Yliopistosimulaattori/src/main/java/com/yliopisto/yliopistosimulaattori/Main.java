package com.yliopisto.yliopistosimulaattori;

import com.yliopisto.yliopistosimulaattori.logiikka.Kartta;

public class Main {
	// Tulevaisuudessa tämä voitaisiin laittaa tiedostoihin
	private final static String[] exactumKartta = {
		"#####",
		"#...#",
		"#...#",
		"#...#",
		"#####",
	};
	
	public static void main(String[] args) {
		Kartta kartta = new Kartta();
		
		try {
			kartta.lueKartta(exactumKartta);
		} catch (Exception e) {
			System.out.println("Kartan luku epäonnistui.");
			System.out.println("Virhe: " + e.getMessage());
			return;
		}
		
		System.out.println(kartta);
	}
}
