package com.yliopisto.yliopistosimulaattori.logiikka;

public class Kartta {
	private Ruutu[][] ruudut;
	private int leveys = 0;
	private int korkeus = 0;

	public Ruutu[][] getRuudut() {
		return this.ruudut;
	}

	public void setRuudut(Ruutu[][] ruudut) {
		this.ruudut = ruudut;
	}

	public int getLeveys() {
		return this.leveys;
	}

	public void setLeveys(int leveys) {
		this.leveys = leveys;
	}

	public int getKorkeus() {
		return this.korkeus;
	}

	public void setKorkeus(int korkeus) {
		this.korkeus = korkeus;
	}
	
	public void lueKartta(String[] kartta) throws Exception {
		if (kartta == null || kartta.length == 0)
			throw new Exception("Tyhjä kartta.");
		
		this.korkeus = kartta.length;
		this.leveys = kartta[0].length();
		this.ruudut = new Ruutu[this.leveys][this.korkeus];
		
		for (int y = 0; y < this.korkeus; y++) {
			String rivi = kartta[y];
			
			for (int x = 0; x < this.leveys; x++) {
				char merkki;
				
				try {
					merkki = rivi.charAt(x);
				} catch (IndexOutOfBoundsException e) {
					throw new Exception("Kartan leveys poikkesi rivillä " + (y + 1));
				}
				
				Ruutu ruutu = this.merkkiRuuduksi(merkki);
				
				if (ruutu == null)
					throw new Exception("Tuntematon merkki kartassa.");
				
				this.ruudut[x][y] = ruutu;
			}
		}
	}
	
	public Ruutu merkkiRuuduksi(char merkki) {
		switch (merkki) {
			case '#':
				return new Seina();
			
			case '.':
				return new Lattia();
		}
		
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder kartta = new StringBuilder();
		for (int y = 0; y < this.korkeus; y++) {
			for (int x = 0; x < this.leveys; x++) {
				// ruudut[x][y] on varmasti olemassa, sillä korkeus on
				// nollasta poikkeava vain jos kartta on asetettu ja validi
				kartta.append(this.ruudut[x][y]);
			}
			
			kartta.append("\n");
		}
		
		return kartta.toString();
	}
}
