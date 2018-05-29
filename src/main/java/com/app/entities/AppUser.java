package com.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;





@Entity
public class AppUser implements Serializable {
	
	
	@Id @GeneratedValue
	private Long idUser;
	private String nom;
	
	@Column(unique=true) 
	private String username;
	
	@OneToMany(mappedBy="users",cascade=CascadeType.REMOVE)
	@JsonIgnore
	private Set<Annotation> annotation;
	
	private String password;
	private String email;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles=new ArrayList<>();
	
	
	@ManyToOne()
	private Departement departements;
	

	@OneToMany(mappedBy="appUser")
	@JsonIgnore
	private Set<Taches> taches;

	

	public AppUser() {
		
	}




	public AppUser(String nom, String username, String password, String email, Collection<AppRole> roles,
			Departement departements, Set<Taches> taches) {
		super();
		this.nom = nom;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roles = roles;
		this.departements = departements;
		this.taches = taches;
	}




	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<AppRole> getRoles() {
		return roles;
	}

	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}









	public Departement getDepartements() {
		return departements;
	}









	public void setDepartements(Departement departements) {
		this.departements = departements;
	}









	public Set<Taches> getTaches() {
		return taches;
	}









	public void setTaches(Set<Taches> taches) {
		this.taches = taches;
	}




	public Set<Annotation> getAnnotation() {
		return annotation;
	}




	public void setAnnotation(Set<Annotation> annotation) {
		this.annotation = annotation;
	}











	

	
	
}
