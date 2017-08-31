package com.sdtele.tta.models;

public class User {
	private String username;
	private String nickname;
	private long id;
	private User manager;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getManager() {
		return this.manager;
	}
	public void setManager(User manager) {
		this.manager=manager;
	}
}
