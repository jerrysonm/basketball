package com.codingdojo.basketballGm.services;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.basketballGm.models.LoginManager;
import com.codingdojo.basketballGm.models.Manager;
import com.codingdojo.basketballGm.repositories.ManagerRepository;

@Service
public class ManagerService {
	@Autowired
	private ManagerRepository managerRepo;
	
	public Manager registerValid(Manager regManager, BindingResult result) {
		Optional<Manager> potentialManager = managerRepo.findByEmail(regManager.getEmail());
		
		if(potentialManager.isPresent()) {
			result.rejectValue("email", "Matches", "Email already exist please use a different email!");
		}
		
		if (!regManager.getPassword().equals(regManager.getConfirmPassword())) {
			result.rejectValue("confrimPassword","Matches","Confrim Password must match password!");
		}
		
		if(result.hasErrors()) {
			return null;
		}
		
		String encryptedPassword = BCrypt.hashpw(regManager.getPassword(), BCrypt.gensalt());
		regManager.setPassword(encryptedPassword);
		return managerRepo.save(regManager);
	}
	
	public Manager loginAuth(LoginManager newLoginObject, BindingResult result) {
		Optional<Manager> potentialManager = managerRepo.findByEmail(newLoginObject.getEmail());
		
		if(!potentialManager.isPresent()) {
			result.rejectValue("email", "Matches", "Invalid login !");
			return null;
		}
		
		Manager manager = potentialManager.get();
		
		if(!BCrypt.checkpw(newLoginObject.getPassword(), manager.getPassword())) {
			result.rejectValue("email", "Matches", "Invalid login!");
		    return null;
		}
		
		if(result.hasErrors()) {
			return null;
		}
		return manager;
	}
	public Manager findById(Long id) {
		Optional<Manager> potentialManager = managerRepo.findById(id);
		if(potentialManager.isPresent()) {
			return potentialManager.get();
			}
		return null;
	}

}
