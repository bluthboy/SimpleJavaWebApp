package de.rixtrick.demo.dao.impl;

import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.iface.GoalGetterDao;
import de.rixtrick.demo.model.GoalGetter;

/**
 * @author buehner
 * 
 */
@Repository
public class GoalGetterDaoImpl extends
		GenericHibernateDaoImpl<GoalGetter, Integer> implements GoalGetterDao {

	protected GoalGetterDaoImpl() {
		super(GoalGetter.class);
	}

}
