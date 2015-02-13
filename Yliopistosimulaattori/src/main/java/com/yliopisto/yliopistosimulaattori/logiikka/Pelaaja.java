package com.yliopisto.yliopistosimulaattori.logiikka;

public class Pelaaja extends Hahmo {
	private String nimi;
	private int nalka = 100;
	
	public Pelaaja(String nimi) {
		this.nimi = nimi;
	}
	
	public String getNimi() {
		return this.nimi;
	}
	
	public int getNalka() {
		return this.nalka;
	}
	
	public void setNalka(int nalka) {
		this.nalka = nalka;
	}
	
	public void vahennaNalkaa() {
		this.nalka--;
	}
	
	@Override
	public String toString() {
		return "@";
	}
}
