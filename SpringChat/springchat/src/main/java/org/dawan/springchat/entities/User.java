package org.dawan.springchat.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	
	@JsonManagedReference
	@ManyToMany(mappedBy = "users", cascade= {CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Theme> themes;
	
	@JsonBackReference
	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade= {CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Message> messages;
	
	@JsonManagedReference
	@ManyToOne
	private Channel userChannel ;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "userId")
	private Friends userFriend;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "friendUser",cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	private List<Friends> friends;
	
	@Column(nullable = false)
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		
	}
	
	public User(long id, String name, String email, int age, String image, String sex, String ville, int departement,
			boolean modo,String password) {
		
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.image = image;
		this.sex = sex;
		this.ville = ville;
		this.departement = departement;
		this.modo = modo;
		this.password = password;
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

	public Friends getUserFriend() {
		return userFriend;
	}

	public void setUserFriend(Friends userFriend) {
		this.userFriend = userFriend;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", image=" + image + ", sex="
				+ sex + ", ville=" + ville + ", departement=" + departement + ", modo=" + modo + "]";
	} 
	
	
	
}
