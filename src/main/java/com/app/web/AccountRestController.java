package com.app.web;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Service.AccountService;
import com.app.dao.DepartementRepository;
import com.app.dao.RoleRepository;
import com.app.dao.UserRepository;
import com.app.entities.AppRole;
import com.app.entities.AppUser;
import com.app.entities.Departement;



@RestController
@RequestMapping("/")
public class AccountRestController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
    private DepartementRepository departementRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	

	@GetMapping("/users")  
	public List<AppUser> ListUsers(){
		
		return userRepository.findAll() ;
		
	}
	
	
	@GetMapping("/roles")  
	public List<AppRole> ListRoles(){
		
		return roleRepository.findAll() ;
		
	}
	
	@DeleteMapping("/users/{idUser}/{nom}")
	public boolean deleteUser(@PathVariable(name="idUser")Long idUser,@PathVariable(name="nom")String nom){
		
		accountService.ReplaceTacheForUser(idUser, nom);
		
		userRepository.deleteById(idUser);
			
		return true;
	}
	
	
	
	
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm userForm){
		
		if(!userForm.getPassword().equals(userForm.getRepassword()))
			throw new RuntimeException("Vous devez Confirmé votre password ! ");
			
			AppUser user=accountService.findUserByUsername(userForm.getUsername());
		
		if(user!=null)throw new RuntimeException("Ce Login existe deja !");

		AppUser appUser=new AppUser();
		
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
		appUser.setEmail(userForm.getEmail());
		appUser.setNom(userForm.getName());
		accountService.saveUser(appUser);
		accountService.addRoleToUser(userForm.getUsername(), userForm.getRole());
		accountService.addNomDepartementToUser(userForm.getUsername(), userForm.getNomDepartement());
        

		return appUser;
	}
	



	/* ..........................................................................................................................................................................  */
	

	@PostMapping("/departements")
	public Departement save(@RequestBody Departement d){
		
		return departementRepository.save(d);
	}
	
	
	@GetMapping("/departements")  
	public List<Departement> ListDepartement(){
		
		return departementRepository.findAll() ;
		
	}
	
	@PutMapping("/departement/{idDepartement}/{nomDepartement}")
	public Departement updateDep(@PathVariable (name="idDepartement") Long idDepartement,@PathVariable(name="nomDepartement") String nomDepartement){	
		
		accountService.updateDep(idDepartement, nomDepartement);
		
	return departementRepository.findByIdDepartement(idDepartement);
	
	}
	
	
	@DeleteMapping("/departements/{idDepartement}")
	public boolean deleteDepartement(@PathVariable(name="idDepartement")Long idDepartement){
		
		departementRepository.deleteById(idDepartement);
	
		return true;
	}
	
	
	
	
	@GetMapping("/departements/listNom")  
	public List<String> ListNomDepartement(){
		
		return departementRepository.getAllWithNomDepartement();
		
	}
	
	/*
	@GetMapping("/departements/{nomDepartement}")  
	public Departement NomDepartement(@PathVariable(name="nomDepartement")String nomDepartement){
		
		return departementRepository.findByNomDepartement(nomDepartement) ;
		
	}*/
	
	/* ..........................................................................................................................................................................  */
	
	

	
}
