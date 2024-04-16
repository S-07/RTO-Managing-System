package com.rtofinalproject.registrations.model;

import jakarta.persistence.*;



@Entity
@Table(name = "NewUsers")
public class UserRegisterModel {
	
	
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private Long user_id;

@Column(name = "username")
private String username;

@Column(name = "user_fullname")
private String user_fullname;

@Column(name = "mobile_number")
private String user_mobile;

@Column(name = "user_email")
private String user_email;

@Column(name = "password")
private String password;




public Long getUser_id() {
	return user_id;
}
public void setUser_id(Long user_id) {
	this.user_id = user_id;
}

public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUser_fullname() {
	return user_fullname;
}
public void setUser_fullname(String user_fullname) {
	this.user_fullname = user_fullname;
}
public String getUser_mobile() {
	return user_mobile;
}
public void setUser_mobile(String user_mobile) {
	this.user_mobile = user_mobile;
}
public String getUser_email() {
	return user_email;
}
public void setUser_email(String user_email) {
	this.user_email = user_email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


@Override
public String toString() {
	return "UserRegisterModel [user_id=" + user_id + ", username=" + username + ", user_fullname=" + user_fullname
			+ ", user_mobile=" + user_mobile + ", user_email=" + user_email + ", password=" + password + "]";
}


}












