package org.dawan.springchat.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 255)
	private String name;
	
	@Column(nullable = false, length = 255)
	private String email;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false, length = 255)
	private String image;
	
	@Column(nullable = false, length = 255)
	private String sex;
	
	@Column(nullable = false, length = 255)
	private String ville ;
	
	@Column(nullable = false)
	private int departement ;
	
	@Column(nullable = false) // 0 = non 1 = oui
	private boolean modo;
	

	@ManyToMany(mappedBy = "users")
	private List<Theme> themes;
	
	@OneToMany(mappedBy = "user")
	private List<Message> messages;
	
	@ManyToOne
	private Channel userChannel ;
	
	public User() {
		
	}

	@OneToMany(mappedBy = "friendUser")
	private List<Friends> friends;
	
	public User(long id, String name, String email, int age, String image, String sex, String ville, int departement,
			boolean modo) {
		
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

	public Channel getUserChannel() {
		return userChannel;
	}

	public void setUserChannel(Channel userChannel) {
		this.userChannel = userChannel;
	}

	public List<Friends> getFriends() {
		return friends;
	}

	public void setFriends(List<Friends> friends) {
		this.friends = friends;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", image=" + image + ", sex="
				+ sex + ", ville=" + ville + ", departement=" + departement + ", modo=" + modo + "]";
	} 
	
}
