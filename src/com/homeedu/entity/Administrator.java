package com.homeedu.entity;

public class Administrator {
	
	int id;
	String name;
	String password;
	int level;
	
	public Administrator(){
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", name=" + name + ", password="
				+ password + ", level=" + level + "]";
	}
	
	
}
