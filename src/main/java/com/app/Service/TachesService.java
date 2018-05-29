package com.app.Service;

import java.util.List;


import com.app.entities.Annotation;
import com.app.entities.Taches;

public interface TachesService {

	public Taches saveTaches(Taches taches);
	public Annotation saveAnno(Annotation annotation);
	
	public Taches updateTaches(Taches taches);
	
	public void addNomEtatToTaches(Long idTaches,String nomEtat);
	
	public void addNomDepartementToTaches(Long idTaches, String nomDepartement);
	
	public List<Taches> getListTachesByDepartementAndEtat(String nomDepartement,String nomEtat);
	
	public void updateEtaTache(Long idTache,String nomEtat);
	
	public void updateDescriptionTache(Long idTache,String description);
	
	public void updateColorTache(Long idTaches,String color);
	
	public void AddUserToAnnotation(Long id,String username);

	public void AddTacheToAnnotation(Long idAnnotation,long idTaches);
	
	public boolean archiverTache(Long iDTaches, boolean arch);
	
	public void updateEtat(Long idEtat,String nomEtat);

	public void replaceTacheUser(Long idTache,String nomUser); 
}
