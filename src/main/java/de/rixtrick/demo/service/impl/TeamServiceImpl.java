package de.rixtrick.demo.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.dao.TeamDao;
import de.rixtrick.demo.model.Team;
import de.rixtrick.demo.service.TeamService;

/**
 * @author buehner
 * 
 */
@Service("teamService")
@Transactional(readOnly = true)
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamDao teamDao;

	@Override
	public Team findByTeamName(String name) {
		Criterion criterion = Restrictions.eq(Team.NAME, name);

		List<Team> teamList = teamDao.findByCriteria(criterion);

		if (teamList.size() > 0) {
			return teamList.get(0);
		}

		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveTeam(Team team) {
		teamDao.saveOrUpdate(team);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteTeam(String name) {
		Team team = findByTeamName(name);
		teamDao.delete(team);
	}

	@Override
	public List<Team> findTeamsLike(String name) {
		Criterion criterion = Restrictions.ilike(Team.NAME, "%" + name + "%");
		return teamDao.findByCriteria(criterion);
	}

}
