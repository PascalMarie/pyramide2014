package com.pmf.service;

import java.util.List;

import com.pmf.modele.Formation;
import com.pmf.modele.Stagiaire;
import com.pmf.service.exception.TableauFormationsVide;

public interface ServiceFormation {
	
	/**
	 * Ajoute la formation au tableau des formations
	 * @param pFormation la formation � ajouter
	 */
	public void ajouterFormation(Formation pFormation);
	
	public void afficherFormation(Formation f);
	
	/**
	 * R�cup�re les formations correspondantes au mot cl�
	 * 
	 * @param motCle le mot cl� � rechercher
	 * @return la ou les formations trouv�es
	 * @throws TableauFormationsVide 
	 */
	public List<Formation> rechercherFormation(String motCle) throws TableauFormationsVide;
	
	/**
	 * ajoute un stagiaire (pour l'inscire) dans une liste de stagiaire 
	 * associ�e � une foramtion donn�e (� laquelle le stagiaire souhaite s'inscrire) 
	 * @param formation
	 * @param stagiaire
	 * @return
	 */
	public List<Stagiaire> inscrireStagiaire(Formation formation, Stagiaire stagiaire);
	
	/**
	 * demande la saisie d'une note pour noter une formation
	 * @param formation
	 */
	public void evaluerFormation(Formation formation);	
}
