package de.rixtrick.demo.dao.iface;

import java.util.List;

import de.rixtrick.demo.model.Team;

public interface TeamDao extends GenericHibernateDao<Team, String> {

	public List<Team> findByExample(Team example);
}
