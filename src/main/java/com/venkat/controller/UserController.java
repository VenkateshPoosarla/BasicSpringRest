package com.venkat.controller;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkat.dao.UserDao;
import com.venkat.exception.EmployeeNotFoundException;
import com.venkat.model.User;

@RestController
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class.getName());

	@Autowired
	UserDao userDao;

	@RequestMapping(value = UserURIConstants.GET_ALL_Users, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		log.info("Start getting allUsers.");
		List<User> users = userDao.findAll();
		return users;
	}

	@RequestMapping(value = UserURIConstants.CREATE_EMP, method = RequestMethod.POST, headers = {
			"Content-type=application/json" })
	public String addPerson(@RequestBody User user) {
		log.info(user.toString());
		user.setId(UUID.randomUUID().toString());
		userDao.createUser(user);
		log.info("person added with id" + user.getId());
		return "person added with id" + user.getId();

	}

	@RequestMapping(value = UserURIConstants.Update_User, method = RequestMethod.PUT)
	public @ResponseBody String updateUserPhone(@PathVariable("id") String id,
			@RequestParam(value = "phone", required = true) String phone) throws Exception {
		log.info("Start update user phone number.");
		if (userDao.findById(id) != null) {
			userDao.updateUserPhone(id, phone);
			log.info("person phone number updted");
			return "person phone number updted";
		} else {
			throw new EmployeeNotFoundException(id);
		}
	}

}
