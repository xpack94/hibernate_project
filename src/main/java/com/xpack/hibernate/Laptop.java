package com.xpack.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Laptop {

	@Id @GeneratedValue
	private int laptop_id;
	@Column(name="laptopName")
	private String laptop_name;
	@ManyToOne
	private Students student;
	
	
	
	
	public int getLaptop_id() {
		return laptop_id;
	}
	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}
	public String getLaptop_name() {
		return laptop_name;
	}
	public void setLaptop_name(String laptop_name) {
		this.laptop_name = laptop_name;
	}
	
	public Students getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Laptop [laptop_id=" + laptop_id + ", laptop_name=" + laptop_name + ", student=" + student.getId() + "]";
	}
	
	
	
	
	
	
}
