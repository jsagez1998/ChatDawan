package org.dawan.springchat.dto;

import java.util.List;

import org.dawan.springchat.entities.Message;
import org.dawan.springchat.entities.Theme;
import org.dawan.springchat.entities.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class ChannelDto {
	
	private long id;
	
	private String name;
	
	private int nbPlace;
	
	private List<Users> chanUsers;
	
	private List<Theme> chanTheme;
	
	private List<Message> chanMessages;

	public ChannelDto() {
		super();
	}

	public ChannelDto(long id, String name, int nbPlace) {
		super();
		this.id = id;
		this.name = name;
		this.nbPlace = nbPlace;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	public List<Users> getChanUsers() {
		return chanUsers;
	}

	public void setChanUsers(List<Users> chanUsers) {
		this.chanUsers = chanUsers;
	}

	public List<Theme> getChanTheme() {
		return chanTheme;
	}

	public void setChanTheme(List<Theme> chanTheme) {
		this.chanTheme = chanTheme;
	}

	public List<Message> getChanMessages() {
		return chanMessages;
	}

	public void setChanMessages(List<Message> chanMessages) {
		this.chanMessages = chanMessages;
	}

}
