package de.rixtrick.demo.dao;

import java.util.List;

import de.rixtrick.demo.model.User;

public interface UserDao extends GenericHibernateDao<User, String> {

	public List<User> findByExample(User example);
}
