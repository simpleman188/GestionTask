package com.app.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Annotation implements Serializable {
	
	
	@Id @GeneratedValue
	private Long idAnnotation;
	private String descriptionAnnotation;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne()
	private Taches taches;
	
	
	
	@ManyToOne
	private AppUser users;
	
	
	
	
	
	public Annotation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Annotation(String descriptionAnnotation) {
		super();
		this.descriptionAnnotation = descriptionAnnotation;
	}
	



	public Long getIdAnnotation() {
		return idAnnotation;
	}
	public void setIdAnnotation(Long idAnnotation) {
		this.idAnnotation = idAnnotation;
	}
	public String getDescriptionAnnotation() {
		return descriptionAnnotation;
	}
	public void setDescriptionAnnotation(String descriptionAnnotation) {
		this.descriptionAnnotation = descriptionAnnotation;
	}




	public Taches getTaches() {
		return taches;
	}




	public void setTaches(Taches taches) {
		this.taches = taches;
	}




	public AppUser getUsers() {
		return users;
	}




	public void setUsers(AppUser users) {
		this.users = users;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}




	
	
	
	
}
