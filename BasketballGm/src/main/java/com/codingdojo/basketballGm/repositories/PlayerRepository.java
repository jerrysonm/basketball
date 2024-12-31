package com.codingdojo.basketballGm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.basketballGm.models.Player;

public interface PlayerRepository extends CrudRepository<Player,Long>{
	Optional<Player> findById(Long id);
	List<Player> findAll();
	
}
