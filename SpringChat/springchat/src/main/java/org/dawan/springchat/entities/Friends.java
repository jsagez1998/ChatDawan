package org.dawan.springchat.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Friends {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@JsonBackReference
	@OneToOne
	private Users userId;
	
	@JsonBackReference
	@ManyToOne
	private Users friendUser;
	
	public Friends() {

	}

	public Friends(long id, Users friendUser) {

		this.id = id;
		this.friendUser = friendUser;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getFriendUser() {
		return friendUser;
	}

	public void setFriendUser(Users friendUser) {
		this.friendUser = friendUser;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	
}
