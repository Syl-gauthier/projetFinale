import java.util.Scanner;

import exceptions.BadCredentialException;
import exceptions.WrongNameFormatException;
import model.Admin;
import model.Cas;
import model.ListCas;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Admin admin = null;
		while(admin == null) {
			System.out.println("Login:");
			String login = "admin";
			System.out.println("password:");
			String password = "orsys";
			try {
				System.out.println(login + " " + password);
				admin = new Admin(login, password);
			} catch (BadCredentialException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Connected as:" + admin.getLogin());
		System.out.println("Nombre de cas à ajouter:");
		int nbrCas = sc.nextInt();
		sc.nextLine();
		ListCas lc = new ListCas();
		for (int i=0; i< nbrCas; i++) {
			System.out.println("Cas "+i);
			Cas c =null;
			
			while(c == null) {
				System.out.println("Nom du patient:");
				String nom = sc.nextLine();
				System.out.println("Prenom du patient:");
				String prenom = sc.nextLine();
				String nomComplet = nom+" "+prenom;
				try {
					c = new Cas(1, nomComplet);
				} catch (WrongNameFormatException e) {
					System.out.println("Nom invalide, veuillez re-essayer");
					e.printStackTrace();
				}
			}
			System.out.println("Adresse du patient:");
			String adresse = sc.nextLine();
			if(Cas.validateAdresse(adresse)) c.setAdresse(adresse);
			System.out.println("Code postale du patient:");
			String codePostal = sc.nextLine();
			if(Cas.validateCodePostal(codePostal)) c.setCodePostale(codePostal);
			System.out.println("No. de tel. du patient:");
			String tel = sc.nextLine();
			if(Cas.validateTel(tel)) c.setTel(tel);
			System.out.println("Etat du patient:");
			int etat = sc.nextInt();
			if(Cas.validateEtat(etat)) c.setEtat(etat);
			lc.ajouterCas(c);
		}
		sc.close();
		
		
		
		System.out.println(lc);
	}

	public Main() {
		super();
	}

}