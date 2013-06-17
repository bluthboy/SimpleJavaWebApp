package de.rixtrick.demo.init;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import de.rixtrick.demo.model.User;
import de.rixtrick.demo.service.UserService;

/**
 * @author buehner
 * 
 *         Class to initialize some kind of content
 * 
 */
public class ContentInitializer {

	/**
	 * The Logger
	 */
	private static Logger LOGGER = Logger.getLogger(ContentInitializer.class);

	/**
	 * Flag symbolizing if something should be initialized by this class
	 */
	private Boolean contentInitEnabled;

	/**
	 * Number of dummy-entries to create when contentInitEnabled=true
	 */
	private int usersToCreate;

	/**
	 * The Service to manipulate users
	 */
	@Autowired
	private UserService userService;

	/**
	 * The method called on initialization
	 */
	public void initializeDatabaseContent() {

		if (this.contentInitEnabled.equals(true)) {
			LOGGER.info("***INITIALIZING DATABASE WITH " + usersToCreate
					+ " DUMMY USERS***");

			String userName = "peter";

			for (int i = 0; i < usersToCreate; i++) {
				String dummy = userName + i;
				User user = new User(dummy);
				user.setFirstName(dummy);
				user.setLastName(dummy);
				user.setPassword(dummy);
				userService.saveUser(user);
				LOGGER.debug("SAVED USER " + dummy);
			}
			LOGGER.info("***ADDED " + usersToCreate + " DUMMY USERS***");
			LOGGER.info("***TRYING TO FIND SOME OF THESE USERS***");
			String likeName = "peter23";
			List<User> users = userService.findUsers(likeName);
			LOGGER.info("***FOUND " + users.size() + " USERS LIKE " + likeName
					+ "***");
			for (User u : users) {
				LOGGER.debug(u.getUserName() + u.getCreatedOn());
			}

		} else {
			LOGGER.info("***NOT INITIALIZING ANYTHING!***");
		}
	}

	@Autowired
	@Qualifier("contentInitEnabled")
	public void setContentInitEnabled(Boolean contentInitEnabled) {
		this.contentInitEnabled = contentInitEnabled;
	}

	public Boolean getContentInitEnabled() {
		return contentInitEnabled;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getUsersToCreate() {
		return usersToCreate;
	}

	@Autowired
	@Qualifier("numberOfDummies")
	public void setUsersToCreate(int usersToCreate) {
		this.usersToCreate = usersToCreate;
	}
}