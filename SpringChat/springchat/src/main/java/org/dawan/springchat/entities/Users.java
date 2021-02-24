package org.dawan.springchat.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 255)
	private String username;
	
	@Column(nullable = false, length = 255)
	private String email;
	
	@Column(nullable = false)
	private int age;
	
	@Column(nullable = false, length = 255)
	private String image;
	
	@Column(nullable = false, length = 255)
	private String sexe;
	
	@Column(nullable = false, length = 255)
	private String ville ;
	
	@Column(nullable = false)
	private int departement ;
	
	@Column(nullable = false) // 0 = non 1 = oui
	private String role;
	
	//@JsonManagedReference
	@ManyToMany(mappedBy = "users", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Theme> themes;
	
	//@JsonManagedReference
	//@JsonBackReference
	@OneToMany(mappedBy = "user", cascade= {CascadeType.ALL}, fetch = FetchType.LAZY)
	private List<Message> messages;
	
	//@JsonManagedReference
	@ManyToOne
	private Channel userChannel ;
	
	public void setRole(String role) {
		this.role = role;
	}

	 @JsonBackReference
	 @ManyToMany
	 @JoinTable(name="tbl_friends",
	  joinColumns=@JoinColumn(name="personId"),
	  inverseJoinColumns=@JoinColumn(name="friendId")
	 )
	 private List<Users> friends;

	 @JsonBackReference
	 @ManyToMany
	 @JoinTable(name="tbl_friends",
	  joinColumns=@JoinColumn(name="friendId"),
	  inverseJoinColumns=@JoinColumn(name="personId")
	 )
	 private List<Users> friendOf;
	
	@Column(nullable = false)
	private String password;
	
	@Column
	private int enabled;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Users() {
		super();
	}
	
	
	public Users(String username, String email, int age, String image, String sexe, String ville, int departement,
			String password, int enabled) {
		super();
		this.username = username;
		this.email = email;
		this.age = age;
		this.image = image;
		this.sexe = sexe;
		this.ville = ville;
		this.departement = departement;
		this.password = password;
		this.enabled = enabled;
	}

	

	public Users(long id, String username, String email, int age, String image, String sexe, String ville,
			int departement, String role, List<Theme> themes, List<Message> messages, Channel userChannel,
			List<Users> friends, List<Users> friendOf, String password, int enabled) {
		super();
		this.id = id;
		this.username = username;
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
		this.friends = friends;
		this.friendOf = friendOf;
		this.password = password;
		this.enabled = enabled;
	}

	public Channel getUserChannel() {
		return userChannel;
	}

	public void setUserChannel(Channel userChannel) {
		this.userChannel = userChannel;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
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
	

	public List<Users> getFriends() {
		return friends;
	}

	public void setFriends(List<Users> friends) {
		this.friends = friends;
	}

	public List<Users> getFriendOf() {
		return friendOf;
	}

	public void setFriendOf(List<Users> friendOf) {
		this.friendOf = friendOf;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", email=" + email + ", age=" + age + ", image=" + image + ", sexe="
				+ sexe + ", ville=" + ville + ", departement=" + departement + ", modo=" + role + "]";
	} 
	
	
	
}
