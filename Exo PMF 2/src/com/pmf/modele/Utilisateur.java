package com.pmf.modele;

/**
 * Un utilisateur de la place de marché
 */
public abstract class Utilisateur {
	protected String adresseEMail;
	protected String telephone;
	protected String identifiant;
	protected String motDePasse;
	
	public Utilisateur(String adresseEMail, String telephone,
			String identifiant, String motDePasse) {
		super();
		this.adresseEMail = adresseEMail;
		this.telephone = telephone;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
	}

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public String getAdresseEMail() {
		return adresseEMail;
	}

	public void setAdresseEMail(String adresseEMail) {
		this.adresseEMail = adresseEMail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
}
