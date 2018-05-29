package com.app.web;

import java.util.Date;

public class NewTacheForm {
	
	private String titre;
	private String description;
	private String etat;
	private Date dateD;
	private String nom;
	private String color;
	private String projet;
	

	

	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Date getDateD() {
		return dateD;
	}
	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getProjet() {
		return projet;
	}
	public void setProjet(String projet) {
		this.projet = projet;
	}
	
	
	
	
	
	

}
