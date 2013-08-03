/**
 * 
 */
package de.rixtrick.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.dao.iface.GoalDao;
import de.rixtrick.demo.model.Goal;
import de.rixtrick.demo.service.iface.GoalService;

/**
 * @author buehner
 * 
 */
@Service("goalService")
@Transactional(readOnly = true)
public class GoalServiceImpl implements GoalService {

	@Autowired
	private GoalDao goalDao;

	@Transactional(readOnly = false)
	public void saveGoal(Goal goal) {
		goalDao.saveOrUpdate(goal);
	}

}
