package org.dawan.springchat.dto;

import java.util.List;

import org.dawan.springchat.entities.Channel;
import org.dawan.springchat.entities.Friends;
import org.dawan.springchat.entities.Message;
import org.dawan.springchat.entities.Theme;

public class UserDto {
	
	private long id ;
	
	private String name;
	
	private String email;
	
	private int age;
	
	private String image;
	
	private String sex;
	
	private String ville ;
	
	private int departement ;
	
	private boolean modo; // 0 = false = non , 1 = true = oui
	
	private List<Theme> themes ;
	
	private List<Message> messages;
	
	private Channel userChannel ;
	
	private Friends userFriend;
	
	private List<Friends> friends;

	
	public UserDto() {
		super();
	}

	public UserDto(long id, String name, String email, int age, String image, String sex, String ville, int departement,
			boolean modo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.image = image;
		this.sex = sex;
		this.ville = ville;
		this.departement = departement;
		this.modo = modo;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
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

	public boolean isModo() {
		return modo;
	}

	public void setModo(boolean modo) {
		this.modo = modo;
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
	
}
