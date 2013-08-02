package de.rixtrick.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author buehner
 * 
 */
@Entity
@Table
public class GoalGetter extends Person {

	private static final long serialVersionUID = -615330164323187979L;

	@Enumerated(EnumType.STRING)
	private Position position;

	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team currentTeam;

	@OneToMany(mappedBy = "goalGetter", cascade = { CascadeType.ALL })
	private Set<Goal> goals = new HashSet<Goal>();

	public GoalGetter() {
	}

	public GoalGetter(String firstName, String lastName, Position position) {
		super(firstName, lastName);
		this.position = position;
	}

	public Team getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
	}

	public Set<Goal> getGoals() {
		return goals;
	}

	public void setGoals(Set<Goal> goals) {
		this.goals = goals;
	}

}
