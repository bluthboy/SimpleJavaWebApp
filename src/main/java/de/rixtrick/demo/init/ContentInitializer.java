package de.rixtrick.demo.init;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import de.rixtrick.demo.model.GoalGetter;
import de.rixtrick.demo.model.Team;
import de.rixtrick.demo.service.GoalGetterService;
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

	/**
	 * The Service to manipulate teams
	 */
	@Autowired
	private TeamService teamService;

	@Autowired
	private GoalGetterService goalGetterService;

	/**
	 * The method called on initialization
	 */
	public void initializeDatabaseContent() {

		if (this.contentInitEnabled.equals(true)) {
			LOGGER.info("***INITIALIZING DATABASE WITH " + teamsToCreate
					+ " DUMMY TEAMS***");

			String teamName = "FC Soccerclub ";

			for (int i = 1; i <= teamsToCreate; i++) {
				String dummyName = teamName + i;
				Team team = new Team(dummyName);

				teamService.saveTeam(team);
				LOGGER.debug("SAVED TEAM " + dummyName);
			}
			LOGGER.info("***ADDED " + teamsToCreate + " DUMMY TEAMS***");

			LOGGER.info("***CREATING ONE SPECIAL TEAM***");
			Team specialTeam = new Team();
			try {
				Thread.sleep(1337);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			specialTeam.setName("Special abCercLub 23klötß");

			GoalGetter goalGetter = new GoalGetter();
			goalGetter.setFirstName("Lionel");
			goalGetter.setLastName("Messi");
			// goalGetter.setCurrentTeam(specialTeam);
			goalGetterService.saveGoalGetter(goalGetter);

			specialTeam.addGoalGetter(goalGetter);

			teamService.saveTeam(specialTeam);
			LOGGER.info("CREATED SPECIAL TEAM : " + specialTeam);

		} else {
			LOGGER.info("***NOT INITIALIZING ANYTHING!***");
		}

		LOGGER.info("***TRYING TO FIND SOME TEAMS***");
		String likeName = "cerclub 23";

		List<Team> teams = teamService.findTeamsLike(likeName);
		LOGGER.info("***FOUND " + teams.size() + " TEAMS LIKE " + likeName
				+ "***");
		for (Team team : teams) {
			LOGGER.info(team);
		}
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