package com.codingdojo.bballjunkie.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.bballjunkie.models.Post;
import com.codingdojo.bballjunkie.models.User;

public interface PostRepository extends CrudRepository<Post, Long>{
	Optional<Post> findById(Long id);
	List<Post> findAll();
	List<Post>findByUserId(Long id);
}
