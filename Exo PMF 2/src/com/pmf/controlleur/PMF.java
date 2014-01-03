package com.pmf.controlleur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.pmf.modele.Formation;
import com.pmf.modele.Organisme;
import com.pmf.modele.Stagiaire;
import com.pmf.service.ServiceFormation;
import com.pmf.service.ServiceStagiaire;
import com.pmf.service.exception.TableauFormationsVide;
import com.pmf.service.impl.ServiceFormationImpl;
import com.pmf.service.impl.ServiceStagiaireImpl;

public class PMF {

	public static void main(String[] args) {

		// Creation des organismes
		Organisme org1 = new Organisme("org1@gmail.com", "05050500505", "org1",
				"toto", "12212121212", "Organisme 1");
		Organisme org2 = new Organisme("org2@gmail.com", "05050500505", "org2",
				"toto", "12212223333", "Organisme 2");

		// Création des formations
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Stagiaire> listestagiaire = new ArrayList<Stagiaire>();
		List<Integer> listeNotes = new ArrayList<Integer>();
		Formation form1=null;
		Formation form2=null;
		Formation form3=null;
		Formation form4=null;
		try {
			form1 = new Formation("Formation Java", "Toulouse",
					"Formation au java", sdf.parse("01/02/2014"), new Date(), 20, "bac+2", org1,
					listestagiaire, listeNotes);
			form2 = new Formation("Formation JEE", "Toulouse",
					"Formation au java entreprise edition", new Date(), new Date(),
					20, "bac+2 et java", org1, listestagiaire, listeNotes);
			form3 = new Formation("Formation EJB", "Toulouse",
					"Formation au entreprise java bean", new Date(), new Date(),
					20, "bac+2 JEE", org2, listestagiaire, listeNotes);
			form4 = new Formation("Formation JSF", "Toulouse",
					"Formation au java server faces", new Date(), new Date(), 20,
					"bac+2 et JEE", org2, listestagiaire, listeNotes);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		// ajout des formations au tableau du service
		ServiceFormation sf1 = new ServiceFormationImpl();
		System.out.println("Ajout " + form1.getNomFormation());
		sf1.ajouterFormation(form1);
		System.out.println("Ajout " + form2.getNomFormation());
		sf1.ajouterFormation(form2);
		System.out.println("Ajout " + form3.getNomFormation());
		sf1.ajouterFormation(form3);
		System.out.println("Ajout " + form4.getNomFormation());
		sf1.ajouterFormation(form4);

		// inscription à la plateforme de stagiaire 1
		ServiceStagiaire ssi1 = new ServiceStagiaireImpl();
		Stagiaire inscrStag1 = ssi1.inscriptionPlateforme("stag1@gmail.com",
				"0263215876", "stag1", "mdp01");
		// inscriptionPlateforme à la plateforme de stagiaire 2
		Stagiaire inscrStag2 = ssi1.inscriptionPlateforme("stag2@gmail.com",
				"0263247896", "stag2", "mdp02");
		// inscription à la plateforme de stagiaire 3
		Stagiaire inscrStag3 = ssi1.inscriptionPlateforme("stag3@gmail.com",
				"0578614050", "stag3", "mdp03");

		// connexion à la plateforme du 1er stagiaire
		BufferedReader br1;
		BufferedReader br2;
		String login = null;
		String mdp = null;
		boolean conditionStop1 = false;
		while (!conditionStop1) {
			System.out.println("Saisissez votre login, s'il vous plait :");
			br1 = new BufferedReader(new InputStreamReader(System.in));
			try {
				login = br1.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			System.out
					.println("Saisissez votre mot de passe, s'il vous plait : ");
			br2 = new BufferedReader(new InputStreamReader(System.in));
			try {
				mdp = br2.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// Vérification des identifiants et mots de passes
			int indice=ssi1.connexion(login,mdp);
			if (indice >= 0) {
				System.out.println("connexion réussie du stagiaire"+ServiceStagiaireImpl.listeStagiaires.get(indice).getIdentifiant());
				conditionStop1 = true;
			} else {
				System.err.println("connexion échouée");
				continue;
			}
		}
		
		
		
		
		//ssi1.connexion(inscrStag1);
		ServiceFormation servform1 = new ServiceFormationImpl();
		ServiceStagiaire servstag1 = new ServiceStagiaireImpl();
		// inscription à une formation
		List<Formation> formationsRetenues1 = rechercheFormationsInscription();
		servform1.inscrireStagiaire(servstag1.choisirFormation(formationsRetenues1), inscrStag1);
		// notation d'une formation
		 servform1.evaluerFormation(form3);
		
		// connexion à la plateforme du 2eme stagiaire
		//ssi1.connexion(inscrStag2);
		// inscription à une formation
		List<Formation> formationsRetenues2 = rechercheFormationsInscription();
		servform1.inscrireStagiaire(servstag1.choisirFormation(formationsRetenues2), inscrStag2);
		// notation d'une formation
		// servform2.evaluerFormation(form1);
		
		// connexion à la plateforme du 3eme stagiaire
		//ssi1.connexion(inscrStag3);
		// inscription à une formation
		List<Formation> formationsRetenues3 = rechercheFormationsInscription();
		servform1.inscrireStagiaire(servstag1.choisirFormation(formationsRetenues3), inscrStag3);
		// notation d'une formation
		// servform3.evaluerFormation(form4);

	}

	private static List<Formation> rechercheFormationsInscription() {
		BufferedReader br;
		String motCleSaisi = "";
		boolean conditionArret = false;
		List<Formation> formationRecherchee = new ArrayList<Formation>();
		// TODO déplacer dans le main la saisie

		// boucle qui affiche les formations recherchees
		while (!conditionArret) {
			// saisie du mot clé
			System.out.println("Veuillez saisir un mot-clé, s'il vous plait :");
			br = new BufferedReader(new InputStreamReader(System.in));
			try {
				motCleSaisi = br.readLine();
				// motCleSaisi = motCleSaisi.toLowerCase();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (!motCleSaisi.equals("EXIT")) {
				// recherche des formation en fonction du mot clé et affichage
				ServiceFormation sf1 = new ServiceFormationImpl();
				try {
					formationRecherchee = sf1.rechercherFormation(motCleSaisi);
				} catch (TableauFormationsVide e) {
					System.err.println(e.getMessage());
				}
				for (int i = 0; i < formationRecherchee.size(); i++) {
					sf1.afficherFormation(formationRecherchee.get(i));
				}
			} else {
				// on sort
				conditionArret = true;
				System.out
						.println("La recherche est terminée!\n-------------\n");
			}
		}
		return formationRecherchee;
	}
}