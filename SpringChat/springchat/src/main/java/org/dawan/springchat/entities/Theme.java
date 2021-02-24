package org.dawan.springchat.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Theme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(nullable = false , length = 400)
	private String description;
	
	@JsonBackReference
	@ManyToMany
	private List<Users> users;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "chanTheme")
	private List<Channel> themeChannel ;

	

	public List<Channel> getThemeChannel() {
		return themeChannel;
	}

	public void setThemeChannel(List<Channel> themeChannel) {
		this.themeChannel = themeChannel;
	}

	public Theme(long id, String name, String description) {
		
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Theme() {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}
}
