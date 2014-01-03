package com.pmf.modele;

public class Stagiaire extends Utilisateur {
	public Stagiaire(){
		super();
	}
	public Stagiaire(String adresseEMail, String telephone, String identifiant, String motDePasse){
		super(adresseEMail, telephone, identifiant, motDePasse);
	}
}
