package com.info.model;

import java.io.InputStream;

public class PostModel 
{
	private String type;
	private InputStream image;
	private String text;
	private String id;
	private String userid;
	private String status;
	private String date;
	private String like;
	private String unlike;
	private String username;
	public PostModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostModel(String type, InputStream image, String text, String id,
			String userid, String status, String date, String like,
			String unlike, String username) {
		super();
		this.type = type;
		this.image = image;
		this.text = text;
		this.id = id;
		this.userid = userid;
		this.status = status;
		this.date = date;
		this.like = like;
		this.unlike = unlike;
		this.username = username;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getUnlike() {
		return unlike;
	}
	public void setUnlike(String unlike) {
		this.unlike = unlike;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
