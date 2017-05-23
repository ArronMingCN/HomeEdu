package com.homeedu.entity;


/**
 * 家长实体类
 * @author Arron
 *
 */
public class Parent {

	Integer id;
	String name;
	String password;
	Integer ID_num;
	String province;
	String city;
	String district;
	Integer telephone;
	Integer level;
	public Parent(){
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getID_num() {
		return ID_num;
	}
	public void setID_num(Integer iD_num) {
		ID_num = iD_num;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Integer getTelephone() {
		return telephone;
	}
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "Parent [id=" + id + ", name=" + name + ", password=" + password
				+ ", ID_num=" + ID_num + ", province=" + province + ", city="
				+ city + ", district=" + district + ", telephone=" + telephone
				+ ", level=" + level + "]";
	}
	
}
