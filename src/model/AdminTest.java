package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdminTest {

	@Test
	public void testLogin() {
		assertTrue(Admin.validateLogin("admin"));
		assertFalse(Admin.validateLogin("notAdmin"));
		assertFalse(Admin.validateLogin(""));
		assertFalse(Admin.validateLogin(null));
	}
	
	@Test
	public void testPassword() {
		assertTrue(Admin.validatePassword("orsys"));
		assertTrue(Admin.validatePassword("12orsysAB"));
		assertFalse(Admin.validatePassword("rsys"));
		assertFalse(Admin.validatePassword(""));
		assertFalse(Admin.validatePassword(null));
	}

}
