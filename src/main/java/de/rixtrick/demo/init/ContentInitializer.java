package de.rixtrick.demo.init;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import de.rixtrick.demo.model.Goal;
import de.rixtrick.demo.model.GoalGetter;
import de.rixtrick.demo.model.Team;
import de.rixtrick.demo.service.GoalGetterService;
import de.rixtrick.demo.service.GoalService;
import de.rixtrick.demo.service.TeamService;

/**
 * @author buehner
 * 
 *         Class to initialize some kind of content
 * 
 */
public class ContentInitializer {

	/**
	 * The Logger
	 */
	private static Logger LOGGER = Logger.getLogger(ContentInitializer.class);

	/**
	 * Flag symbolizing if something should be initialized on startup
	 */
	private Boolean contentInitEnabled;

	/**
	 * Number of dummy-entries to create when contentInitEnabled=true
	 */
	private int teamsToCreate;

	@Autowired
	private TeamService teamService;

	@Autowired
	private GoalGetterService goalGetterService;

	@Autowired
	private GoalService goalService;

	/**
	 * The method called on initialization
	 */
	public void initializeDatabaseContent() {

		if (this.contentInitEnabled.equals(true)) {
			LOGGER.info("Initializing database with " + teamsToCreate
					+ " dummy teams");

			String teamName = "FC Soccerclub ";

			for (int i = 1; i <= teamsToCreate; i++) {
				String dummyName = teamName + i;
				Team team = new Team(dummyName);

				teamService.saveTeam(team);
				LOGGER.debug("Saved Team " + dummyName);
			}
			LOGGER.info("Added " + teamsToCreate + " dummy teams.");

			Team specialTeam = new Team("Special SocCeRcLUB 1900");
			teamService.saveTeam(specialTeam);
			LOGGER.info("Created special team : " + specialTeam);

			GoalGetter messi = new GoalGetter("Lionel", "Messi");
			messi.setBirthday(new LocalDate(1987, 6, 24));
			messi.setNationality(new Locale("es_AR"));
			messi.setCurrentTeam(specialTeam);
			goalGetterService.saveGoalGetter(messi);
			LOGGER.info("Created player " + messi);

			// specialTeam.getSquad().add(messi);// addGoalGetter(goalGetter);

			// messi makes an own goal with a penalty
			Goal goal = new Goal();
			goal.setMatchMinute(17);
			goal.setGoalGetter(messi);
			goal.setHomeGoal(true);
			goal.setOverTime(false);
			goal.setOwnGoal(true);
			goal.setPenalty(true);
			goalService.saveGoal(goal);
			LOGGER.info("Saved a strange goal with ID " + goal.getId());

		} else {
			LOGGER.info("Not initializing anything");
		}

		String likeName = "ceRclub 1";
		LOGGER.info("Trying to find some teams like '" + likeName + "'");

		List<Team> teams = teamService.findTeamsLike(likeName);
		LOGGER.info("Found " + teams.size() + " teams.");
	}

	@Autowired
	@Qualifier("contentInitEnabled")
	public void setContentInitEnabled(Boolean contentInitEnabled) {
		this.contentInitEnabled = contentInitEnabled;
	}

	public Boolean getContentInitEnabled() {
		return contentInitEnabled;
	}

	public TeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(TeamService teamService) {
		this.teamService = teamService;
	}

	public int getTeamsToCreate() {
		return teamsToCreate;
	}

	@Autowired
	@Qualifier("numberOfDummies")
	public void setTeamsToCreate(int teamsToCreate) {
		this.teamsToCreate = teamsToCreate;
	}
}