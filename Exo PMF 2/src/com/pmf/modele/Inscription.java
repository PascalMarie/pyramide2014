package com.pmf.modele;

import java.util.Date;

public class Inscription {
	protected Date dateInscription;
	
	public Inscription(Date pDateInscription){
		dateInscription = pDateInscription;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
}
