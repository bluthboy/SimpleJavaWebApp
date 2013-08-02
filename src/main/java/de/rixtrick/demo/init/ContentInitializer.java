package de.rixtrick.demo.init;

import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.model.Goal;
import de.rixtrick.demo.model.GoalGetter;
import de.rixtrick.demo.model.Match;
import de.rixtrick.demo.model.Position;
import de.rixtrick.demo.model.Team;
import de.rixtrick.demo.service.GoalGetterService;
import de.rixtrick.demo.service.GoalService;
import de.rixtrick.demo.service.MatchService;
import de.rixtrick.demo.service.TeamService;

/**
 * @author buehner
 * 
 *         Class to initialize some kind of content
 * 
 */
@Transactional
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

	@Autowired
	private MatchService matchService;

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

			Team specialTeam1 = new Team("Special SocCeRcLUB 1900");
			teamService.saveTeam(specialTeam1);
			LOGGER.info("Created special team1 : " + specialTeam1);

			Team specialTeam2 = new Team("Special SocCeRcLUB 1900 Nr. 2");
			teamService.saveTeam(specialTeam2);
			LOGGER.info("Created special team2 : " + specialTeam2);

			Match match = new Match(new DateTime(2014, 6, 16, 15, 30),
					specialTeam1, specialTeam2);
			matchService.saveMatch(match);
			LOGGER.info("Saved match at " + match.getKickOff());

			GoalGetter messi = new GoalGetter("Lionel", "Messi",
					Position.FORWARD);
			messi.setBirthday(new LocalDate(1987, 6, 24));
			messi.setNationality(new Locale("es_AR"));
			messi.setCurrentTeam(specialTeam1);
			goalGetterService.saveGoalGetter(messi);
			LOGGER.info("Created player " + messi);

			// messi makes an own goal with a penalty
			Goal goal = new Goal();
			goal.setMatch(match);
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