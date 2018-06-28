package com.xpack.insta_copy.insta_copy_tables;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="photos")
@Entity
public class Photos {

	@Id @GeneratedValue @Column(name="id")
	private int id ;
	
	@Column(name="image_url")
	private String image_url;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private Users user_id;
	
	@OneToMany(mappedBy="photo")
	private List<Comments> comments=new ArrayList<Comments>();
	
	public Photos() {}
	public Photos( String image_url, Users user_id) {
		super();
		this.image_url = image_url;
		this.user_id = user_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	public Users getUser_id() {
		return user_id;
	}
	public void setUser_id(Users user_id) {
		this.user_id = user_id;
	}
	
	
	public List<Comments> getComments() {
		return comments;
	}
	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Photos [id=" + id + ", image_url=" + image_url + ", user_id=" + user_id + "]";
	}
	
	
	
	
}
