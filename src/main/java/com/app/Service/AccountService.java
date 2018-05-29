package com.app.Service;

import com.app.entities.AppRole;
import com.app.entities.AppUser;
import com.app.entities.Departement;
import com.app.entities.Etat;





public interface AccountService {
	
	
	
	public AppUser saveUser(AppUser appUser);
	
	
	public AppRole saveRole(AppRole appRole);
	
	
	
	public Departement saveDepartement(Departement departement);
	
	
	public Etat saveEtat(Etat etat);
	
	
	public AppUser findUserByUsername(String username);

	
	public void addRoleToUser(String username,String roleName);
	
	
	
	public void addNomDepartementToUser(String username,String nomDepartement);
	
	public void AddUserToTaches(String titre,String username);
	
	
	public void ReplaceTacheForUser(Long idUser,String nom);

	public void updateDep(Long idDep,String nomDepartement);
	
	public void AddDepToTaches(String titre,String username);

	
	

}
