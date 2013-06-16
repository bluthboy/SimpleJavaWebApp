package de.rixtrick.demo.dao.impl;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import de.rixtrick.demo.dao.UserDao;
import de.rixtrick.demo.model.User;

/**
 * @author buehner
 * 
 */
@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, String> implements
		UserDao {

	protected UserDaoImpl() {
		super(User.class);
	}

	@Override
	public void saveUser(User user) {
		saveOrUpdate(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findUsers(String userName) {
		return findByCriteria(Restrictions.like("userName", userName,
				MatchMode.START));
	}
}
