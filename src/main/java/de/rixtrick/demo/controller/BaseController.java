package de.rixtrick.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class BaseController {

	private static final Logger LOGGER = Logger.getLogger(BaseController.class);

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		LOGGER.info("starting welcome() method");

		model.addAttribute("message",
				"Maven Web Project + Spring 3 MVC - welcome()");

		LOGGER.debug("executed default welcome");

		// Spring uses InternalResourceViewResolver and return back index.jsp
		return "index";

	}

	@RequestMapping(value = "/welcome/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		LOGGER.info("starting welcomeName() method with name '" + name + "'");

		model.addAttribute("message", "Maven Web Project + Spring 3 MVC - "
				+ name);

		LOGGER.debug("executed enhanced welcome");

		return "index";

	}

}