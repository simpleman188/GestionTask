package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AppUser;



public interface UserRepository extends JpaRepository<AppUser,Long> {
	
	public AppUser findByUsername(String username);
	
	public AppUser findByNom(String nom);
	
	public AppUser findByIdUser(Long IdUser);
	


}
