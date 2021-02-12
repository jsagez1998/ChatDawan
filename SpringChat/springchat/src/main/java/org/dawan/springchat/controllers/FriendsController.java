package org.dawan.springchat.controllers;

import java.util.List;

import org.dawan.springchat.dto.FriendsDto;
import org.dawan.springchat.dto.UserDto;
import org.dawan.springchat.services.FriendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/friends")
public class FriendsController {

	@Autowired
	FriendsService friendsService;
	
	@GetMapping(value="/myFriends/{userId}", produces = "appliction/json")
	public List<UserDto> getFriendsByUserId(@PathVariable("userId") int id) {
		return friendsService.findByUserId(id);
	}
	
	@PostMapping(value="/addFriend", produces = "appliction/json")
	public FriendsDto addFriend(@RequestBody FriendsDto fDto) {
		return friendsService.saveFriend(fDto);
	}
	
	@DeleteMapping(value="/deleteFriend/{id}", produces = "appliction/json")
	public String deleteFriendById(@PathVariable("id") long id) {
		try {
			friendsService.deleteFriend(id);
			return "Cet ami a bien été supprimé.";
		} catch (Exception e) {
			e.printStackTrace();
			return " Error : "+e.getMessage(); 
		}
	}
	
}
