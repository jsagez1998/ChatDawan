package org.dawan.springchat.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(nullable = false)
	private int nbPlace;
	
	//@JsonBackReference
	@OneToMany(mappedBy = "userChannel")
	private List<Users> chanUsers;
	
	//@JsonBackReference
	@ManyToMany
	private List<Theme> chanTheme ;
	
	//@JsonBackReference
	@OneToMany(mappedBy = "channel")
	private List<Message> chanMessages;

	public List<Theme> getChanTheme() {
		return chanTheme;
	}

	public void setChanTheme(List<Theme> chanTheme) {
		this.chanTheme = chanTheme;
	}

	public Channel() {
		
	}

	public Channel(long id, String name, int nbPlace) {
		
		this.id = id;
		this.name = name;
		this.nbPlace = nbPlace;
	}

	public void setChanUsers(List<Users> chanUsers) {
		this.chanUsers = chanUsers;
	}

	public List<Users> getChanUsers() {
		return chanUsers;
	}
	public List<Message> getChanMessages() {
		return chanMessages;
	}

	public void setChanMessages(List<Message> chanMessages) {
		this.chanMessages = chanMessages;
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
}
