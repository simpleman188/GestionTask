package com.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AnnotationRepository;
import com.app.dao.DepartementRepository;
import com.app.dao.EtatRepository;
import com.app.dao.TachesRepository;
import com.app.dao.UserRepository;
import com.app.entities.Annotation;
import com.app.entities.AppUser;
import com.app.entities.Departement;
import com.app.entities.Etat;
import com.app.entities.Taches;



@Service
@Transactional
public class TachesServiceImpl  implements TachesService{

	@Autowired
	public TachesRepository tachesRepository;
	
	@Autowired
	public DepartementRepository departementRepository;

	@Autowired
	public EtatRepository etatRepository;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public AnnotationRepository annotationRepository;
	
	
	@Override
	public Taches saveTaches(Taches taches) {
		return tachesRepository.save(taches);
	}

	@Override
	public void addNomEtatToTaches(Long idTaches, String nomEtat) {

		Taches taches=tachesRepository.findByIdTaches(idTaches);
		Etat etat=etatRepository.findByNomEtat(nomEtat);
		taches.setEtats(etat);
	}

	@Override
	public Taches updateTaches(Taches taches) {
		
		return tachesRepository.saveAndFlush(taches);
	}

	
		

	@Override
	public void addNomDepartementToTaches(Long idTaches, String nomDepartement) {
		Taches taches=tachesRepository.findByIdTaches(idTaches);
        Departement departement=departementRepository.findByNomDepartement(nomDepartement);
        taches.setDepartement(departement);		
	}

	@Override
	public List<Taches> getListTachesByDepartementAndEtat(String nomDepartement, String nomEtat) {
         
		List<Taches> lisTch=tachesRepository.findByDepartementAndEtats(departementRepository.findByNomDepartement(nomDepartement), etatRepository.findByNomEtat(nomEtat));
		
	
		return lisTch;
	}
	

	@Override
	public void updateEtaTache(Long idTache, String nomEtat) {

		Taches taches=tachesRepository.findByIdTaches(idTache);
		Etat etat=etatRepository.findByNomEtat(nomEtat);
		taches.setEtats(etat);
	}

	@Override
	public void updateDescriptionTache(Long idTache, String description) {
		
		Taches taches=tachesRepository.findByIdTaches(idTache);
		
		taches.setDescription(description);
	}

	@Override
	public void updateColorTache(Long idTaches, String color) {

		Taches taches=tachesRepository.findByIdTaches(idTaches);
		taches.setColor(color);
	}

	
	@Override
	public Annotation saveAnno(Annotation annotation) {
		return annotationRepository.save(annotation);
	}
	
	

	
	@Override
	public void AddUserToAnnotation(Long id, String username) {
		AppUser user=userRepository.findByUsername(username);
        Annotation annotation=annotationRepository.findByIdAnnotation(id);
        
        annotation.setUsers(user);
	}

	@Override
	public void AddTacheToAnnotation(Long idAnnotation, long idTaches) {

		Taches taches=tachesRepository.findByIdTaches(idTaches);
		Annotation annotation=annotationRepository.findByIdAnnotation(idAnnotation);
		annotation.setTaches(taches);
	}

	@Override
	public boolean archiverTache(Long iDTaches,boolean arch) {
		Taches taches=tachesRepository.findByIdTaches(iDTaches);
		
		taches.setArchiver(arch);	
		
		return true;
	}

	
	@Override
	public void updateEtat(Long idEtat, String nomEtat) {
		
		Etat etat=etatRepository.findByIdEtat(idEtat);
		etat.setNomEtat(nomEtat);
		
	}

	
	@Override
	public void replaceTacheUser(Long idTache, String nomUser) {

		
		Taches tache=tachesRepository.findByIdTaches(idTache);
		
        AppUser appUser=userRepository.findByNom(nomUser);

		tache.setAppUser(appUser);
		
	}
	
	

	

	
	

	

	
	

	
	
	
	
	

	
}
