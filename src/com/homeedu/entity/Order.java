package com.homeedu.entity;

public class Order {
	
	int id;
	int teacher_id;
	int parent_id;
	int message_id;
	int deal;
	String deal_time;
	
	public Order(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public int getDeal() {
		return deal;
	}

	public void setDeal(int deal) {
		this.deal = deal;
	}

	public String getDeal_time() {
		return deal_time;
	}

	public void setDeal_time(String deal_time) {
		this.deal_time = deal_time;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", teacher_id=" + teacher_id
				+ ", parent_id=" + parent_id + ", message_id=" + message_id
				+ ", deal=" + deal + ", deal_time=" + deal_time + "]";
	}
	
	
}
