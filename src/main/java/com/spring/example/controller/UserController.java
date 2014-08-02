package com.spring.example.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.example.persistence.model.Role;
import com.spring.example.persistence.model.User;
import com.spring.example.service.IRoleService;
import com.spring.example.service.IUserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value = "/listUser.htm", method = RequestMethod.GET)
	public String listUsers(ModelMap users) {
		users.addAttribute("userCount", userService.findRecordsCount());
		return "user";
	}
	
	@RequestMapping(value = "/listPaginatedUser.htm", method = RequestMethod.GET)
	public @ResponseBody List<User> listPaginatedUsers(@RequestParam("startIndex") int startIndex , @RequestParam("numberOfRecordsToFetch") int numberOfRecordsToFetch) {
		return userService.listPaginatedUsers(startIndex, numberOfRecordsToFetch);
	}
	
	@RequestMapping(value = "/createUser.htm", method = RequestMethod.GET)
	public String redirectCreateUserPage(ModelMap users) {
		users.addAttribute("user", new User());
		users.addAttribute("role", new Role());
		Map<String,String> roleMap = roleService.getAllRole();
		users.addAttribute("roleMap", roleMap);
		return "createUser";
	}
	
	@RequestMapping(value = "/createUser.htm", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
		System.out.println("============== firstname val ========== " + user.getFirstName());
		System.out.println("============== firstname length ========== " + user.getFirstName().length());
		if (bindingResult.hasErrors()) {
            return "createUser";
        }
		user = userService.setUserAccountAccessControl(user);
		userService.create(user);
		return "redirect:/createUser.htm";
	}
	
	@RequestMapping(value = "/user/delete.htm", method = RequestMethod.POST)
	public @ResponseBody String deleteUser(@RequestParam("id") long id,ModelMap users) {
		userService.deleteById(id);
		return String.valueOf(userService.findRecordsCount());
	}
	
	@RequestMapping(value = "/user/edit/{id}", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") long id,ModelMap user) {
		user.addAttribute("user", userService.findOne(id));
		return "editUser";
	}
	
	@RequestMapping(value = "/user/updateUser.htm", method = RequestMethod.POST)
	public String updateUser() {
		return "redirect:/contact.htm";
	}
}
