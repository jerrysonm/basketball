package com.codingdojo.bballjunkie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bballjunkie.models.Post;
import com.codingdojo.bballjunkie.repositories.PostRepository;

@Service 
public class PostServices {
	@Autowired
	private PostRepository postRepo;
	
	public List<Post>allPost(){
		return postRepo.findAll();
	}
	
	public Post create(Post post) {
		return postRepo.save(post);
	}
	
	public Post update(Post post) {
		return postRepo.save(post);
	}
	
	public void deletePost(Post post) {
		postRepo.delete(post);
	}
	
	public Post findById(Long id) {
		Optional<Post>result = postRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
			}
		return null;
	}
	
	public List<Post>findByUserId(Long id){
		return postRepo.findByUserId(id);
	}
}
