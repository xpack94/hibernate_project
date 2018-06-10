package com.xpack.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.engine.FetchStyle;



@Entity
public class Students {
	@Id @GeneratedValue
	private int id;
	
	private Name names;
	@OneToMany(mappedBy="student")
	private List<Laptop> laptops=new ArrayList<Laptop>();
	
	
	
	public List<Laptop> getLaptops() {
		return laptops;
	}
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Name getNames() {
		return names;
	}
	public void setNames(Name names) {
		this.names = names;
	}
	@Override
	public String toString() {
		return "Students [id=" + id + ", names=" + names + ", laptops=" + laptops + "]";
	}

	
	
	
}
