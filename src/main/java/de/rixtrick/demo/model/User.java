package de.rixtrick.demo.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author buehner
 * 
 */
@Entity
@Table (name="tbl_user")
public class User {

	@Id
	@Column(name = "username")
	private String userName;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "created_on", nullable = false)
	private Date createdOn;

	@Transient
	private Date lastLoginOn;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		User user = (User) o;

		return userName.equals(user.userName);
	}

	@Override
	public int hashCode() {
		return 13 * userName.hashCode();
	}

}
