package com.xpack.hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Name {
	
	@Column(name="fname",nullable=false)
	private String first_name;
	@Column(name="lname")
	private String last_name;
	@Column(name="mname")
	private String middle_name;
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	@Override
	public String toString() {
		return "Name [first_name=" + first_name + ", last_name=" + last_name + ", middle_name=" + middle_name + "]";
	}
	
	
}
