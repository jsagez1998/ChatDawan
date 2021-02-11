package org.dawan.springchat.services;

import java.util.List;

import org.dawan.springchat.dto.ThemeDto;

public interface ThemeService {

	List<ThemeDto> findAll();
	
	ThemeDto findById(long id);
	
	ThemeDto findByName(String name);
	
}
