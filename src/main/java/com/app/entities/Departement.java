package com.app.entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Departement implements Serializable {

	
	@Id @GeneratedValue
	private Long idDepartement;
	private String nomDepartement;
	
	@OneToMany(mappedBy="departements")
	@JsonIgnore
	private Set<AppUser> users;
	
	
	@OneToMany(mappedBy="departement")
	@JsonIgnore
	private Set<Taches> taches;
	

	


	public Departement(String nomDepartement, Set<AppUser> users, Set<Taches> taches) {
		super();
		this.nomDepartement = nomDepartement;
		this.users = users;
		this.taches = taches;
	}



	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Long getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}



	public Set<AppUser> getUsers() {
		return users;
	}



	public void setUsers(Set<AppUser> users) {
		this.users = users;
	}



	public Set<Taches> getTaches() {
		return taches;
	}



	public void setTaches(Set<Taches> taches) {
		this.taches = taches;
	}



	
	
	

	

	
}
