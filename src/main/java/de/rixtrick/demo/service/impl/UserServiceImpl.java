package de.rixtrick.demo.service.impl;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.rixtrick.demo.dao.UserDao;
import de.rixtrick.demo.model.User;
import de.rixtrick.demo.service.UserService;

/**
 * @author buehner
 * 
 */
@Service("userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findByUserName(String userName) {
		Criterion criterion = Restrictions.eq(User.USER_NAME, userName);

		List<User> userList = userDao.findByCriteria(criterion);

		if (userList.size() > 0) {
			return userList.get(0);
		}

		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		userDao.saveOrUpdate(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String userName) {
		User user = findByUserName(userName);
		userDao.delete(user);
	}

	@Override
	public List<User> findUsersLike(String userName) {
		Criterion criterion = Restrictions.ilike(User.USER_NAME, "%" + userName + "%");
		return userDao.findByCriteria(criterion);
	}

}
