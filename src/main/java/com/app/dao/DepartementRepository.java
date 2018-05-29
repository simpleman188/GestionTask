package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.AppUser;
import com.app.entities.Departement;


public interface DepartementRepository extends JpaRepository<Departement,Long> {

	public Departement findByNomDepartement(String nomDepartement);
	
	@Query("select d.nomDepartement from #{#entityName} d")
	public List<String> getAllWithNomDepartement();

	public Departement findByUsers(AppUser user);
	
	public Departement findByIdDepartement(Long IdDep);
}
