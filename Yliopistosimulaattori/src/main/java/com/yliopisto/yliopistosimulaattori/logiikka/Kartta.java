package com.yliopisto.yliopistosimulaattori.logiikka;

import com.yliopisto.yliopistosimulaattori.Tasot;
import java.lang.reflect.Constructor;

/**
 *
 * @author Branch
 */
public class Kartta {
	private Pelaaja pelaaja;
	private Ruutu[][] ruudut;
	private Tasot tasot;
	private String taso;
	private int leveys = 0;
	private int korkeus = 0;
	private int oviNumero = 0;
	private int objektiNumero = 0;
	
	public Kartta() {
		this.tasot = new Tasot();
	}

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
		return this.pelaaja;
	}

	public void setPelaaja(Pelaaja pelaaja) {
		this.pelaaja = pelaaja;
	}
	
	/**
	 * Palauttaa ruudun tietyssä sijainnissa.
	 * 
	 * @param x Ruudun x-koordinaatti
	 * @param y Ruudun y-koordinaatti
	 * @return
	 */
	public Ruutu haeRuutu(int x, int y) {
		return this.ruudut[x][y];
	}
	
	/**
	 * Asettaa ruudun tiettyyn kohtaan karttaa.
	 * 
	 * @param ruutu Ruutuolio
	 * @param x Ruudun haluttu x-koordinaatti
	 * @param y Ruudun haluttu y-koordinaatti
	 */
	public void asetaRuutu(Ruutu ruutu, int x, int y) {
		this.ruudut[x][y] = ruutu;
	}
	
	/**
	 * Liikuttaa pelaajaa yhden ruudun.
	 * 
	 * @param dx Haluttu relatiivinen x-koordinaatti
	 * @param dy Haluttu relatiivinen y-koordinatti
	 * @return Onnistuiko liikkuminen
	 */
	public boolean liikutaPelaajaa(int dx, int dy) {
		int x = this.pelaaja.getX();
		int y = this.pelaaja.getY();
		
		Ruutu ruutu = this.haeRuutu(x + dx, y + dy);
		if (ruutu.getClass() == Ovi.class) {
			Ovi ovi = (Ovi) ruutu;
			this.aloitaTaso(this.tasot.getOvi(this.taso, ovi.getOviNumero()));
			return true;
		}
		
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
	
	/**
	 * Tutkii objektia viereisissä ruuduissa.
	 * 
	 * @return Objektin kuvaus
	 */
	public String tutki() {
		int x = this.pelaaja.getX();
		int y = this.pelaaja.getY();
		
		Ruutu ruutu = this.haeRuutu(x + 1, y);
		if (ruutu instanceof Objekti) {
			Objekti objekti = (Objekti) ruutu;
			return objekti.tutki();
		}
		
		ruutu = this.haeRuutu(x - 1, y);
		if (ruutu instanceof Objekti) {
			Objekti objekti = (Objekti) ruutu;
			return objekti.tutki();
		}
		
		ruutu = this.haeRuutu(x, y + 1);
		if (ruutu instanceof Objekti) {
			Objekti objekti = (Objekti) ruutu;
			return objekti.tutki();
		}
		
		ruutu = this.haeRuutu(x, y - 1);
		if (ruutu instanceof Objekti) {
			Objekti objekti = (Objekti) ruutu;
			return objekti.tutki();
		}
		
		return "Tyhjää. Kaikki on tyhjää.";
	}
	
	/**
	 * Käyttää objektia viereisissä ruuduissa.
	 * 
	 * @return Seuraamusviesti
	 */
	public String kayta() {
		int x = this.pelaaja.getX();
		int y = this.pelaaja.getY();
		
		Ruutu ruutu = this.haeRuutu(x + 1, y);
		if (ruutu instanceof Objekti) {
			Objekti objekti = (Objekti) ruutu;
			return objekti.kayta();
		}
		
		ruutu = this.haeRuutu(x - 1, y);
		if (ruutu instanceof Objekti) {
			Objekti objekti = (Objekti) ruutu;
			return objekti.kayta();
		}
		
		ruutu = this.haeRuutu(x, y + 1);
		if (ruutu instanceof Objekti) {
			Objekti objekti = (Objekti) ruutu;
			return objekti.kayta();
		}
		
		ruutu = this.haeRuutu(x, y - 1);
		if (ruutu instanceof Objekti) {
			Objekti objekti = (Objekti) ruutu;
			return objekti.kayta();
		}
		
		return "Kosket lattiaa. Se on likainen.";
	}
	
	/**
	 * Aloittaa tietyn tason nimen perusteella.
	 * 
	 * @param nimi Tason nimi
	 */
	public void aloitaTaso(String nimi) {
		this.taso = nimi;
		try {
			this.lueKartta(this.tasot.getTaso(nimi));
		} catch (Exception e) {
			System.out.println("Kartan luku epäonnistui.");
			System.out.println("Virhe: " + e.getMessage());
			System.exit(0);
		}
	}
	
	/**
	 * Luo kartan merkkijonon perusteella.
	 * 
	 * @param kartta Merkkijonoesitys kartasta
	 * @throws Exception
	 */
	public void lueKartta(String[] kartta) throws Exception {
		if (kartta == null || kartta.length == 0)
			throw new Exception("Tyhjä kartta.");
		
		this.oviNumero = 0;
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
	
	/**
	 * Muuttaa merkin ruutuolioksi
	 * 
	 * @param merkki Merkki
	 * @return
	 */
	public Ruutu merkkiRuuduksi(char merkki) {
		switch (merkki) {
			case '#':
				return new Seina();
			
			case '.':
				return new Lattia();
			
			case '%':
				Constructor c;
				Class luokka = this.tasot.getObjekti(this.taso, this.objektiNumero++);
				try {
					c = luokka.getDeclaredConstructor(Pelaaja.class);
					return (Objekti) c.newInstance(this.pelaaja);
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.exit(0);
				}
			
			case '|':
				return new Ovi(this.oviNumero++, true);
			
			case '-':
				return new Ovi(this.oviNumero++, false);
			
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
