package com.song.app.entity;

import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String write_id;
	private Date regdate;
	private String content;
	private int hit;
	
	public Notice() {
	}

	//	매개변수로 들어감
	public Notice(int id, String title, String write_id, Date regdate, String content, int hit) {
		this.id = id;
		this.title = title;
		this.write_id = write_id;
		this.regdate = regdate;
		this.content = content;
		this.hit = hit;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWrite_id() {
		return write_id;
	}
	public void setWrite_id(String write_id) {
		this.write_id = write_id;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
