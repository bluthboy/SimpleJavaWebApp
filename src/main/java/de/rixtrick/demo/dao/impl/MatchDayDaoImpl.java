package de.rixtrick.demo.dao.impl;

import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.iface.MatchDayDao;
import de.rixtrick.demo.model.MatchDay;

/**
 * @author buehner
 * 
 */
@Repository
public class MatchDayDaoImpl extends GenericHibernateDaoImpl<MatchDay, Integer>
		implements MatchDayDao {

	protected MatchDayDaoImpl() {
		super(MatchDay.class);
	}

}
