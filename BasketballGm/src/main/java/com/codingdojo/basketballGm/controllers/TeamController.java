package com.codingdojo.basketballGm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.basketballGm.models.Manager;
import com.codingdojo.basketballGm.models.Player;
import com.codingdojo.basketballGm.models.Team;
import com.codingdojo.basketballGm.services.ManagerService;
import com.codingdojo.basketballGm.services.PlayerService;
import com.codingdojo.basketballGm.services.TeamService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TeamController {
	@Autowired
	private ManagerService mService; 
	@Autowired 
	private TeamService tService;
	@Autowired 
	private PlayerService pService;
	
	//Get Mapping
	
	@GetMapping("/new/team")
	public String addTeam(@ModelAttribute("team")Team team, Model model, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		Manager manger = mService.findById((Long)session.getAttribute("managerId"));
		model.addAttribute("manager", manger);
		 return "addTeam.jsp";
	}
	
	@GetMapping("/team/{id}")
	public String teamInfo(@PathVariable("id")Long id, Model model,HttpSession session ) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		Team team = tService.findById(id);
		model.addAttribute("team",team);
		model.addAttribute("players", pService.allPlayer());
		model.addAttribute("manager", mService.findById((Long)session.getAttribute("managerId")));
		return "teamPage.jsp";
	}
	
	@GetMapping("/team/{id}/resign")
	public String managerResign(@PathVariable("id")Long id, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		Team team = tService.findById(id);
		tService.delete(team);
		
		return "redirect:/home";
	}
	
	@GetMapping("/team/{id}/edit")
	public String editTeamPage(@PathVariable("id")Long id, Model model, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		Team team = tService.findById(id);
		model.addAttribute("team", team);
		model.addAttribute("manager", mService.findById((Long)session.getAttribute("managerId")));
		return "editTeam.jsp";
	}
	
	
	//Post Mapping
	
	@PostMapping("/add/team")
	public String newTeam(@Valid @ModelAttribute("team")Team team, BindingResult result) {
		if (result.hasErrors()) {
			return "addTeam.jsp";
		}
		tService.create(team);
		return "redirect:/home";
	}
	
	@PutMapping("/team/edit/{id}")
	public String editTeam(Model model,@Valid @ModelAttribute("team")Team team, BindingResult result, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		if(result.hasErrors()) {
			return "editTeam";
		}
		tService.update(team);
		return "redirect:/home";
	}
	
	

}
