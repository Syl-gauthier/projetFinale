package utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class DateTest {

	@Test
	public void test() {
		// mauvais mois
		assertFalse(Date.isValid(1, 0, 2000));
		assertFalse(Date.isValid(1, 13, 2000));
		
		// 31 jour
		assertTrue(Date.isValid(1, 1, 2000));
		assertTrue(Date.isValid(31, 1, 2000));
		assertFalse(Date.isValid(0, 1, 2000));
		assertFalse(Date.isValid(32, 1, 2000));
		
		// 30 jour
		assertTrue(Date.isValid(1, 4, 2000));
		assertTrue(Date.isValid(30, 4, 2000));
		assertFalse(Date.isValid(0, 4, 2000));
		assertFalse(Date.isValid(31, 4, 2000));
		
		// fevrier
		assertTrue(Date.isValid(1, 2, 2000));
		assertTrue(Date.isValid(1, 2, 2001));
		assertTrue(Date.isValid(29, 2, 2000));
		assertTrue(Date.isValid(28, 2, 2001));
		assertFalse(Date.isValid(0, 2, 2000));
		assertFalse(Date.isValid(0, 2, 2001));
		assertFalse(Date.isValid(30, 2, 2000));
		assertFalse(Date.isValid(29, 2, 2001));
	}

}
