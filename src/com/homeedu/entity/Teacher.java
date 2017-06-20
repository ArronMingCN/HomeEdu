package com.homeedu.entity;

import com.homeedu.util.DateUtil;

public class Teacher {
	
	String id;
	String name;
	String password;
	String gender;
	String birth_year;
	String birth_month;
	String sno;
	String telephone;
	String school;
	String major;
	String GPA;
	String portrait;
	String introduction;
	Integer level;
	String course1;
	String course2;
	String course3;
	String course4;
	String course5;
	String location;
	String teach_time;
	String ordernum;
	String created_at;
	String updated_at;
	

	public Teacher(){
		
	}
	
	/*public Teacher(String newid,String name2,String password2,
			String gender2,String birth_year2,String birth_month2
			,String  sno2,String telephone2,String school2,String 
			major2,String GPA2,String portrait2,String introduction2,
			String level2,String course12,String course22,
			String course32,String course42,String course52,
			String location2,String teach_time2,String ordernum2,
			String created_at2,String updated_at2) {
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
	}*/
	public Teacher(String newId, String name2, String password2, String gender2
		) {
		super();
		this.id = newId;
		this.name = name2;
		this.password = password2;
		this.gender = gender2;
		
		this.birth_year ="";
		this.birth_month = "";
		this.sno = "";
		this.telephone = "";
		this.school = "";
		this.major = "";
		this.GPA = "";
		this.portrait = "";
		this.introduction = "";
		this.level = 1;
		this.course1 = "";
		this.course2 = "";
		this.course3 = "";
		this.course4 = "";
		this.course5 = "";
		this.location = "";
		this.teach_time = "";
		this.ordernum = "";
		this.created_at =DateUtil.getCurrentTimestamp().toString();;
		this.updated_at = DateUtil.getCurrentTimestamp().toString();;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth_year() {
		return birth_year;
	}
	public void setBirth_year(String birth_year) {
		this.birth_year = birth_year;
	}
	public String getBirth_month() {
		return birth_month;
	}
	public void setBirth_month(String birth_month) {
		this.birth_month = birth_month;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGPA() {
		return GPA;
	}
	public void setGPA(String gPA) {
		GPA = gPA;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getCourse1() {
		return course1;
	}
	public void setCourse1(String course1) {
		this.course1 = course1;
	}
	public String getCourse2() {
		return course2;
	}
	public void setCourse2(String course2) {
		this.course2 = course2;
	}
	public String getCourse3() {
		return course3;
	}
	public void setCourse3(String course3) {
		this.course3 = course3;
	}
	public String getCourse4() {
		return course4;
	}
	public void setCourse4(String course4) {
		this.course4 = course4;
	}
	public String getCourse5() {
		return course5;
	}
	public void setCourse5(String course5) {
		this.course5 = course5;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getTeach_time() {
		return teach_time;
	}
	public void setTeach_time(String teach_time) {
		this.teach_time = teach_time;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", password="
				+ password + ", gender=" + gender + ", birth_year="
				+ birth_year + ", birth_month=" + birth_month + ", sno=" + sno
				+ ", telephone=" + telephone + ", school=" + school
				+ ", major=" + major + ", GPA=" + GPA + ", portrait="
				+ portrait + ", introduction=" + introduction + ", level="
				+ level + ", course1=" + course1 + ", course2=" + course2
				+ ", course3=" + course3 + ", course4=" + course4
				+ ", course5=" + course5 + ", location=" + location
				+ ", teach_time=" + teach_time + ", ordernum=" + ordernum
				+ ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}
	
	
	
	

}
