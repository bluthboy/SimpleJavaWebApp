package de.rixtrick.demo.service;

import java.util.List;

import de.rixtrick.demo.model.User;

/**
 * @author buehner
 *
 */
public interface UserService {

	User findByUserName(String userName);

	void saveUser(User user);

	void deleteUser(String userName);

	@SuppressWarnings("rawtypes")
	List findUsers(String user);

}
