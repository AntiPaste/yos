package com.yliopisto.yliopistosimulaattori.logiikka;

/**
 *
 * @author Branch
 */
public class Lattia implements Ruutu {
	private Hahmo hahmo;
	private Objekti objekti;

	public Hahmo getHahmo() {
		return hahmo;
	}

	public void setHahmo(Hahmo hahmo) {
		this.hahmo = hahmo;
	}

	public Objekti getObjekti() {
		return objekti;
	}

	public void setObjekti(Objekti objekti) {
		this.objekti = objekti;
	}
	
	@Override
	public String toString() {
		if (this.hahmo != null) return this.hahmo.toString();
		if (this.objekti != null) return this.objekti.toString();
		return ".";
	}
}
