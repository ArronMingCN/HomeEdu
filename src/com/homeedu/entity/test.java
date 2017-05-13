package com.homeedu.entity;

public class test {

	
	private Integer id;
	private String name;
	
	public test(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "test [id=" + id + ", name=" + name + "]";
	}
	
}
