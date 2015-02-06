package com.yliopisto.yliopistosimulaattori.logiikka;

public class Kartta {
	private Pelaaja pelaaja;
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

	public Pelaaja getPelaaja() {
		return pelaaja;
	}

	public void setPelaaja(Pelaaja pelaaja) {
		this.pelaaja = pelaaja;
	}
	
	public Ruutu haeRuutu(int x, int y) {
		return this.ruudut[x][y];
	}
	
	public void asetaRuutu(Ruutu ruutu, int x, int y) {
		this.ruudut[x][y] = ruutu;
	}
	
	public boolean liikutaPelaajaa(int dx, int dy) {
		int x = this.pelaaja.getX();
		int y = this.pelaaja.getY();
		
		Ruutu ruutu = this.haeRuutu(x + dx, y + dy);
		if (ruutu.getClass() != Lattia.class
				|| ((Lattia) ruutu).getHahmo() != null
				|| ((Lattia) ruutu).getObjekti() != null) {
			return false;
		}
		
		this.pelaaja.setX(x + dx);
		this.pelaaja.setY(y + dy);
		
		Lattia kohde = (Lattia) ruutu;
		Lattia sijainti = (Lattia) this.haeRuutu(x, y);
		sijainti.setHahmo(null);
		kohde.setHahmo(this.pelaaja);
		
		return true;
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
				
				if (ruutu.getClass() == Pelaaja.class) {
					Lattia lattia = new Lattia();
					lattia.setHahmo((Hahmo) ruutu);
					
					this.pelaaja.setX(x);
					this.pelaaja.setY(y);
					
					this.ruudut[x][y] = lattia;
					continue;
				}
				
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
			
			case '%':
				return new Objekti();
			
			case '@':
				return this.pelaaja;
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
