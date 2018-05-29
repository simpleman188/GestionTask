package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Etat;

public interface EtatRepository extends JpaRepository<Etat,Long> {

	public Etat findByNomEtat(String nomEtat);
	
	public Etat findByIdEtat(Long idEtat);

	@Query("select e.nomEtat from #{#entityName} e")
	public List<String> getAllWithNomEtat();
}
