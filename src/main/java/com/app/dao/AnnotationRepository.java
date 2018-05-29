package com.app.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.Annotation;

public interface AnnotationRepository extends JpaRepository<Annotation, Long>{
	
	@Query("select e from #{#entityName} e where e.taches.idTaches= ?1 ")
   public List<Annotation> findByIdTaches(Long idTaches);

	public Annotation findByIdAnnotation(Long IdAno);
}
