package com.codingdojo.basketballGm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.basketballGm.models.Team;
import com.codingdojo.basketballGm.repositories.TeamRepository;

@Service
public class TeamService {
	@Autowired
	private TeamRepository teamRepo;
	
	public List<Team> allTeam(){
		return teamRepo.findAll();
	}

	public Team create(Team team) {
		return teamRepo.save(team);
	}
	
	public Team update(Team team) {
		return teamRepo.save(team);
	}
	
	public void delete(Team team) {
		teamRepo.delete(team);
	}
	
	public Team findById(long id) {
		Optional<Team>result = teamRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}
}
