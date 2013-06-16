package de.rixtrick.demo.dao;

import java.util.List;

import de.rixtrick.demo.model.User;

public interface UserDao {

	void saveUser(User user);

	List<User> findUsers(String userName);

	User findById(String userName);

	void delete(User user);

}
