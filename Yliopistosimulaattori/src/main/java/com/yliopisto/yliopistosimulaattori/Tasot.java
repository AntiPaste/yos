package com.yliopisto.yliopistosimulaattori;

import com.yliopisto.yliopistosimulaattori.logiikka.objektit.Tietokone;
import com.yliopisto.yliopistosimulaattori.logiikka.objektit.Unicafe;
import java.util.HashMap;
import java.util.Map;

public class Tasot {
	private Map<String, String[]> tasot;
	private Map<String, String[]> ovet;
	private Map<String, Class[]> objektit;
	
	private static final String[] ULKOMAAILMA = {
		"#####",
		"#...#",
		"|...#",
		"#...#",
		"#...#",
		"#.@.#",
		"#####",
	};
	
	private static final String[] EXACTUM = {
		"##########",
		"#..%.....#",
		"#........#",
		"#....@...|",
		"#........#",
		"#..%.....#",
		"##########",
	};
	
	public Tasot() {
		this.tasot = new HashMap();
		this.tasot.put("ulkomaailma", Tasot.ULKOMAAILMA);
		this.tasot.put("exactum", Tasot.EXACTUM);
		
		this.ovet = new HashMap();
		this.ovet.put("ulkomaailma", new String[] { "exactum", });
		this.ovet.put("exactum", new String[] { "ulkomaailma", });
		
		this.objektit = new HashMap();
		this.objektit.put("exactum", new Class[] { Unicafe.class, Tietokone.class });
	}
	
	/**
	 * Palauttaa tason kartan tason nimen perusteella.
	 * 
	 * @param nimi Tason nimi
	 * @return Tason kartan merkkijonoesitys
	 */
	public String[] getTaso(String nimi) {
		return this.tasot.get(nimi);
	}
	
	/**
	 * Palauttaa tason nimen joka vastaa tietyn tason tiettyä ovea.
	 * Ovesta astuttaessa siirrytään tasoon, jonka nimen tämä palauttaa.
	 * 
	 * @param nimi Tason nimi
	 * @param numero Oven numero kartassa.
	 * @return Kohdetason nimi
	 */
	public String getOvi(String nimi, int numero) {
		return this.ovet.get(nimi)[numero];
	}
	
	/**
	 * Palauttaa objektin joka vastaa tietyn tasoa tiettyä objektia.
	 * 
	 * @param nimi Tason nimi
	 * @param numero Objektin numero kartassa.
	 * @return Objekti
	 */
	public Class getObjekti(String nimi, int numero) {
		return this.objektit.get(nimi)[numero];
	}
}
