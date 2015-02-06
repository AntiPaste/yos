package com.yliopisto.yliopistosimulaattori.logiikka;

public class Pelaaja extends Hahmo {
	private String nimi;
	
	public Pelaaja(String nimi) {
		this.nimi = nimi;
	}
	
	@Override
	public String toString() {
		return "@";
	}
}
