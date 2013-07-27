package de.rixtrick.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.TeamDao;
import de.rixtrick.demo.model.Team;

/**
 * @author buehner
 * 
 */
@Repository
public class TeamDaoImpl extends GenericHibernateDaoImpl<Team, String>
		implements TeamDao {

	protected TeamDaoImpl() {
		super(Team.class);
	}

	@Override
	public List<Team> findByExample(Team example) {
		// TODO some logic
		return null;
	}

}
