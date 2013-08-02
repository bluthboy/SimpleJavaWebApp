package de.rixtrick.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.ReadableDateTime;

/**
 * 
 * @author buehner
 * 
 */
@Entity
@Table
public class Match extends PersistentObject {

	private static final long serialVersionUID = 1287049349728313682L;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private ReadableDateTime kickOff;

	@ManyToOne
	@JoinColumn(name = "team1_id")
	private Team team1;

	@ManyToOne
	@JoinColumn(name = "team2_id")
	private Team team2;

	@OneToMany(mappedBy = "match", cascade = { CascadeType.ALL })
	private Set<Goal> goals = new HashSet<Goal>();

	// TODO MatchDay

	public Match() {
	}

	public Match(ReadableDateTime kickOff, Team team1, Team team2) {
		this.kickOff = kickOff;
		this.team1 = team1;
		this.team2 = team2;
	}

	public ReadableDateTime getKickOff() {
		return kickOff;
	}

	public void setKickOff(ReadableDateTime kickOff) {
		this.kickOff = kickOff;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Set<Goal> getGoals() {
		return goals;
	}

	public void setGoals(Set<Goal> goals) {
		this.goals = goals;
	}

}
