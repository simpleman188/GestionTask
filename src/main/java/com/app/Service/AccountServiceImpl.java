package com.app.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AnnotationRepository;
import com.app.dao.DepartementRepository;
import com.app.dao.EtatRepository;
import com.app.dao.RoleRepository;
import com.app.dao.TachesRepository;
import com.app.dao.UserRepository;
import com.app.entities.AppRole;
import com.app.entities.AppUser;
import com.app.entities.Departement;
import com.app.entities.Etat;
import com.app.entities.Taches;



@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserRepository userRepository ;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private DepartementRepository departementRepository;
	
	@Autowired
	public EtatRepository etatRepository;
	
	@Autowired
	public TachesRepository tachesRepository;
	
	@Autowired
	public AnnotationRepository annotationRepository;
	
	
	@Override
	public AppUser saveUser(AppUser appUser) {
		String hashPW=bCryptPasswordEncoder.encode(appUser.getPassword());
		appUser.setPassword(hashPW);
		return userRepository.save(appUser);
	}

	@Override
	public AppRole saveRole(AppRole appRole) {
		return roleRepository.save(appRole);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		AppRole role=roleRepository.findByRoleName(roleName);
		AppUser user=userRepository.findByUsername(username);
		user.getRoles().add(role);
		
		
	}

	@Override
	public AppUser findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	

	@Override
	public Departement saveDepartement(Departement departement) {
		
		return departementRepository.save(departement);
	}

	@Override
	public Etat saveEtat(Etat etat) {
		return etatRepository.save(etat);
	}

	
	@Override
	public void addNomDepartementToUser(String username, String nomDepartement) {
		AppUser user=userRepository.findByUsername(username);
        Departement dpt=departementRepository.findByNomDepartement(nomDepartement);
	   user.setDepartements(dpt);
	    
	}

	@Override
	public void AddUserToTaches(String titre, String username) {
		AppUser user=userRepository.findByUsername(username);
        Taches taches=tachesRepository.findByTitre(titre);
        taches.setAppUser(user);
	}

	
	@Override
	public void ReplaceTacheForUser(Long idUser,String nom) {
       
		AppUser appUser=userRepository.findByIdUser(idUser);
		List<Taches> taches=tachesRepository.findByAppUser(appUser);
		
        AppUser appUser1=userRepository.findByNom(nom);

		taches.forEach(c -> c.setAppUser(appUser1));
	
        
	}
	
	

	@Override
	public void updateDep(Long idDep, String nomDepartement) {
	
		Departement departement=departementRepository.findByIdDepartement(idDep);
		departement.setNomDepartement(nomDepartement);
		

		
	}

	@Override
	public void AddDepToTaches(String titre, String username) {
		
		AppUser user=userRepository.findByUsername(username);
		Departement departement=user.getDepartements();
		 Taches taches=tachesRepository.findByTitre(titre);
	     taches.setDepartement(departement);
		
	}

	

	

	
	
	

	

}
