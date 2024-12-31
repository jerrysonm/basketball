package com.codingdojo.basketballGm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.basketballGm.models.Manager;


public interface ManagerRepository extends CrudRepository<Manager,Long> {
	Optional<Manager> findByEmail(String email);
	List<Manager> findAll();
}
