package com.yliopisto.yliopistosimulaattori.logiikka;

public class Ovi implements Ruutu {
	private int oviNumero;
	private boolean vertical;
	
	public Ovi(int oviNumero, boolean vertical) {
		this.oviNumero = oviNumero;
		this.vertical = vertical;
	}
	
	/**
	 * Palauttaa oven numeron kartassa.
	 * Tämän avulla tiedetään mihin ovesta pitäisi päästä.
	 * 
	 * @return Ovinumero
	 */
	public int getOviNumero() {
		return this.oviNumero;
	}
	
	@Override
	public String toString() {
		return (this.vertical ? "|" : "-");
	}
}