package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class AppRole {
	
	@Id @GeneratedValue
	private Long idRole;
	private String roleName;
	
	
	


	public AppRole(Long idRole, String roleName) {
		super();
		this.idRole = idRole;
		this.roleName = roleName;
	}


	public AppRole() {
	}


	public Long getIdRole() {
		return idRole;
	}


	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	
	
}
