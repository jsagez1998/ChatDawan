package org.dawan.springchat.controllers;

import javax.servlet.http.HttpServletRequest;

import org.dawan.springchat.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class IndexController {
		
	@GetMapping(value="/login")
	public ModelAndView login() {
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("login.html");
	        return modelAndView;
	}
	
	@GetMapping(value="/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home.html");
        return modelAndView;
	}
	
	@RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).invalidate();      
        return "redirect:/login";
    }
	
	@GetMapping(value="/chat")
	public ModelAndView chat() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("chat.html");
		return modelAndView;
	}
	
	@GetMapping(value="/signin")
	public ModelAndView signin(WebRequest request, UserDto userDto) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signin.html");
		modelAndView.addObject("users", userDto);
		return modelAndView;
	}
}
