package com.app.web;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.AccountService;
import com.app.Service.TachesService;
import com.app.dao.AnnotationRepository;
import com.app.dao.DepartementRepository;
import com.app.dao.EtatRepository;
import com.app.dao.TachesRepository;
import com.app.entities.Annotation;
import com.app.entities.Departement;
import com.app.entities.Etat;
import com.app.entities.Taches;


@RestController
@RequestMapping("/")
public class TachesRestController {
	
	@Autowired
	private TachesRepository tachesRepository;
	
	@Autowired
	private EtatRepository etatRepository;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TachesService tacheService;
	
	
	@Autowired
	private AnnotationRepository annotationRepository;
	
	

	
	
	@GetMapping("/taches")
	public List<Taches> listTaches(){
		
		return tachesRepository.findAll();
	}
	
	@GetMapping("/tachesNonArchiver/{nomDepartement}/{nomEtat}")
	public List<Taches> listTachesNonArchiver(@PathVariable (name="nomDepartement")String nomDepartement,@PathVariable (name="nomEtat")String nomEtat){
		
		return tachesRepository.findTachesNonArchiver(nomDepartement,nomEtat);
	}
	

	
	@GetMapping("/taches/{idTaches}")  
	public Taches getTache(@PathVariable (name="idTaches")Long idTaches){
		return tachesRepository.findByIdTaches(idTaches);
	}
	
	
	
	@DeleteMapping("/taches/{idTaches}")
	public boolean deleteTaches(@PathVariable(name="idTaches")Long idTaches){
		
		tachesRepository.deleteById(idTaches);;
		return true;

	}
	
	@GetMapping("/taches/{nomDepartement}/{nomEtat}")  
	public List<Taches> ListTaches(@PathVariable (name="nomDepartement")String nomDepartement,@PathVariable (name="nomEtat")String nomEtat){
		
		return tacheService.getListTachesByDepartementAndEtat(nomDepartement, nomEtat);
		
	}
	
	
	@PostMapping("/newTaches")
	public Taches newTache(@RequestBody NewTacheForm newTacheForm){
		
		
		Taches taches=new Taches();
		taches.setTitre(newTacheForm.getTitre());
		taches.setDescription(newTacheForm.getDescription());
		taches.setDateD(newTacheForm.getDateD());
		taches.setColor(newTacheForm.getColor());
		taches.setProjet(newTacheForm.getProjet());

		tacheService.saveTaches(taches);
		tacheService.addNomEtatToTaches(taches.getIdTaches(),newTacheForm.getEtat());
		accountService.AddDepToTaches(newTacheForm.getTitre(), newTacheForm.getNom());
		accountService.AddUserToTaches(newTacheForm.getTitre(), newTacheForm.getNom());
     	return taches;
	}
	
	


	@PutMapping("/editTache/{idTaches}")
	public Boolean updateTaches(@RequestBody EditForm editForm,@PathVariable(name="idTaches") Long idTaches){
		
		Taches taches=tachesRepository.findByIdTaches(idTaches);	
		taches.setTitre(editForm.getTitre());
		taches.setDescription(editForm.getDescription());
		taches.setDateD(editForm.getDateD());
		tacheService.updateTaches(taches);
		

		return true;
		
	}
	
	
	
	
	@PutMapping("/changerTacheUser/{idTache}/{nom}")
	public boolean ChangerTacheUser(@PathVariable (name="idTache") Long idTache,@PathVariable(name="nom") String nom){	
		
		tacheService.replaceTacheUser(idTache, nom);
		
	    return true;
	
	}
	
	
	
	
	
/*	@PostMapping("/taches")
	public Taches save(@RequestBody Taches t){
		
		return tachesRepository.save(t);
	}
	*/
	
	/* ..........................................................................................................................................................................  */
	
	
	
	@PostMapping("/etats")
	public Etat save(@RequestBody Etat E){
		
		return etatRepository.save(E);
	}
	
	
	@GetMapping("/etats")  
	public List<Etat> ListEtat(){
		
		return etatRepository.findAll() ;
		
	}
	

	@GetMapping("/etats/listNom")  
	public List<String> ListNomEtat(){
		
		return etatRepository.getAllWithNomEtat();
		
	}
	
	
	@PutMapping("/updateEtat/{idEtat}/{nomEtat}")
	public Etat updateEtat(@PathVariable (name="idEtat") Long idEtat,@PathVariable(name="nomEtat") String nomEtat){	
		
        tacheService.updateEtat(idEtat, nomEtat);
		
	    return etatRepository.findByIdEtat(idEtat);
	
	}
	
	
	@DeleteMapping("/etats/{idEtats}")
	public boolean deleteEtats(@PathVariable(name="idEtats")Long idEtats){
		
		etatRepository.deleteById(idEtats);
		
		return true;

	}
	
	@PutMapping("/etat/{idTaches}/{nomEtat}")
	public Taches updateEtatTache(@PathVariable (name="idTaches") Long idTaches,@PathVariable(name="nomEtat") String nomEtat){	
		tacheService.updateEtaTache(idTaches, nomEtat);
		return tachesRepository.findByIdTaches(idTaches);
		
	}
	
	
	
	/* ..........................................................................................................................................................................  */
	
	
	
	
	@GetMapping("/annotation")  
	public List<Annotation> ListAnno(){
		
		return annotationRepository .findAll();
		
	}
	
	@PostMapping("/annotation")
	public Annotation save(@RequestBody Annotation a){
		
		return annotationRepository.save(a);
	}
	
	
	@GetMapping("/annotation/{idTaches}")  
	public List<Annotation> getAnnotation(@PathVariable (name="idTaches")Long idTaches){

		return annotationRepository.findByIdTaches(idTaches);
	}
	

	@PostMapping("/newAnno")
	public Annotation newAnno(@RequestBody NewAnnotation newAnnotation){
		
		
		Annotation annotation=new Annotation();
		
		annotation.setDescriptionAnnotation(newAnnotation.getDescriptionAnnotation());
		annotation.setDate(newAnnotation.getDateAjout());
		tacheService.saveAnno(annotation);
		tacheService.AddUserToAnnotation(annotation.getIdAnnotation(),newAnnotation.getUsername());
		tacheService.AddTacheToAnnotation(annotation.getIdAnnotation(), newAnnotation.getIdTache());
		
     	return annotation;
	}
	
	

	
	@DeleteMapping("/SupAnnotation/{idAnnotation}")
	public boolean deleteAnnno(@PathVariable(name="idAnnotation")Long idAnnotation){
		
		annotationRepository.deleteById(idAnnotation);
		
		return true;

	}
	
	
	/* ..........................................................................................................................................................................  */
	
	
	
	
	

	@PutMapping("/color/{idTaches}/{color}")
	public Taches updateColorTache(@PathVariable (name="idTaches") Long idTaches,@PathVariable(name="color") String color){	
		tacheService.updateColorTache(idTaches, color);
		return tachesRepository.findByIdTaches(idTaches);
		
	}
	
	
	
	@GetMapping("/chercherTachesByNom")  
	public Page<Taches> chercherByNom(
			@RequestParam (name="nom",defaultValue="") String nom,
			@RequestParam (name="page",defaultValue="0") int page,
			@RequestParam (name="size",defaultValue="5") int size) {
	
   
    	return tachesRepository.chercherParNom(nom+"%", new PageRequest(page, size));
    	
	}
	
	
	@GetMapping("/chercherTachesByProjet")  
	public Page<Taches> chercherByProjet(
			@RequestParam (name="projet",defaultValue="") String projet,
			@RequestParam (name="page",defaultValue="0") int page,
			@RequestParam (name="size",defaultValue="5") int size) {
	
   
    	return tachesRepository.chercherParProjet(projet+"%", new PageRequest(page, size));
    	
	}
	
	
	@PutMapping("/archiver/{idTaches}/{archiv}")
	
	public Boolean Archiver(@PathVariable(name="idTaches") Long idTaches,@PathVariable boolean archiv){

		return tacheService.archiverTache(idTaches, archiv);
		
		
		
	}
	
	
}
