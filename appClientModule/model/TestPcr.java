package model;

import exceptions.BadDateFormatException;
import utils.Date;

public class TestPcr {
	static int nextIdTest = 0;
	private final int jour, mois, annee, idTest, resultat;
	
	public TestPcr(int jour, int mois, int annee, int resultat) throws BadDateFormatException {
		super();
		if (! Date.isValid(jour, mois, annee)) throw new BadDateFormatException();
		nextIdTest++;
		this.idTest = TestPcr.nextIdTest;
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
		this.resultat = resultat;
	}

	public int getResultat() {
		return this.resultat;
	}
	
	public String toString() {
		return String.format("%d/%d/%d: %d", this.jour, this.mois, this.annee, this.resultat);
	}
}
