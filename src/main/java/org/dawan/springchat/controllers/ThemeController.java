package org.dawan.springchat.controllers;

import java.util.List;

import org.dawan.springchat.dto.ThemeDto;
import org.dawan.springchat.services.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/themes")
public class ThemeController {

	@Autowired
	ThemeService themeService;
	
	@GetMapping(value="/all", produces="application/json")
	public List<ThemeDto> getThemes(){
		return themeService.findAll();
	}
	
	@GetMapping(value="/themeId/{id}", produces="application/json")
	public ThemeDto getById(@PathVariable("id") long id) {
		return themeService.findById(id);
	}

	@GetMapping(value="/themeName/{name}", produces="application/json")
	public ThemeDto getByName(@PathVariable("name") String name) {
		return themeService.findByName(name);
	}
}
