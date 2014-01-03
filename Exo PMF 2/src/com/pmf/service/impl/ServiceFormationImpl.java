package com.pmf.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.pmf.modele.Formation;
import com.pmf.modele.Stagiaire;
import com.pmf.service.ServiceFormation;
import com.pmf.service.exception.TableauFormationsVide;

public class ServiceFormationImpl implements ServiceFormation {
	static List<Formation> tabFormations = new ArrayList<Formation>();
	static int nbFormations = 0;
	static List<Integer> listeNotes = new ArrayList<Integer>();

	/**
	 * Ajoute la formation au tableau des formations
	 * @param pFormation la formation � ajouter
	 */
	public void ajouterFormation(Formation pFormation) {
		if (nbFormations>=10)
			// TODO ListePleineException
			System.out.println("Liste pleine !");
		else  {
		tabFormations.add(pFormation);
		System.out.println("La formation a bien �t� ajout�e !");
		nbFormations++;
		}
	}

	/**
	 * Affiche une formation
	 * @param f la formation � afficher
	 */
	public void afficherFormation(Formation f) {
		System.out.println(f);
	}

	/**
	 * R�cup�re les formations correspondantes au mot cl�
	 * 
	 * @param motCle le mot cl� � rechercher
	 * @return la ou les formations trouv�es
	 * @throws TableauFormationsVide 
	 */
	public List<Formation> rechercherFormation(String motCle) throws TableauFormationsVide {
		
		// TODO TableauFormationsVide si le tableau des formations est vide
		if (tabFormations.isEmpty())
			throw new TableauFormationsVide("Tableau des formations vide !!");
		motCle = motCle.toLowerCase();
		Formation f;
		List<Formation> resultRecherche = new ArrayList<Formation>();
		// parcours le tableau des formations
		for (int i = 0; i < ServiceFormationImpl.nbFormations; i++) {
			f = ServiceFormationImpl.tabFormations.get(i);
			// si la formation existe, v�rifie si elle contient le motCle et la m�morise dans les r�sultats de recherche
			if (f != null) {
				if (f.getNomFormation().toLowerCase().contains(motCle)
						|| f.getDescription().toLowerCase().contains(motCle)) {
					resultRecherche.add(f);
				}
			}
		}
		return resultRecherche;
	}
	
	/**
	 * ajoute un stagiaire (pour l'inscire) dans une liste de stagiaire 
	 * associ�e � une foramtion donn�e (� laquelle le stagiaire souhaite s'inscrire)
	 * @param formation
	 * @param stagiaire
	 * @return
	 */
	public List<Stagiaire> inscrireStagiaire(Formation formation, Stagiaire stagiaire){
		// TODO FormationDemarreeException    si datedebut d�pass�e
		
		formation.getListeStagiaires().add(stagiaire);
		System.out.println("Le stagiaire "+ stagiaire.getIdentifiant() + " a �t� ajout� avec succ�s � la formation "+ formation.getNomFormation() + "!");
		return formation.getListeStagiaires();
	}

	/**
	 * demande la saisie d'une note pour noter une formation
	 * @param formation
	 */
	@Override
	public void evaluerFormation(Formation formation) {
		// TODO d�placer la saisie dans le main
		BufferedReader br;
		int note = 0;
		// TODO boucler tant que la note n'est pas valide
		System.out.println("Veuillez noter la formation, s'il vous plait :");
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			note = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO lier la note � un stagiaire
		ServiceFormationImpl.listeNotes.add(note);
	}	
}
