package de.rixtrick.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.dao.iface.MatchDao;
import de.rixtrick.demo.model.Match;
import de.rixtrick.demo.service.iface.MatchService;

/**
 * @author buehner
 * 
 */
@Service("matchService")
@Transactional(readOnly = true)
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchDao matchDao;

	@Transactional(readOnly = false)
	public void saveMatch(Match match) {
		matchDao.saveOrUpdate(match);
	}

}
