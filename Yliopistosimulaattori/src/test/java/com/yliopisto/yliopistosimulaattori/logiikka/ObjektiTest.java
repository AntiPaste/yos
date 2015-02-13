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
public class ObjektiTest {
	public ObjektiTest() {
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
	public void testTulostaaKayttamisenOikein() throws Exception {
		Objekti objekti = new Objekti(new Pelaaja("Pekka"));
		assertEquals(objekti.kayta(), "Käytä mitä? Mitä täällä tapahtuu?");
	}
	
	@Test
	public void testTulostaaTutkimisenOikein() throws Exception {
		Objekti objekti = new Objekti(new Pelaaja("Pekka"));
		assertEquals(objekti.tutki(), "Objekti. Eipä siinä mitään.");
	}
	
	@Test
	public void testTulostaaMerkinOikein() throws Exception {
		Objekti objekti = new Objekti(new Pelaaja("Pekka"));
		assertEquals(objekti.toString(), "%");
	}
}
