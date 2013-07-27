package de.rixtrick.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author buehner
 * 
 */
@Entity
@Table(name = "GOAL_GETTERS")
public class GoalGetter extends PersistentObject {

	private static final long serialVersionUID = -615330164323187979L;

	public static final String CURRENT_TEAM = "current_team";

	public GoalGetter() {

	}

	public GoalGetter(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "position")
	private String position;

	// TODO BIRTHDAY, NATIONALITY

	@ManyToOne
	@JoinColumn(name = CURRENT_TEAM, updatable = false, insertable = false)
	private Team currentTeam;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		update();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		update();
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
		update();
	}

	public Team getCurrentTeam() {
		return currentTeam;
	}

	public void setCurrentTeam(Team currentTeam) {
		this.currentTeam = currentTeam;
		update();
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ", id : " + getId()
				+ ", created at " + getCreated() + ", updated at "
				+ getUpdated();
	}

}
