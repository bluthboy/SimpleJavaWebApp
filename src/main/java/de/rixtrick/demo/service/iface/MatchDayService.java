package de.rixtrick.demo.service.iface;

import java.util.List;

import de.rixtrick.demo.model.MatchDay;

/**
 * @author buehner
 * 
 */
public interface MatchDayService {

	void saveMatchDay(MatchDay matchDay);

	List<MatchDay> findAllMatchDays();

}
