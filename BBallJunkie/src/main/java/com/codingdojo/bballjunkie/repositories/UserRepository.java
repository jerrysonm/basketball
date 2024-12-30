package com.codingdojo.bballjunkie.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.bballjunkie.models.User;

public interface UserRepository extends CrudRepository< User, Long>{
	Optional<User> findByEmail(String email);
	List<User> findAll();
	Optional<User> findByUsername(String username);
}
