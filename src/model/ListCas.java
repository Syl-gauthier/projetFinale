package model;

import java.util.ArrayList;
import java.util.Iterator;

public class ListCas {
	private ArrayList<Cas> listCas;
	
	public ListCas() {
		listCas = new ArrayList<> ();
	}
	
	public void ajouterCas(Cas c) {
		if (listCas.contains(c)) return;
		listCas.add(c);
	}
	
	public String toString() {
		String str = "ListCas:\n";
		Iterator<Cas> iter = listCas.iterator();
		while(iter.hasNext()) {
			Cas c = iter.next();
			str += String.format("\t%s%n", c);
		}
		return str;
	}
	
	public Cas find(int id) {
		Iterator<Cas> iter = listCas.iterator();
		while(iter.hasNext()) {
			Cas c = iter.next();
			if(c.getId() == id) return c;
		}
		return null;
	}
}
