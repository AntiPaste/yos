package com.yliopisto.yliopistosimulaattori.logiikka.objektit;

import com.yliopisto.yliopistosimulaattori.logiikka.Objekti;
import com.yliopisto.yliopistosimulaattori.logiikka.Pelaaja;

public class Tietokone extends Objekti {
	public Tietokone(Pelaaja pelaaja) {
		super(pelaaja);
	}
	
	@Override
	public String tutki() {
		return "Tietokone. Mystinen laatikko joka sisältää tämänkin projektin.";
	}
	
	@Override
	public String kayta() {
		return String.format("Ei tähän ole nyt aikaa, %s!", this.pelaaja.getNimi());
	}
}
