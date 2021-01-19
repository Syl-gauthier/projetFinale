package model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import exceptions.WrongNameFormatException;

public class Cas {
	private static int nextIdCas;
	private int id, etat;
	private String nom, adresse, codePostale, tel;
	private List<TestPcr> listTest;
	
	// Constructeurs
	public Cas(String nom) throws WrongNameFormatException {
		nextIdCas++;
		this.id = nextIdCas;
		this.setNom(nom);
		this.listTest = new ArrayList<> ();
	}

	// getters / setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) throws WrongNameFormatException {
		if (! Cas.validateNom(nom)) throw new WrongNameFormatException();
		this.nom = nom;
	}

	public int getId() {
		return this.id;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostale() {
		return codePostale;
	}

	public void setCodePostale(String codePostale) {
		this.codePostale = codePostale;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public List<TestPcr> getListTest() {
		return listTest;
	}


	// validation
	public static boolean validateNom(String nom) {
		if (nom == null) return false;
		return Pattern.compile("^[a-z-]+\s[a-z-]+$", Pattern.CASE_INSENSITIVE).matcher(nom).matches();
	}

	public static boolean validateCodePostal(String code) {
		if (code == null) return false; 
		return Pattern.compile("^\\d{4,5}$").matcher(code).matches();
	}

	public static boolean validateAdresse(String adresse) {
		if (adresse == null) return false;
		return adresse.length() >= 8;
	}

	public static boolean validateEtat(int etat) {
		return (etat == -1 || etat == 1);
	}

	public static boolean validateTel(String tel) {
		if(tel == null) return false;
		return Pattern.compile("^(\\+|(00))[0-9]{11,12}$").matcher(tel).matches();
	}
	
	
	public String toString() {
		String str = String.format("Cas %d: %s (%d)%n", this.id, this.nom, this.etat);
		for (TestPcr testPcr : listTest) {
			str += testPcr + "\n";
		};
		return str;
	}
	
	public void addTest(TestPcr test) {
		this.listTest.add(test);
		this.setEtat(test.getResultat());
	}
}
