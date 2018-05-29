package com.app.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Etat implements Serializable {

	
	
	@Id @GeneratedValue
	private Long idEtat;
	private String nomEtat;
	
	@OneToMany(mappedBy="etats")
	@JsonIgnore
	private Set<Taches> taches;
	
	
	


	public Etat(String nomEtat) {
		super();
		this.nomEtat = nomEtat;
	}


	public Etat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getIdEtat() {
		return idEtat;
	}


	public void setIdEtat(Long idEtat) {
		this.idEtat = idEtat;
	}


	public String getNomEtat() {
		return nomEtat;
	}


	public void setNomEtat(String nomEtat) {
		this.nomEtat = nomEtat;
	}


	public Set<Taches> getTaches() {
		return taches;
	}


	public void setTaches(Set<Taches> taches) {
		this.taches = taches;
	}


	
	
	
	
}
