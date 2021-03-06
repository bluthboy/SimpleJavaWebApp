package de.rixtrick.demo.init;

import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.model.Competition;
import de.rixtrick.demo.model.Goal;
import de.rixtrick.demo.model.GoalGetter;
import de.rixtrick.demo.model.Match;
import de.rixtrick.demo.model.MatchDay;
import de.rixtrick.demo.model.Position;
import de.rixtrick.demo.model.Team;
import de.rixtrick.demo.service.iface.CompetitionService;
import de.rixtrick.demo.service.iface.GoalGetterService;
import de.rixtrick.demo.service.iface.GoalService;
import de.rixtrick.demo.service.iface.MatchDayService;
import de.rixtrick.demo.service.iface.MatchService;
import de.rixtrick.demo.service.iface.TeamService;

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
	@Autowired
	@Qualifier("contentInitEnabled")
	private Boolean contentInitEnabled;

	/**
	 * Number of dummy-entries to create when contentInitEnabled=true
	 */
	@Autowired
	@Qualifier("numberOfDummies")
	private int teamsToCreate;

	@Autowired
	private TeamService teamService;

	@Autowired
	private GoalGetterService goalGetterService;

	@Autowired
	private GoalService goalService;

	@Autowired
	private MatchService matchService;

	@Autowired
	private MatchDayService matchDayService;

	@Autowired
	private CompetitionService competitionService;

	/**
	 * The method called on initialization
	 */
	public void initializeDatabaseContent() {

		if (this.contentInitEnabled.equals(true)) {
			createDummyTeams();

			Team specialTeam1 = createTeam("Special SocCeRcLUB 1900");
			Team specialTeam2 = createTeam("Special SocCeRcLUB 1900 Nr. 2");

			Competition worldCup = createCompetition("WorldCup", "Soccer", 1,
					specialTeam1, specialTeam2);

			MatchDay quarterFinal = createMatchDay("Quarter Final of WorldCup",
					worldCup, 5);
			createMatchDay("Semi Final of WorldCup", worldCup, 4);

			Match match = createMatch(quarterFinal, specialTeam1, specialTeam2);

			GoalGetter messi = createGoalGetterOfTeam(specialTeam1);

			createGoal(match, messi);

		} else {
			LOGGER.info("Not initializing anything");
		}

		makeSomeChecks();
	}

	private void makeSomeChecks() {
		String likeName = "ceRclub 1";
		LOGGER.info("Trying to find some teams like '" + likeName + "'");

		List<Team> teams = teamService.findTeamsLike(likeName);
		LOGGER.info("Found " + teams.size() + " teams.");

		List<MatchDay> matchDays = matchDayService.findAllMatchDays();
		LOGGER.info("Found a total of " + matchDays.size() + " match days.");

		MatchDay first = matchDays.get(0);
		LOGGER.info("The first found matchDay: " + first.getName());

		Set<Competition> competitions = competitionService
				.findAllCompetitions();
		LOGGER.info("Found a total of " + competitions.size() + " competions");

		for (Competition competition : competitions) {
			List<MatchDay> matchDaysOfCompetition = competition.getMatchDays();
			LOGGER.info("This is the first match day of competition "
					+ competition.getName() + " (respecting order): "
					+ matchDaysOfCompetition.get(0).getName());
		}
	}

	private Competition createCompetition(String name, String sport,
			Integer level, Team... teams) {
		Competition competition = new Competition(name, sport, level, 2014,
				2014);
		for (Team team : teams) {
			competition.getTeams().add(team);
		}
		competitionService.saveCompetition(competition);
		return competition;
	}

	private MatchDay createMatchDay(String name, Competition competition,
			Integer orderIndex) {
		MatchDay matchDay = new MatchDay(name, orderIndex);
		matchDay.setCompetition(competition);
		matchDayService.saveMatchDay(matchDay);
		return matchDay;
	}

	private void createGoal(Match match, GoalGetter messi) {
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
	}

	private GoalGetter createGoalGetterOfTeam(Team team) {
		GoalGetter goalGetter = new GoalGetter("Lionel", "Messi",
				Position.FORWARD);
		goalGetter.setBirthday(new LocalDate(1987, 6, 24));
		goalGetter.setNationality(new Locale("es_AR"));
		goalGetter.setCurrentTeam(team);
		goalGetterService.saveGoalGetter(goalGetter);
		LOGGER.info("Created player " + goalGetter);
		return goalGetter;
	}

	private Match createMatch(MatchDay matchDay, Team team1, Team team2) {
		Match match = new Match(new DateTime(2014, 6, 16, 15, 30), team1, team2);
		match.setMatchDay(matchDay);
		matchService.saveMatch(match);
		LOGGER.info("Saved match at " + match.getKickOff());
		return match;
	}

	private Team createTeam(String name) {
		Team team = new Team(name);
		teamService.saveTeam(team);
		LOGGER.info("Created special team1 : " + team);
		return team;
	}

	private void createDummyTeams() {
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
	}

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

	public void setTeamsToCreate(int teamsToCreate) {
		this.teamsToCreate = teamsToCreate;
	}
}