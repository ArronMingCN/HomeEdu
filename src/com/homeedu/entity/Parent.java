package com.homeedu.entity;


/**
 * �ҳ�ʵ����
 * @author Arron
 *
 */
public class Parent {

	String id;
	String name;
	String password;
	String ID_num;
	String province;
	String city;
	String district;
	String telephone;
	Integer level;
	public Parent(){
		
	}
	
	public Parent(String newId, String name2, String password2, String id_num2,
			String telephone2, Integer level2) {
		this.id=newId;
		this.name=name2;
		this.password=password2;
		this.ID_num=id_num2;
		this.telephone=telephone2;
		this.level=level2;
		
		this.city="";
		this.district="";
		this.province="";
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getID_num() {
		return ID_num;
	}
	public void setID_num(String iD_num) {
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
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
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
