package com.app.entities;



import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Taches  implements Serializable{
	
	@Id @GeneratedValue
	private Long idTaches;
	private String titre;
	private String description;
	private String color;
	private String projet;
	
	private boolean archiver;
	
	@Temporal(TemporalType.DATE)
	private Date dateD;
	
	@OneToMany(mappedBy="taches",orphanRemoval = true,cascade=CascadeType.PERSIST)
	@JsonIgnore
	private Set<Annotation> annotation ;
	
	@ManyToOne()
	private  Departement departement ;
	
	
	@ManyToOne()
	private Etat etats;
	

	@ManyToOne()
	private AppUser appUser;

	

	public Taches() {
	}
	






	public Taches(String titre, String description, Date dateD, Set<Annotation> annotation, Departement departement,
			Etat etats, AppUser appUser,String color,String projet,boolean archiver ) {
		super();
		this.titre = titre;
		this.description = description;
		this.dateD = dateD;
		this.color = color;
		this.annotation = annotation;
		this.departement = departement;
		this.etats = etats;
		this.projet = projet;
		this.archiver=archiver;
		this.appUser = appUser;
	}












	public AppUser getAppUser() {
		return appUser;
	}







	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}







	public Long getIdTaches() {
		return idTaches;
	}


	public void setIdTaches(Long idTaches) {
		this.idTaches = idTaches;
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


	public Date getDateD() {
		return dateD;
	}


	public void setDateD(Date dateD) {
		this.dateD = dateD;
	}


	









	public Departement getDepartement() {
		return departement;
	}





	public void setDepartement(Departement departement) {
		this.departement = departement;
	}





	public Etat getEtats() {
		return etats;
	}





	public void setEtats(Etat etats) {
		this.etats = etats;
	}






	public Set<Annotation> getAnnotation() {
		return annotation;
	}






	public void setAnnotation(Set<Annotation> annotation) {
		this.annotation = annotation;
	}







	public String getColor() {
		return color;
	}







	public void setColor(String color) {
		this.color = color;
	}







	public String getProjet() {
		return projet;
	}







	public void setProjet(String projet) {
		this.projet = projet;
	}







	public boolean isArchiver() {
		return archiver;
	}







	public void setArchiver(boolean archiver) {
		this.archiver = archiver;
	}
















	
	
	
}
