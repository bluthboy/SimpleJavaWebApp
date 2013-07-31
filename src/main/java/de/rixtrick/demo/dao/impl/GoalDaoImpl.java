package de.rixtrick.demo.dao.impl;

import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.GoalDao;
import de.rixtrick.demo.model.Goal;

/**
 * @author buehner
 * 
 */
@Repository
public class GoalDaoImpl extends GenericHibernateDaoImpl<Goal, Integer> implements
		GoalDao {

	protected GoalDaoImpl() {
		super(Goal.class);
	}

}
