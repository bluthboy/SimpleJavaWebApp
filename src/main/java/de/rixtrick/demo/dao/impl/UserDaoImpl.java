package de.rixtrick.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.UserDao;
import de.rixtrick.demo.model.User;

/**
 * @author buehner
 * 
 */
@Repository
public class UserDaoImpl extends GenericHibernateDaoImpl<User, String>
		implements UserDao {

	protected UserDaoImpl() {
		super(User.class);
	}

	@Override
	public List<User> findByExample(User example) {
		// TODO some logic
		return null;
	}

}
