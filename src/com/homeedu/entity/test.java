package com.homeedu.entity;


/**
 * 测试用实体
 * @author Arron
 *
 */
public class test {

	private Integer id;
	private String UserId;//用户名
	private String name;
	private String password;
	public test(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
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
	@Override
	public String toString() {
		return "test [id=" + id + ", UserId=" + UserId + ", name=" + name + "]";
	}
	

	
}
