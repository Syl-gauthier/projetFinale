package model;

import java.util.regex.Pattern;

import exceptions.BadCredentialException;

public class Admin {
	
	String login;
	
	public Admin(String login, String password) throws BadCredentialException {
		if(!validateLogin(login) || !validatePassword(password)) throw new BadCredentialException();
		this.login = login;
	}
	
	public static boolean validateLogin(String login) {
		if (login == null) return false;
		return login.equals("admin");
	}
	
	public static boolean validatePassword(String pwd) {
		if (pwd == null) return false;
		return Pattern.compile(".*orsys.*").matcher(pwd).matches();
	}
	
	public String getLogin() {
		return this.login;
	}
}
