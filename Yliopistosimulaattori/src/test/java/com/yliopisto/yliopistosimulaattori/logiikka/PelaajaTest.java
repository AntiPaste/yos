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
public class PelaajaTest {
	public PelaajaTest() {
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
	public void testPelaajanNimiAsetetaan() throws Exception {
		Pelaaja pelaaja = new Pelaaja("Pekka");
		assertEquals(pelaaja.getNimi(), "Pekka");
	}
	
	@Test
	public void testPelaajanNalanVahentaminenOnnistuu() throws Exception {
		Pelaaja pelaaja = new Pelaaja("Pekka");
		int nalka = pelaaja.getNalka();
		
		pelaaja.vahennaNalkaa();
		assertEquals(pelaaja.getNalka(), nalka - 1);
	}
}
