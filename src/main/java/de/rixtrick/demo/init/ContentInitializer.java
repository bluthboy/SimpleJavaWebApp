package de.rixtrick.demo.init;

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
	 * 
	 */
	@Autowired
	private UserService userService;

	/**
	 * The method called on initialization
	 */
	public void initializeDatabaseContent() {

		String userName = "peterX123";

		if (this.contentInitEnabled.equals(true)) {
			LOGGER.info("INITIALIZING DATABASE OR SOMETHING!");

			User user = new User(userName);
			user.setFirstName("Peter");
			user.setLastName("Mustermann");
			user.setPassword("unratbar.23");
			userService.saveUser(user);

			LOGGER.info("SAVED A USER");

		} else {
			LOGGER.info("NOT INITIALIZING ANYTHING!");
		}
	}

	/**
	 * @param contentInitEnabled
	 *            if some content should be initialized or not
	 */
	@Autowired
	@Qualifier("contentInitEnabled")
	public void setContentInitEnabled(Boolean contentInitEnabled) {
		this.contentInitEnabled = contentInitEnabled;
	}
}
