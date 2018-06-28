package com.xpack.insta_copy.insta_copy_tables;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity
@Table(name="users")
public class Users {
	@Column(name="id")
	@Id @GeneratedValue
	private int id ;
	
	@Column(name="username",columnDefinition="varchar(255) unique" ,nullable=false)
	private String username;
	
	@Column(name="created_at",columnDefinition=" timestamp default now()")
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
	@OneToMany(mappedBy="user_id")
	List<Photos> photos =new ArrayList<Photos>();
	
	@OneToMany(mappedBy="user")
	List<Comments> comments=new ArrayList<Comments>();
	
	@OneToMany(mappedBy="folowee_id",fetch=FetchType.LAZY)
	List<Follows> followees =new ArrayList<Follows>();
	
	@OneToMany(mappedBy="folower_id",fetch=FetchType.LAZY)
	List<Follows> followers =new ArrayList<Follows>();
	
	
	public Users() {
		
	}
	
	//constructor
	public Users( String username, Date created_at) {
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
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	
	
	
	public List<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	
	
	public List<Follows> getFollowees() {
		return followees;
	}

	public void setFollowees(List<Follows> followees) {
		this.followees = followees;
	}

	public List<Follows> getFollowers() {
		return followers;
	}

	public void setFollowers(List<Follows> followers) {
		this.followers = followers;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", created_at=" + created_at + "]";
	}
	
	
	
	
}
