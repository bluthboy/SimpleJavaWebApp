package de.rixtrick.demo.model;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

/**
 * @author buehner
 * 
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Person extends PersistentObject {

	private static final long serialVersionUID = -410831235648819339L;

	@Column(length = 64)
	private String firstName;

	@Column(length = 64)
	private String lastName;

	@Column
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate birthday;

	@Column(length = 8)
	private Locale nationality;

	public Person() {
	}

	public Person(String firstName, String lastName) {
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

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Locale getNationality() {
		return nationality;
	}

	public void setNationality(Locale nationality) {
		this.nationality = nationality;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}
