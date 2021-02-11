package org.dawan.springchat.services;

import java.util.List;

import org.dawan.springchat.dto.UserDto;

public interface UserService {

	UserDto saveOrUpdate(UserDto uDto);
	
	UserDto findById(long id);
	
	List<UserDto> findAll();
	
	void deleteUser(long id);
	
	List<UserDto> findByName(String name);
	
	List<UserDto> findByTheme(String theme);
	
	List<UserDto> findByPlace(String place);
	
	List<UserDto> getAllUsers(int page, int limite);
	
	
}
