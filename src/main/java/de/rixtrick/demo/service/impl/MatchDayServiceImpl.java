package de.rixtrick.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.dao.iface.MatchDayDao;
import de.rixtrick.demo.model.MatchDay;
import de.rixtrick.demo.service.iface.MatchDayService;

/**
 * @author buehner
 * 
 */
@Service("matchDayService")
@Transactional(readOnly = true)
public class MatchDayServiceImpl implements MatchDayService {

	@Autowired
	private MatchDayDao matchDayDao;

	@Override
	@Transactional(readOnly = false)
	public void saveMatchDay(MatchDay matchDay) {
		matchDayDao.saveOrUpdate(matchDay);
	}

}
