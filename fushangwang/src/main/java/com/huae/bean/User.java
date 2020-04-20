package com.huae.bean;

import java.sql.Date;

public class User {
	private int id;
	private String username;
	private String idcard;
	private String comefrom;
	private int status;
	private Date jointime;
	private String phone;
	private String idcard_img;
	private String liscese_img;
	public Date getJointime() {
		return jointime;
	}
	public void setJointime(Date jointime) {
		this.jointime = jointime;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	
	
	
	public String getComefrom() {
		return comefrom;
	}
	public void setComefrom(String comefrom) {
		this.comefrom = comefrom;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getIdcard_img() {
		return idcard_img;
	}
	public void setIdcard_img(String idcard_img) {
		this.idcard_img = idcard_img;
	}
	public String getLiscese_img() {
		return liscese_img;
	}
	public void setLiscese_img(String liscese_img) {
		this.liscese_img = liscese_img;
	}

}
