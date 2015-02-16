package com.spring.example.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.example.persistence.model.Role;
import com.spring.example.persistence.model.User;
import com.spring.example.service.IRoleService;
import com.spring.example.service.IUserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
/*	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private Environment environment;*/
	
	private final IUserService userService;
	private final IRoleService roleService;
	private final Environment environment;
	private final ReloadableResourceBundleMessageSource messageSource;
	
	/* This construtor type autowiring create a problem when we try to add user for validation. */
	/* If anybody find any solution please provide me on ajaysoni98292@gmail.com */
	
	@Autowired
	public UserController(IUserService userService,IRoleService roleService,Environment environment,ReloadableResourceBundleMessageSource messageSource) {
		this.userService=userService;
		this.roleService=roleService;
		this.environmetn=environment;
		this.messageSoruce=messageSource;
	}
	
	
/*	@Autowired
	ReloadableResourceBundleMessageSource messageSource;*/
	
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
	public String redirectCreateUserPage(ModelMap users,Locale locale) {
		/*Added condition because when there is error in data while post request in createUser()
		* we added the user object received in createUser() bindingResult.hasErrors() 
		* and redirected to this method and it was overriding that attribute so error messages were 
		* not displayed on jsp page.
		*/
		if (!users.containsAttribute("user")) {
			users.addAttribute("user", new User());
		}
		
		users.addAttribute("role", new Role());
		Map<String,String> roleMap = roleService.getAllRole();
		users.addAttribute("roleMap", roleMap);
		return "createUser";
	}
	
	@RequestMapping(value = "/createUser.htm", method = RequestMethod.POST)
	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes,Locale locale) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
			redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/createUser.htm";
        }
		user = userService.setUserAccountAccessControl(user);
		user.setEmail(user.getEmail().trim());
		user.setFirstName(user.getFirstName().trim());
		user.setLastName(user.getLastName().trim());
		userService.create(user);
		redirectAttributes.addFlashAttribute("successMessage", messageSource.getMessage("user.added.successfully", null,locale));
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
