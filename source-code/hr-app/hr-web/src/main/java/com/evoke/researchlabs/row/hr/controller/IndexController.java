package com.evoke.researchlabs.row.hr.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Zama
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	private static final Logger LOGGER = Logger.getLogger(IndexController.class);
	private static final String VERSION = "v1.1";
	
	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		LOGGER.info("\ngetIndexPage() ==> "+VERSION);
		return "UserManagement";
	}
}