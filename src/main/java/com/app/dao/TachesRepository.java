package com.app.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.AppUser;
import com.app.entities.Departement;
import com.app.entities.Etat;
import com.app.entities.Taches;


public interface TachesRepository extends JpaRepository<Taches,Long>{
	
	
public Page<Taches> findAll(Pageable pageable);
	
 public Taches findByTitre(String titre);
 
 public Taches findByIdTaches(Long idTaches);
 
 public List<Taches> findByAppUser(AppUser user);
	
 public List<Taches> findByDepartementAndEtats(Departement departement,Etat etat);
 
 @Query("select t from Taches t where  t.appUser.nom like :x")
public Page<Taches> chercherParNom(@Param("x")String nom,Pageable pageable);

 @Query("select t from Taches t where  t.projet like:y")
 public Page<Taches> chercherParProjet(@Param("y")String projet,Pageable pageable);
 
 
 @Query("select t from Taches t where  t.archiver=0 and t.departement.nomDepartement like :x and t.etats.nomEtat like :y" )
 public List<Taches> findTachesNonArchiver(@Param("x")String nomDep,@Param("y")String nomEta);

 
}
