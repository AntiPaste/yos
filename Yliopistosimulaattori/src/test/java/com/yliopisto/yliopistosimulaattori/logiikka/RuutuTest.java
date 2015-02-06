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
public class RuutuTest {
	public RuutuTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}
	
	@Test
	public void testOikeaLattianMerkkiJosRuutuOnTyhja() throws Exception {
		Lattia lattia = new Lattia();
		assertEquals(lattia.toString(), ".");
	}
	
	@Test
	public void testOikeaLattianMerkkiJosRuudussaOnHahmo() throws Exception {
		Lattia lattia = new Lattia();
		Pelaaja pelaaja = new Pelaaja("Pekka");
		lattia.setHahmo(pelaaja);
		
		assertEquals(lattia.toString(), pelaaja.toString());
	}
	
	@Test
	public void testOikeaLattianMerkkiJosRuudussaOnObjekti() throws Exception {
		Lattia lattia = new Lattia();
		Objekti objekti = new Objekti();
		lattia.setObjekti(objekti);
		
		assertEquals(lattia.toString(), objekti.toString());
	}
}
