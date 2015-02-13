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
public class OviTest {
	public OviTest() {
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
	public void testTulostaaVertikaalisenMerkinOikein() throws Exception {
		Ovi ovi = new Ovi(0, true);
		assertEquals(ovi.toString(), "|");
	}
	
	@Test
	public void testTulostaaHorisontaalisenMerkinOikein() throws Exception {
		Ovi ovi = new Ovi(0, false);
		assertEquals(ovi.toString(), "-");
	}
}
