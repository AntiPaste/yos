package com.yliopisto.yliopistosimulaattori.logiikka.objektit;

import com.yliopisto.yliopistosimulaattori.logiikka.Objekti;
import com.yliopisto.yliopistosimulaattori.logiikka.Pelaaja;

public class Unicafe extends Objekti {
	public Unicafe(Pelaaja pelaaja) {
		super(pelaaja);
	}
	
	@Override
	public String tutki() {
		return "Unicafe. Käpistelijä saa täällä nälkänsä tyydytettyä.";
	}
	
	@Override
	public String kayta() {
		if (this.pelaaja.getNalka() > 90) {
			return "Käpistelijällä ei ole nälkä.";
		}
		
		this.pelaaja.setNalka(100);
		return "Nyt käpistelijä jaksaa taas datailla!";
	}
}
