package com.xpack.insta_copy.insta_copy_tables;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="follows")
public class Follows implements Serializable {

	@Id @OneToOne
	@JoinColumn(name="follower_id")
	private Users folower_id;
	@Id @OneToOne
	@JoinColumn(name="folowee_id")
	private Users folowee_id;
	
	@Column(name="created_at",columnDefinition="timestamp default now()")
	@Temporal(TemporalType.DATE)
	private Date created_at;
	public Follows() {
		
	}
	
	public Follows(Users folower_id, Users folowee_id) {
		super();
		this.folower_id = folower_id;
		this.folowee_id = folowee_id;
	}

	public Users getFolower_id() {
		return folower_id;
	}

	public void setFolower_id(Users folower_id) {
		this.folower_id = folower_id;
	}

	public Users getFolowee_id() {
		return folowee_id;
	}

	public void setFolowee_id(Users folowee_id) {
		this.folowee_id = folowee_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Follows [folower_id=" + folower_id + ", folowee_id=" + folowee_id + ", created_at=" + created_at + "]";
	}
	
	
	
}
