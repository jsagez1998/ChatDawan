package org.dawan.springchat.dto;

import org.dawan.springchat.entities.Users;

public class FriendsDto {
	
	private long id;
	
	private Users userId;
	
	private Users friendUser;

	public FriendsDto(long id) {
		super();
		this.id = id;
	}

	public FriendsDto() {
		super();
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
