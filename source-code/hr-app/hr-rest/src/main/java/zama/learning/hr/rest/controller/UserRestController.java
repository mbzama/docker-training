package zama.learning.hr.rest.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import zama.learning.hr.rest.domain.User;
import zama.learning.hr.rest.service.UserService;

/**
 * 
 * @author Zama
 *
 */
@RestController
@RequestMapping("/hr-rest/hrrest")
@CrossOrigin("*")
public class UserRestController {
	@Autowired
	private UserService userService; 
	private Logger LOGGER = Logger.getLogger(UserRestController.class);
	
	@RequestMapping(value = "/users")
	public List<User> getAllUsers() {
		List<User> users = userService.getAllUsers();
		LOGGER.info(users);
		return users;
	}
	
	@RequestMapping(value = "/user/{id}")
	public User getUser(@PathVariable("id") int id) {
		LOGGER.info("Fetching User with id " + id);
		User user = userService.getUser(id);
		LOGGER.info("User with id " + id + " not found");
		return user;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		String status = "fail";

		LOGGER.info("Creating User: " + user);
		if (userService.isUserExist(user)) {
			LOGGER.error("A User with name " + user.getUsername() + " already exist");
			status = "duplicate";
		}

		if(userService.createUser(user)){
			status = "success";
		}
		return getStatusMessage(status);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		String status = "fail";

		LOGGER.info("Updating User: " + user);
		if (userService.updateUser(user)) {
			status = "success";
		}
		return getStatusMessage(status);
	}
	
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String deleteUser(@RequestBody String id){
		String status = "fail";

		LOGGER.info("Deleting User with Id: " + id);
		if (userService.deleteUser(new User(Integer.valueOf(id),null,null,null))) {
			status = "success";
		}
		return getStatusMessage(status);
	}
	
	private String getStatusMessage(String status) {
		return "[{\"status\":\""+ status+"\"}]";
	}
}
