package com.homeedu.entity;

import com.homeedu.util.DateUtil;

public class Message {
		Integer id;
		String surname;
		String course1;
		String course2;
		String course3;
		String student_gender;
		String student_grade;
		String student_status;
		String teach_gender;
		String teach_location;
		String teach_time;
		String salary;
		String teach_request;
		String created_at;
		String teach_type;
		String bookTeacher1;
		String bookTeacher2;
		String bookTeacher3;
		String parent_id;
		int flag;
		String teach_id;
		String deal_time;
		public Message(){
			
		}
		
		
	

	

		public Message(String surname, String course1,String student_gender, String student_grade,
				String student_status, String teach_gender,
				String teach_location, String teach_time, String salary,String teach_request,
				String teach_type,String parent_id) {
			super();
			this.surname = surname;
			this.course1 = course1;
			this.student_gender = student_gender;
			this.student_grade = student_grade;
			this.student_status = student_status;
			this.teach_gender = teach_gender;
			this.teach_location = teach_location;
			this.teach_time = teach_time;
			this.salary = salary;
			this.teach_request = teach_request;
			this.teach_type=teach_type;
			this.parent_id=parent_id;
			
			this.flag=0;
			this.course2 ="";
			this.course3 ="";
			this.created_at=DateUtil.getCurrentTimestamp().toString();
		}


	

		@Override
		public String toString() {
			return "Message [id=" + id + ", surname=" + surname + ", course1="
					+ course1 + ", course2=" + course2 + ", course3=" + course3
					+ ", student_gender=" + student_gender + ", student_grade="
					+ student_grade + ", student_status=" + student_status
					+ ", teach_gender=" + teach_gender + ", teach_location="
					+ teach_location + ", teach_time=" + teach_time
					+ ", salary=" + salary + ", teach_request=" + teach_request
					+ ", created_at=" + created_at + ", teach_type="
					+ teach_type + "]";
		}




		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
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

		public String getStudent_gender() {
			return student_gender;
		}

		public void setStudent_gender(String student_gender) {
			this.student_gender = student_gender;
		}

		public String getStudent_grade() {
			return student_grade;
		}

		public void setStudent_grade(String student_grade) {
			this.student_grade = student_grade;
		}

		public String getStudent_status() {
			return student_status;
		}

		public void setStudent_status(String student_status) {
			this.student_status = student_status;
		}

		public String getTeach_gender() {
			return teach_gender;
		}

		public void setTeach_gender(String teach_gender) {
			this.teach_gender = teach_gender;
		}

		public String getTeach_location() {
			return teach_location;
		}

		public void setTeach_location(String teach_location) {
			this.teach_location = teach_location;
		}

		public String getTeach_time() {
			return teach_time;
		}

		public void setTeach_time(String teach_time) {
			this.teach_time = teach_time;
		}

		public String getSalary() {
			return salary;
		}

		public void setSalary(String salary) {
			this.salary = salary;
		}

		public String getTeach_request() {
			return teach_request;
		}

		public void setTeach_request(String teach_request) {
			this.teach_request = teach_request;
		}
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}




		public String getTeach_type() {
			return teach_type;
		}
		public void setTeach_type(String teach_type) {
			this.teach_type = teach_type;
		}
		public String getBookTeacher1() {
			return bookTeacher1;
		}

		public void setBookTeacher1(String bookTeacher1) {
			this.bookTeacher1 = bookTeacher1;
		}

		public String getBookTeacher2() {
			return bookTeacher2;
		}
		public void setBookTeacher2(String bookTeacher2) {
			this.bookTeacher2 = bookTeacher2;
		}

		public String getBookTeacher3() {
			return bookTeacher3;
		}

		public void setBookTeacher3(String bookTeacher3) {
			this.bookTeacher3 = bookTeacher3;
		}

		public String getParent_id() {
			return parent_id;
		}

		public void setParent_id(String parent_id) {
			this.parent_id = parent_id;
		}

		public int getFlag() {
			return flag;
		}






		public void setFlag(int flag) {
			this.flag = flag;
		}






		public String getTeach_id() {
			return teach_id;
		}






		public void setTeach_id(String teach_id) {
			this.teach_id = teach_id;
		}






		public String getDeal_time() {
			return deal_time;
		}






		public void setDeal_time(String deal_time) {
			this.deal_time = deal_time;
		}

		
	}

