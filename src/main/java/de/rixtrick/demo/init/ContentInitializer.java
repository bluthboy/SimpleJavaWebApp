package de.rixtrick.demo.init;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

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
	 * The method called on initialization
	 */
	public void initializeDatabaseContent() {
		if (this.contentInitEnabled.equals(true)) {
			LOGGER.info("INITIALIZING DATABASE OR SOMETHING!");
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
