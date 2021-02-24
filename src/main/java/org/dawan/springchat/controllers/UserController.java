package org.dawan.springchat.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.dawan.springchat.dto.UserDto;
import org.dawan.springchat.entities.Users;
import org.dawan.springchat.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@CrossOrigin(origins="http://localhost:3000/",maxAge = 3600,allowedHeaders = "*")
@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/all", produces = "application/json")
	public List<UserDto> getUsers() {
		return userService.findAll();
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public UserDto getById(@PathVariable("id") long id) {
		return userService.findById(id);
	}

	@ResponseBody
	@PostMapping(value = "/addUser", consumes = "application/json", produces = "application/json")
	public UserDto addUser(@RequestBody UserDto uDto) {
		return userService.saveOrUpdate(uDto);
	}

	@GetMapping(value = "/nameSearch", produces = "application/json")
	public List<UserDto> searchByName(@RequestParam(name = "name") String name) {
		return userService.findByName(name);
	}

	@GetMapping(value = "/themeSearch", produces = "application/json")
	public List<UserDto> searchByTheme(@RequestParam(name = "theme") String theme) {
		return userService.findByTheme(theme);
	}

	@GetMapping(value = "/placeSearch", produces = "application/json")
	public List<UserDto> searchByPlace(@RequestParam(name = "place") String place) {
		return userService.findByPlace(place);
	}

	@DeleteMapping(value = "/{id}", produces = "text/plain")
	public String remove(@PathVariable("id") long id) {
		try {
			userService.deleteUser(id);
			return "L'utilisateur a bien �t� supprim�";
		} catch (Exception e) {
			e.printStackTrace();
			return "Erreur : " + e.getMessage();
		}
	}

	@PutMapping(value = "/updateUser", consumes = "application/json", produces = "application/json")
	public UserDto updateUser(@RequestBody UserDto uDto) {
		return userService.saveOrUpdate(uDto);
	}

	@PostMapping("/user/registration")
	public ModelAndView registerUserAccount
	      (@ModelAttribute("users") UserDto userDto, 
	      HttpServletRequest request, Errors errors) {
	    ModelAndView mav = new ModelAndView();
	    try {
	        Users registered = userService.registerNewUserAccount(userDto);
	        mav.addObject("users", registered);
	        mav.setViewName("home");
		} catch (Exception e) {
			mav.setViewName("signin");
		}
	    return mav;
	}
}
