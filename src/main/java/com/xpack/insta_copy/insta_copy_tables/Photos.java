package com.xpack.insta_copy.insta_copy_tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Users user_id;
	
	
	
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
	@Override
	public String toString() {
		return "Photos [id=" + id + ", image_url=" + image_url + ", user_id=" + user_id + "]";
	}
	
	
	
	
}
