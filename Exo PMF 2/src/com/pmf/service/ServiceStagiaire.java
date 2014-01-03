package com.pmf.service;

import java.util.List;

import com.pmf.modele.Formation;
import com.pmf.modele.Stagiaire;

public interface ServiceStagiaire  {
	/**
	 * crée un nouveau stagiaire et l'ajoute à la liste des stagiaires
	 * @param pAdresseEmail
	 * @param pTelephone
	 * @param pIdentifiant
	 * @param pMotDePasse
	 * @return 
	 */
	public Stagiaire inscriptionPlateforme(String pAdresseEmail, String pTelephone, String pIdentifiant, String pMotDePasse);
	
	/**
	 * demande la saisie du login et du mot de passe du stagiaire et vérifie avec les données enregistrées à l'inscription 
	 * @param pStagiaire
	 */
	public int connexion(String login,String mdp);


	
	/**
	 *demande la saisie du nom de la formation désiré, vérifie sa présence dans le tableau de formation recherchée par mot-clé
	 * et definit la formation désirée comme formation choisie  
	 * @param pListeChoix
	 * @return
	 */
	public Formation choisirFormation(List<Formation> pListeChoix);
	
}
