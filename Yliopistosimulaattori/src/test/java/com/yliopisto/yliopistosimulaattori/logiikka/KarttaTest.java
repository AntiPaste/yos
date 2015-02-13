/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yliopisto.yliopistosimulaattori.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Branch
 */
public class KarttaTest {
	private Kartta kartta;

	public KarttaTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		this.kartta = new Kartta();
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void testMerkkiRuuduksiMuuttaaSeinan() throws Exception {
		Ruutu ruutu = this.kartta.merkkiRuuduksi('#');
		assertEquals(ruutu.getClass(), Seina.class);
	}
	
	@Test
	public void testMerkkiRuuduksiMuuttaaLattian() throws Exception {
		Ruutu ruutu = this.kartta.merkkiRuuduksi('.');
		assertEquals(ruutu.getClass(), Lattia.class);
	}
	
	@Test
	public void testMerkkiRuuduksiMuuttaaPelaajan() throws Exception {
		this.kartta.setPelaaja(new Pelaaja("Pekka"));
		
		Ruutu ruutu = this.kartta.merkkiRuuduksi('@');
		assertEquals(ruutu.getClass(), Pelaaja.class);
	}
	
	/*
		Kartan lukemista voidaan testata vertaamalla kartan tulostamaa
		merkkijonoa, sillä merkkijonon tulostus testataan erikseen.
	*/
	
	@Test
	public void testKartanMerkkijonoesitys() throws Exception {
		Ruutu[][] ruudut = new Ruutu[3][3];
		
		for (int i = 0; i < 3; i++) {
			ruudut[0][i] = new Seina();
			ruudut[2][i] = new Seina();
		}
		
		ruudut[1][0] = new Seina();
		ruudut[1][1] = new Lattia();
		ruudut[1][2] = new Seina();
		
		this.kartta.setRuudut(ruudut);
		this.kartta.setKorkeus(3);
		this.kartta.setLeveys(3);
		
		assertEquals(this.kartta.toString(), "###\n#.#\n###\n");
	}
	
	@Test
	public void testYhdenRivinKartanLukeminen() throws Exception {
		String[] yhdenRivinKartta = {
			".#..#",
		};
		
		try {
			this.kartta.lueKartta(yhdenRivinKartta);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(this.kartta.toString(), ".#..#\n");
	}
	
	@Test
	public void testUseammanRivinKartanLukeminen() throws Exception {
		String[] useammanRivinKartta = {
			"#####",
			"#...#",
			"#####",
		};
		
		try {
			this.kartta.lueKartta(useammanRivinKartta);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		assertEquals(this.kartta.toString(), "#####\n#...#\n#####\n");
	}

	@Test
	public void testTyhjanKartanLukeminen() throws Exception {
		String[] tyhjaKartta = {};
		
		try {
			this.kartta.lueKartta(tyhjaKartta);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Tyhjä kartta"));
		}
	}
	
	@Test
	public void testEpamuodostuneenKartanLukeminen() throws Exception {
		String[] epamuodostunutKartta = {
			"###",
			"##",
			"###",
		};
		
		try {
			this.kartta.lueKartta(epamuodostunutKartta);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Kartan leveys poikkesi rivillä 2"));
		}
	}
	
	@Test
	public void testTuntemattomanKartanMerkinLukeminen() throws Exception {
		String[] tuntematonSotilas = {
			"###",
			"#/#",
			"###",
		};
		
		try {
			this.kartta.lueKartta(tuntematonSotilas);
		} catch (Exception e) {
			assertTrue(e.getMessage().contains("Tuntematon merkki"));
		}
	}
	
	@Test
	public void testPelaajanLiikuttaminenTyhjaanOnnistuu() throws Exception {
		String[] kartta = {
			"####",
			"#@.#",
			"####",
		};
		
		this.kartta.setPelaaja(new Pelaaja("Pekka"));
		
		try {
			this.kartta.lueKartta(kartta);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		this.kartta.liikutaPelaajaa(1, 0);
		
		assertEquals(this.kartta.toString(), "####\n#.@#\n####\n");
	}
	
	@Test
	public void testPelaajanLiikuttaminenSeinaanEiOnnistu() throws Exception {
		String[] kartta = {
			"###",
			"#@#",
			"###",
		};
		
		this.kartta.setPelaaja(new Pelaaja("Pekka"));
		
		try {
			this.kartta.lueKartta(kartta);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		this.kartta.liikutaPelaajaa(0, 1);
		
		assertEquals(this.kartta.getPelaaja().getX(), 1);
		assertEquals(this.kartta.getPelaaja().getY(), 1);
	}
}
