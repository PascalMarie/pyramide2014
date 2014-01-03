package com.pmf.modele;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Formation {
	protected String nomFormation;
	protected String lieu;
	protected String description;
	protected Date dateDebut;
	protected Date dateFin;
	protected Integer nbHeure;
	protected String preRequis;
	protected Organisme organisme;
	protected List<Stagiaire> listeStagiaires;
	protected List<Integer> listeNotes;

	public Formation(String nomFormation, String lieu, String description,
			Date dateDebut, Date dateFin, Integer nbHeure, String preRequis,
			Organisme organisme, List<Stagiaire> listeStagiaires, List<Integer> listeNotes) {
		super();
		this.nomFormation = nomFormation;
		this.lieu = lieu;
		this.description = description;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbHeure = nbHeure;
		this.preRequis = preRequis;
		this.organisme = organisme;
		this.listeStagiaires = listeStagiaires;
		this.listeNotes = listeNotes;
	}

	public String getNomFormation() {
		return nomFormation;
	}


	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}


	public String getLieu() {
		return lieu;
	}


	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDateDebut() {
		return dateDebut;
	}


	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}


	public Date getDateFin() {
		return dateFin;
	}


	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}


	public Integer getNbHeure() {
		return nbHeure;
	}


	public void setNbHeure(Integer nbHeure) {
		this.nbHeure = nbHeure;
	}


	public String getPreRequis() {
		return preRequis;
	}


	public void setPreRequis(String preRequis) {
		this.preRequis = preRequis;
	}


	public Organisme getOrganisme() {
		return organisme;
	}


	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}

	public List<Stagiaire> getListeStagiaires() {
		return listeStagiaires;
	}

	public void setListeStagiaires(List<Stagiaire> listeStagiaires) {
		this.listeStagiaires = listeStagiaires;
	}

	public List<Integer> getListeNotes() {
		return listeNotes;
	}

	public void setListeNotes(List<Integer> listeNotes) {
		this.listeNotes = listeNotes;
	}

	@Override
	public String toString() {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return "-------------\nnom formation : " + nomFormation + "\n" + "lieu : "
				+ lieu + "\n" + "description : " + description + "\n"
		 + "date de debut : " + ((dateDebut!=null)?simpleDateFormat.format(dateDebut):"") + "\n"
		 + "date de fin : " + simpleDateFormat.format(dateFin);
		// TODO vérifier date nulle
		
	}
}
