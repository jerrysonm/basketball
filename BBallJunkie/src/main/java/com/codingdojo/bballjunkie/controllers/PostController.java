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

import com.codingdojo.bballjunkie.models.Post;
import com.codingdojo.bballjunkie.models.User;
import com.codingdojo.bballjunkie.services.PostServices;
import com.codingdojo.bballjunkie.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PostController {
	@Autowired
	private PostServices pService;
	
	@Autowired
	private UserServices uService;
	
	//Get Mapping
	
	@GetMapping("/add/post")
	public String createPost(@ModelAttribute("post")Post post, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId==null) {
			return "redirect:/welcome";
		}
		User user = uService.findbyId((Long)session.getAttribute("userId"));
		model.addAttribute("user", user);
		return "addPost.jsp";
	}
	
	@GetMapping("/user/{id}")
	public String userProfile(@PathVariable("id")Long id, Model model,HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/welcome";
		}
		List<Post> userPosts = pService.findByUserId(id);
		User user = uService.findbyId(id);
		model.addAttribute("user", user);
		model.addAttribute("userPosts", userPosts);
		return "userProfile.jsp";                         
	}
	
	@GetMapping("/delete/post/{id}")
	public String deletePost(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/welcome";
		}
		Post post =pService.findById(id);
		pService.deletePost(post);
		
		return "redirect:/home";
	}
	
	@GetMapping("/edit/post/{id}")
	public String editPost(@PathVariable("id")Long id, Model model, HttpSession session) {
		Long userId = (Long)session.getAttribute("userId");
		if(userId==null) {
			return "redirect:/welcome";
		}
		Post post = pService.findById(id);
		model.addAttribute("post",post);
		return "editPost.jsp";
	}
	
	
	//Post Mapping
	
	@PostMapping("/add/post")
	public String addNewPost(@Valid @ModelAttribute("post")Post post, BindingResult result) {
		if(result.hasErrors()) {
			return "addPost.jsp";
		}
		
		pService.create(post);
		return "redirect:/home";
	}
	
	@PutMapping("/post/edit/{id}")
	public String editPost(Model model,@Valid @ModelAttribute("post")Post post, BindingResult result, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId==null) {
			return "redirect:/welcome";
		}
		if (result.hasErrors()) {
			return "editpost.jsp";
		}
		pService.update(post);
		return "redirect:/home";
	}
}
