package com.sdtele.tta.models;

import java.util.ArrayList;

public class Team {
	private int id;
	private String name;
	private int parentId;
	private ArrayList<User> managers;
	
	public Team() {}
	
	public Team(int id,String name,int parentId,ArrayList<User> managers) {
		this.id=id;
		this.name=name;
		this.parentId=parentId;
		this.managers=managers;
	}
	public Team(int id,String name,int parentId) {
		this(id,name,parentId,null);
	}
	
	public Team(int id,String name) {
		this(id,name,0,null);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public ArrayList<User> getManagers() {
		return managers;
	}

	public void setManagers(ArrayList<User> managers) {
		this.managers = managers;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", parentId=" + parentId + ", managers=" + managers + "]";
	}
}
