package org.dawan.springchat.dto;

import org.dawan.springchat.entities.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class FriendsDto {
	
	private long id;
	
	@JsonBackReference
	private Users userId;
	
	@JsonBackReference
	private Users friendUser;

	public FriendsDto(long id) {
		super();
		this.id = id;
	}

	public FriendsDto() {
		super();
	}

	public FriendsDto(long id, Users userId, Users friendUser) {
		super();
		this.id = id;
		this.userId = userId;
		this.friendUser = friendUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public Users getFriendUser() {
		return friendUser;
	}

	public void setFriendUser(Users friendUser) {
		this.friendUser = friendUser;
	}
	
}
