package com.codingdojo.bballjunkie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bballjunkie.models.LoginUser;
import com.codingdojo.bballjunkie.models.Post;
import com.codingdojo.bballjunkie.models.User;
import com.codingdojo.bballjunkie.services.PostServices;
import com.codingdojo.bballjunkie.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserServices uService;
	
	@Autowired
	private PostServices pService;
	
	
	//Get Request
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome.jsp";
	}
	
	@GetMapping("/home")
	public String welcome(Model model,HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/welcome";
		}
		
		User user = uService.findbyId(userId);
		model.addAttribute("user",user);
		model.addAttribute("posts",pService.allPost());
		return "home.jsp";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginUser", new User());
		return "login.jsp";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("newUser", new User());
		return "reg.jsp";
	}
	
	@GetMapping("/logout")
	public String Logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/welcome";
	}
	
	@GetMapping("/profile/{id}")
	public String sessionProfile(@PathVariable("id")Long id, Model model,HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/welcome";
		}
		List<Post> userPosts = pService.findByUserId(userId);
		User user = uService.findbyId(userId);
		model.addAttribute("user", user);
		model.addAttribute("userPosts", userPosts);
		return "userProfile.jsp";
	}
	
	@GetMapping("/edit/profile/{id}")
	public String editProfile(@PathVariable("id")Long id, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/welcome";
		}
		User user = uService.findbyId(id);
		model.addAttribute("user",user);
		return "editProfile.jsp";
		
	
		
	}
	
	
	//Post Request
	@PostMapping("/login")
	public String lgn(@Valid @ModelAttribute("loginUser")LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
		User user = uService.loginAuth(loginUser, result);
		
		if(result.hasErrors()){
			model.addAttribute("newUser", new User());
			return "login.jsp";
		}
		session.setAttribute("userId", user.getId());
		
		return "redirect:/home";
	}
	
	@PostMapping("/register")
	public String reg(@Valid @ModelAttribute("newUser")User regUser, BindingResult result,Model model,HttpSession session) {
		uService.registerValid(regUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("regUser", new LoginUser());
			return "reg.jsp";
			}
		session.setAttribute("userId", regUser.getId());
		return "redirect:/home";
	}
	
	@PutMapping("/profile/edit/{id}")
	public String updateProfile(Model model, @Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		Long managerId = (Long) session.getAttribute("managerId");
		if (managerId==null) {
			return "redirect:/welcome";
		}
		if(result.hasErrors()) {
			return "editProfile.jsp";
		}
		uService.update(user);
		return "redirect:/home";
	}

}
