package com.codingdojo.basketballGm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.basketballGm.models.Team;

public interface TeamRepository extends CrudRepository<Team,Long> {
	Optional<Team> findById(Long id);
	List<Team> findAll();
	
}
