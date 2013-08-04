package de.rixtrick.demo.service.iface;

import java.util.Set;

import de.rixtrick.demo.model.Competition;

/**
 * @author buehner
 * 
 */
public interface CompetitionService {

	void saveCompetition(Competition competition);

	Set<Competition> findAllCompetitions();
}
