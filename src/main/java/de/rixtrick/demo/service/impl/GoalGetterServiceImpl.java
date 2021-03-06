/**
 * 
 */
package de.rixtrick.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.dao.iface.GoalGetterDao;
import de.rixtrick.demo.model.GoalGetter;
import de.rixtrick.demo.service.iface.GoalGetterService;

/**
 * @author buehner
 * 
 */
@Service("goalGetterService")
@Transactional(readOnly = true)
public class GoalGetterServiceImpl implements GoalGetterService {

	@Autowired
	private GoalGetterDao goalGetterDao;

	@Transactional(readOnly = false)
	public void saveGoalGetter(GoalGetter goalGetter) {
		goalGetterDao.saveOrUpdate(goalGetter);
	}

}
