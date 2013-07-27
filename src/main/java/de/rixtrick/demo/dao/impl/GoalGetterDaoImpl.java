package de.rixtrick.demo.dao.impl;

import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.GoalGetterDao;
import de.rixtrick.demo.model.GoalGetter;

/**
 * @author buehner
 * 
 */
@Repository
public class GoalGetterDaoImpl extends
		GenericHibernateDaoImpl<GoalGetter, Long> implements GoalGetterDao {

	protected GoalGetterDaoImpl() {
		super(GoalGetter.class);
	}

}
