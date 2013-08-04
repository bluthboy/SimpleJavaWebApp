package de.rixtrick.demo.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.dao.iface.CompetitionDao;
import de.rixtrick.demo.model.Competition;
import de.rixtrick.demo.service.iface.CompetitionService;

/**
 * @author buehner
 * 
 */
@Service("competitionService")
@Transactional(readOnly = true)
public class CompetitionServiceImpl implements CompetitionService {

	@Autowired
	private CompetitionDao competitionDao;

	@Transactional(readOnly = false)
	public void saveCompetition(Competition competition) {
		competitionDao.saveOrUpdate(competition);
	}

	@Override
	public Set<Competition> findAllCompetitions() {
		return new HashSet<Competition>(competitionDao.findAll());
	}
}
