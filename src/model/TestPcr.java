package model;

import exceptions.BadDateFormatException;
import utils.Date;

public class TestPcr {
	private final int jour, mois, annee, idTest, resultat;
	
	public int getJour() {
		return jour;
	}

	public int getMois() {
		return mois;
	}

	public int getAnnee() {
		return annee;
	}

	public int getIdTest() {
		return idTest;
	}

	public TestPcr(int id, int jour, int mois, int annee, int resultat) throws BadDateFormatException {
		super();
		if (! Date.isValid(jour, mois, annee)) throw new BadDateFormatException();
		this.idTest = id;
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
