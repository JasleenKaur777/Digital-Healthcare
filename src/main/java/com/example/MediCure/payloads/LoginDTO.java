package com.example.MediCure.payloads;

public class LoginDTO {
private String username;
private String password;
public LoginDTO(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public LoginDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
