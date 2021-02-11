package org.dawan.springchat.services;

import java.util.List;

import org.dawan.springchat.dto.FriendsDto;
import org.dawan.springchat.dto.UserDto;

public interface FriendsService {

	List<UserDto> findByUserId(int id);

	FriendsDto saveFriend(FriendsDto fDto);

	void deleteFriend(long id);
}
