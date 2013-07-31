package de.rixtrick.demo.model;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * @author buehner
 * 
 */
@Entity
@Table
public class GoalGetter extends PersistentObject {

	private static final long serialVersionUID = -615330164323187979L;

	public static final String CURRENT_TEAM = "currentTeam";
	public static final String GOALS = "goals";

	@Column(length = 64)
	private String firstName;

	@Column(length = 64)
	private String lastName;

	@Column(length = 8)
	private Locale nationality;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate birthday;

	@Column
	private String position;

	@ManyToOne
	@JoinColumn(name = CURRENT_TEAM)
	private Team currentTeam;

	@OneToMany(mappedBy = Goal.GOAL_GETTER, cascade = { CascadeType.ALL })
	private Set<Goal> goals = new HashSet<Goal>();

	public GoalGetter() {
	}

	public GoalGetter(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Locale getNationality() {
		return nationality;
	}

	public void setNationality(Locale nationality) {
		this.nationality = nationality;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
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

	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + currentTeam.getName() + ")";
	}
}
