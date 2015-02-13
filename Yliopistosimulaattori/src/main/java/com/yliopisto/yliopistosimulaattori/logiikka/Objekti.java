package com.yliopisto.yliopistosimulaattori.logiikka;

/**
 *
 * @author Branch
 */
public class Objekti implements Ruutu {

	/**
	 *
	 */
	public Pelaaja pelaaja;
	
	/**
	 *
	 * @param pelaaja
	 */
	public Objekti(Pelaaja pelaaja) {
		this.pelaaja = pelaaja;
	}
	
	/**
	 * Tutkii objektia. Tämä overridataan tarkemmissa objektiolioissa.
	 * 
	 * @return Kuvaus objektista
	 */
	public String tutki() {
		return "Objekti. Eipä siinä mitään.";
	}
	
	/**
	 * Käyttää objektia. Tämä overridataan tarkemmissa objektiolioissa.
	 * 
	 * @return Seurausviesti
	 */
	public String kayta() {
		return "Käytä mitä? Mitä täällä tapahtuu?";
	}
	
	@Override
	public String toString() {
		return "%";
	}
}
