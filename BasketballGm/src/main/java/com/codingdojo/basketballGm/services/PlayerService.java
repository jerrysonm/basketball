package com.codingdojo.basketballGm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.basketballGm.models.Player;
import com.codingdojo.basketballGm.repositories.PlayerRepository;

@Service
public class PlayerService {
	@Autowired PlayerRepository playerRepo;
	
	public List<Player> allPlayer(){
		return playerRepo.findAll();
		}
	
	public Player createPlayer(Player player) {
		return playerRepo.save(player);
	}
	
	public Player updatePlayer(Player player) {
		return playerRepo.save(player);
	}
	
	public void deletePlayer(Player player) {
		 playerRepo.delete(player);
	}
	
	public Player findById(long id) {
		Optional<Player>result = playerRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

}
