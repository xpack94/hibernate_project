package com.xpack.insta_copy.insta_copy_tables;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="users")
@Entity
public class Users {
	@Column(name="id")
	@Id @GeneratedValue
	private int id ;
	
	@Column(name="username",columnDefinition="varchar(255) unique" ,nullable=false)
	private String username;
	
	@Column(name="created_at",columnDefinition=" timestamp default now()")
	private Timestamp created_at;
	
	@OneToMany(mappedBy="user_id")
	List<Photos> photos =new ArrayList<Photos>();
	
	
	
	//constructor
	public Users( String username, Timestamp created_at) {
		super();
		this.username = username;
		this.created_at = created_at;
	}
	
	public Users( String username) {
		super();
		this.username = username;
		this.created_at = created_at;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", created_at=" + created_at + "]";
	}
	
	
	
	
}
