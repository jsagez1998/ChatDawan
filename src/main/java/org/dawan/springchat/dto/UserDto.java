package org.dawan.springchat.dto;

import java.io.Serializable;
import java.util.List;

import org.dawan.springchat.entities.Channel;
import org.dawan.springchat.entities.Friends;
import org.dawan.springchat.entities.Message;
import org.dawan.springchat.entities.Theme;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

public class UserDto implements Serializable{
	
	private static final long serialVersionUID = 91105982748561650L;

	private long id ;
	
	private String username;
	
	private String email;
	
	private int age;
	
	private String image;
	
	private String sexe;
	
	private String ville ;
	
	private int departement ;
	
	private String role; 
	
	private String password;
	
	private List<Theme> themes ;
	
	@JsonBackReference
	private List<Message> messages;
	
	private Channel userChannel ;
	
	private Friends userFriend;
	
	private List<Friends> friends;

	
	

	public UserDto(String name, String email, int age, String image, String sexe, String ville, int departement,
			String password) {
		super();
		this.username = name;
		this.email = email;
		this.age = age;
		this.image = image;
		this.sexe = sexe;
		this.ville = ville;
		this.departement = departement;
		this.password = password;
	}

	public UserDto(long id, String name, String email, int age, String image, String sexe, String ville,
			int departement, String role, List<Theme> themes, List<Message> messages, Channel userChannel,
			Friends userFriend, List<Friends> friends) {
		super();
		this.id = id;
		this.username = name;
		this.email = email;
		this.age = age;
		this.image = image;
		this.sexe = sexe;
		this.ville = ville;
		this.departement = departement;
		this.role = role;
		this.themes = themes;
		this.messages = messages;
		this.userChannel = userChannel;
		this.userFriend = userFriend;
		this.friends = friends;
	}

	public UserDto() {
		super();
	}

	public UserDto(long id, String name, String email, int age, String image, String sexe, String ville, int departement,
			String role) {
		super();
		this.id = id;
		this.username = name;
		this.email = email;
		this.age = age;
		this.image = image;
		this.sexe = sexe;
		this.ville = ville;
		this.departement = departement;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getDepartement() {
		return departement;
	}

	public void setDepartement(int departement) {
		this.departement = departement;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Channel getUserChannel() {
		return userChannel;
	}

	public void setUserChannel(Channel userChannel) {
		this.userChannel = userChannel;
	}

	public Friends getUserFriend() {
		return userFriend;
	}

	public void setUserFriend(Friends userFriend) {
		this.userFriend = userFriend;
	}

	public List<Friends> getFriends() {
		return friends;
	}

	public void setFriends(List<Friends> friends) {
		this.friends = friends;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
