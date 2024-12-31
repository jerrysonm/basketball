package com.codingdojo.basketballGm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.basketballGm.models.Manager;
import com.codingdojo.basketballGm.models.Player;
import com.codingdojo.basketballGm.services.ManagerService;
import com.codingdojo.basketballGm.services.PlayerService;
import com.codingdojo.basketballGm.services.TeamService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PlayerController {
	@Autowired
	private ManagerService mService; 
	@Autowired 
	private TeamService tService;
	@Autowired 
	private PlayerService pService;
	
	//Get Mapping
	
	@GetMapping("/new/player")
	public String addPlayer(@ModelAttribute("player")Player player, Model model,HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		Manager manger = mService.findById((Long)session.getAttribute("managerId"));
		model.addAttribute("manager", manger);
		model.addAttribute("teams", tService.allTeam());
			return "addPlayer.jsp";
	}
	
	@GetMapping("/player/{id}/cut")
	public String cutPlayer(@PathVariable("id")Long id,HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		Player player = pService.findById(id);
		pService.deletePlayer(player);
		
		return "redirect:/home";

	}
	
	
	
	//Post Mapping 
	
	@PostMapping("/add/player")
	public String newPlayer(@Valid @ModelAttribute("player")Player player, BindingResult result) {
		if (result.hasErrors()) {
			return "addPlayer.jsp";
		}
		pService.createPlayer(player);
		return "redirect:/home";
	}
	
	

}
