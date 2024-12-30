package com.codingdojo.bballjunkie.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.bballjunkie.models.Like;
import com.codingdojo.bballjunkie.models.Post;

public interface LikeRepository extends CrudRepository<Like,Long> {
	List<Like> findByPost(Post post);
}
