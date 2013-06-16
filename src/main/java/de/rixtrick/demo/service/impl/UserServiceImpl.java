package de.rixtrick.demo.service.impl;

import java.util.List;

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
		return userDao.findById(userName);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String userName) {
		User user = userDao.findById(userName);
		userDao.delete(user);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List findUsers(String user) {
		return userDao.findUsers(user);
	}
}
