package de.rixtrick.demo.dao.impl;

import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.iface.MatchDao;
import de.rixtrick.demo.model.Match;

/**
 * @author buehner
 * 
 */
@Repository
public class MatchDaoImpl extends GenericHibernateDaoImpl<Match, Integer>
		implements MatchDao {

	protected MatchDaoImpl() {
		super(Match.class);
	}

}
