package com.xpack.insta_copy.insta_copy_tables;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="comments")
public class Comments {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name="comment_text",nullable=false)
	private String comment_text;
	
	@Column(name="created_at",columnDefinition="timestamp default now()")
	@Temporal(TemporalType.DATE)
	private Date created_at;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private Users user;
	
	@OneToOne
	@JoinColumn(name="photo_id")
	private Photos photo;

	public Comments() {}
	public Comments(String comment_text, Users user, Photos photo) {
		super();
		this.comment_text = comment_text;
		this.user = user;
		this.photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment_text() {
		return comment_text;
	}

	public void setComment_text(String comment_text) {
		this.comment_text = comment_text;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Photos getPhoto() {
		return photo;
	}

	public void setPhoto(Photos photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", comment_text=" + comment_text + ", created_at=" + created_at + ", user=" + user
				+ ", photo=" + photo + "]";
	}

	
	
	
}
