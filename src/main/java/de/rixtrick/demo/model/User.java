package de.rixtrick.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author buehner
 * 
 */
@Entity
@Table(name = "users")
public class User extends PersistentObject {

	public static final String USER_NAME = "userName";

	private static final long serialVersionUID = -3347746010176522188L;

	@Column(name = "username", nullable = false)
	private String userName;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	public User() {
	}

	public User(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
		update();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return userName + ", id : " + getId() + ", created at " + getCreated()
				+ ", updated at " + getUpdated();

	}

}
