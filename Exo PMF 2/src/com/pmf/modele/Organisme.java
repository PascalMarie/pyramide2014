package com.pmf.modele;

public class Organisme extends Utilisateur{
	String siret;
	String raisonSociale;
	
	public Organisme(String adresseEMail, String telephone, String identifiant,
			String motDePasse, String siret, String raisonSociale) {
		super(adresseEMail, telephone, identifiant, motDePasse);
		this.siret = siret;
		this.raisonSociale = raisonSociale;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	
	
}
