package org.dawan.springchat.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 1000)
	private String message;
	
	@Column(nullable = false)
	private LocalDateTime date;
	
	@Column
	private String pieceJointe;
	
	private MessageType type;
	
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = this.user.getUsername() ;
	}

	public enum MessageType {
		CHAT, LEAVE, JOIN
	}
	
	public Message() {
		
	}
	
	public Message(String message, LocalDateTime date, String pieceJointe, MessageType type, Users user,
			Channel channel) {
		super();
		this.message = message;
		this.date = date;
		this.pieceJointe = pieceJointe;
		this.type = type;
		this.user = user;
		this.channel = channel;
		this.username = this.user.getUsername();
	}

	@JsonBackReference
	@ManyToOne
	private Users user;
	
	@JsonBackReference
	@ManyToOne
	private Channel channel;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
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

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}
	
	
}
