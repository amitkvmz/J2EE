package com.info.model;

public class userModel 
{
	private String username;
	private String password;
	private String name;
	private String id;
	private String status;
	public userModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public userModel(String username, String password, String name, String id,
			String status) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.id = id;
		this.status = status;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
