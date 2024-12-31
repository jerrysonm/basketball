package com.codingdojo.basketballGm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.basketballGm.models.LoginManager;
import com.codingdojo.basketballGm.models.Manager;
import com.codingdojo.basketballGm.services.ManagerService;
import com.codingdojo.basketballGm.services.PlayerService;
import com.codingdojo.basketballGm.services.TeamService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ManagerController {
	@Autowired 
	private ManagerService mService; 
	@Autowired 
	private TeamService tService;
	
	
	//Get request
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome.jsp";
	}
	
	@GetMapping("/login")
	public String Login(Model model) {
		model.addAttribute("loginManager", new LoginManager());
		return "login.jsp";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("newManager", new Manager());
		return "register.jsp";
	}
	
	@GetMapping("/home")
	public String home(Model model,HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		Manager manager = mService.findById(managerId);
		model.addAttribute("manager", manager);
		model.addAttribute("teams", tService.allTeam());
		return "home.jsp";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("managerId", null);
		return "redirect:/welcome";
	}
	
	
	//Post Request
	
	@PostMapping("/login")
	public String lgn(@Valid @ModelAttribute("loginManager")LoginManager loginManager, BindingResult result,Model model, HttpSession session) {
		Manager manager = mService.loginAuth(loginManager, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newManager", new Manager());
			return "login.jsp";
		}
		session.setAttribute("managerId", manager.getId());
		
		return "redirect:/home";
	}
	
	@PostMapping("/register")
	public String reg(@Valid @ModelAttribute("newManager")Manager regManager, BindingResult result,Model model, HttpSession session) {
		mService.registerValid(regManager, result);
		
		if(result.hasErrors()) {
			model.addAttribute("regManager", new LoginManager());
			return "register.jsp";
		}
		
		session.setAttribute("managerId", regManager.getId());
		return "redirect:/home";
		
	}
	

}
