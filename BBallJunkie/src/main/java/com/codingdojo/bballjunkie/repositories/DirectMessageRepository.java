package com.codingdojo.bballjunkie.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.bballjunkie.models.DirectMessage;

public interface DirectMessageRepository extends CrudRepository<DirectMessage, Long> {
	List<DirectMessage> findAll();
}
