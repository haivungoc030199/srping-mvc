package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class CommentEntity extends BaseEntity{
	@Column(name="content")
	private String content;
	
	@Column(name="userid")
	private long userId;
	
	@Column(name="newid")
	private long newId;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getNewId() {
		return newId;
	}
	public void setNewId(long newId) {
		this.newId = newId;
	}
	
	

}
