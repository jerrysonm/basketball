package com.codingdojo.bballjunkie.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.bballjunkie.models.LoginUser;
import com.codingdojo.bballjunkie.models.User;
import com.codingdojo.bballjunkie.repositories.UserRepository;

@Service
public class UserServices {
	@Autowired
	private UserRepository userRepo;
	
	public User registerValid(User regUser, BindingResult result) {
		Optional<User> potentialUser = userRepo.findByEmail(regUser.getEmail());
		Optional<User> findUsername = userRepo.findByUsername(regUser.getUsername());
		
		if(potentialUser.isPresent()) {
			result.rejectValue("email","Matches", "Email already exist please use different email");
		}
		
		if(findUsername.isPresent()) {
			result.rejectValue("username", "Matches", "Username exists! Login or choose a different username");
		}
		
		if(!regUser.getPassword().equals(regUser.getConfirmPassword())) {
		    result.rejectValue("confirmPassword", "Matches", "The Confirm Password must match Password!");
		}
		
		if (result.hasErrors()) {
			return null;
		}
		
		String encryptedPassword = BCrypt.hashpw(regUser.getPassword(), BCrypt.gensalt());
		regUser.setPassword(encryptedPassword);
		return userRepo.save(regUser);
	}
	
	 public User loginAuth(LoginUser newLoginObject, BindingResult result) {
		 Optional<User> potentialUser = userRepo.findByUsername(newLoginObject.getUsername());
		 
		if(!potentialUser.isPresent()) {
			result.rejectValue("username", "Matches", "Invalid Login");
			return null;
		}
			
		User user = potentialUser.get();
		
		if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
		    result.rejectValue("username", "Matches", "Invalid Login!");
		    return null;
		}
		
		if(result.hasErrors()) {
			return null;
		}
		return user;
	
	 }
	 public User findbyId(Long id) {
		 Optional<User> potentialUser = userRepo.findById(id);
		 if(potentialUser.isPresent()) {
			 return potentialUser.get();
		 }
		 return null;
	 }
	 
	 public List<User>findAll(){
		 return userRepo.findAll();
	 }
	 
	 public User update(User user) {
		 return userRepo.save(user);
	 }
}

