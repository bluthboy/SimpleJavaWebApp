package de.rixtrick.demo.service;

import java.util.List;

import de.rixtrick.demo.model.Team;

/**
 * @author buehner
 * 
 */
public interface TeamService {

	Team findByTeamName(String name);

	void saveTeam(Team team);

	void deleteTeam(String name);

	public List<Team> findTeamsLike(String name);

}
