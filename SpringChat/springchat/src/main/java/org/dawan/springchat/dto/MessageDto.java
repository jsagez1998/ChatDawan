package org.dawan.springchat.dto;

import java.time.LocalDateTime;

import org.dawan.springchat.entities.Channel;
import org.dawan.springchat.entities.User;

public class MessageDto {
	
	private long id;
	
	private String message;
	
	private LocalDateTime date;
	
	private String pieceJointe;
	
	private User user;
	
	private Channel channel;

	
	
	public MessageDto() {
	}

	public MessageDto(long id, String message, LocalDateTime date, String pieceJointe, User user) {
		this.id = id;
		this.message = message;
		this.date = date;
		this.pieceJointe = pieceJointe;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPieceJointe() {
		return pieceJointe;
	}

	public void setPieceJointe(String pieceJointe) {
		this.pieceJointe = pieceJointe;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	

}
