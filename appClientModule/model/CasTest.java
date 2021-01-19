package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.BadDateFormatException;
import exceptions.WrongNameFormatException;

public class CasTest {
	Cas c1, c2;
	
	@Before public void setup() throws WrongNameFormatException {
		c1 = new Cas("Jean Dupont");
		c2 = new Cas("Marie Martin");
	}
	
	@Test public void testConstructeur() {
		assertTrue(null != c1);
	}
	
	@Test public void testIncrement() {
		// deux cas crée a la suit on deux id qui se suivent
		assertEquals(1, c2.getId()-c1.getId());
	}
	
	@Test public void testNom()  {
		// le nom est constitué de caractére alphabetique et de tiret et contient un unique espace
		assertTrue(Cas.validateNom("a b"));
		assertTrue(Cas.validateNom("AbAT-Asssa qwertyui"));
		assertTrue(Cas.validateNom("M-Q-A A-E-rrrr"));
		assertTrue(Cas.validateNom("Jean dupont"));
		assertTrue(Cas.validateNom("Marie Martin"));
		assertFalse(Cas.validateNom("MarieMartin"));
		assertFalse(Cas.validateNom("Marie Martin Michel"));
		assertFalse(Cas.validateNom("Ma8rie Martin"));
		assertFalse(Cas.validateNom("Marie M@rtin"));
		assertFalse(Cas.validateNom(""));
		assertFalse(Cas.validateNom(null));
		assertFalse(Cas.validateNom(" "));
	}
	
	@Test public void testCodePostal() {
		//code postal constitué de 4 ou 5 chiffre
		assertTrue(Cas.validateCodePostal("1234"));
		assertTrue(Cas.validateCodePostal("12345"));
		assertTrue(Cas.validateCodePostal("00000")); 
		assertFalse(Cas.validateCodePostal("A0000"));
		assertFalse(Cas.validateCodePostal("000"));
		assertFalse(Cas.validateCodePostal("000000"));
		assertFalse(Cas.validateCodePostal("-0000"));
		assertFalse(Cas.validateCodePostal(null));
		assertFalse(Cas.validateCodePostal(""));
	}
	
	@Test public void testAdresse() {
		// adresse de minimum 8 charactére et maximum 25 charactére
		assertTrue(Cas.validateAdresse("1 rue dupont"));
		assertTrue(Cas.validateAdresse("8 bis imp. Marie-Antoinette"));
		assertFalse(Cas.validateAdresse(null));
		assertFalse(Cas.validateAdresse(""));
		assertFalse(Cas.validateAdresse("Court"));
	}
	
	@Test public void testEtat() {
		//etat est soit 1 soit -1
		assertTrue(Cas.validateEtat(1));
		assertTrue(Cas.validateEtat(-1));
		assertFalse(Cas.validateEtat(0));
		assertFalse(Cas.validateEtat(-2));
		assertFalse(Cas.validateEtat(2));
	}
	
	@Test public void testTelephone() {
		// telephone commence par 00 ou + suivi de 11 ou douze chiffres
		assertTrue(Cas.validateTel("+33000000000"));
		assertTrue(Cas.validateTel("+451000000000"));
		assertTrue(Cas.validateTel("0033000000000"));
		assertTrue(Cas.validateTel("00451000000000"));
		assertFalse(Cas.validateTel("+3300000000011"));
		assertFalse(Cas.validateTel("330000000000"));
		assertFalse(Cas.validateTel("033000000000"));
		assertFalse(Cas.validateTel(""));
		assertFalse(Cas.validateTel("033000A00000"));
		assertFalse(Cas.validateTel(null));
		assertFalse(Cas.validateTel("033000-00000"));
		assertFalse(Cas.validateTel("033000 00000"));
	}
	
	@Test public void testTest() {
		try {
			TestPcr t = new TestPcr(1, 1, 2020, 1);
			assertEquals(0, c1.getEtat());
			c1.addTest(t);
			assertEquals(1, c1.getEtat());
			System.out.println(c1);
		} catch (BadDateFormatException e) {
			fail();
			e.printStackTrace();
		}
		
	}

}
