package de.rixtrick.demo.dao.impl;

import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.iface.CompetitionDao;
import de.rixtrick.demo.model.Competition;

/**
 * @author buehner
 * 
 */
@Repository
public class CompetitionDaoImpl extends
		GenericHibernateDaoImpl<Competition, Integer> implements CompetitionDao {

	protected CompetitionDaoImpl() {
		super(Competition.class);
	}

}
