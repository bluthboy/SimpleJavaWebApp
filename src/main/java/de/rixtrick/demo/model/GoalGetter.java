package de.rixtrick.demo.model;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * @author buehner
 * 
 */
@Entity
@Table(name = "GOAL_GETTERS")
public class GoalGetter extends PersistentObject {

	private static final long serialVersionUID = -615330164323187979L;

	public static final String CURRENT_TEAM = "current_team";

	@Column(name = "first_name", length = 64)
	private String firstName;

	@Column(name = "last_name", length = 64)
	private String lastName;

	@Column(name = "nationality", length = 5)
	private Locale nationality;

	@Column(name = "birthday")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate birthday;

	@Column(name = "position")
	private String position;

	@ManyToOne
	@JoinColumn(name = CURRENT_TEAM, updatable = false, insertable = false)
	private Team currentTeam;

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
		update();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		update();
	}

	public Locale getNationality() {
		return nationality;
	}

	public void setNationality(Locale nationality) {
		this.nationality = nationality;
		update();
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
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
				+ getModified();
	}

}
