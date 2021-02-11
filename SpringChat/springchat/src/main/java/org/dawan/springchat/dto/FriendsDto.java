package org.dawan.springchat.dto;

import org.dawan.springchat.entities.User;

public class FriendsDto {
	
	private long id;
	
	private User userId;
	
	private User friendUser;

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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public User getFriendUser() {
		return friendUser;
	}

	public void setFriendUser(User friendUser) {
		this.friendUser = friendUser;
	}
	
}
