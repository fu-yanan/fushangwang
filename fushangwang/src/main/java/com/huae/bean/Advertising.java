package com.huae.bean;

public class Advertising {
	private int id;
	private String advertisingName;
	private String imgUrl;
	private String advertisingUrl;
	private String status;
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdvertisingName() {
		return advertisingName;
	}
	public void setAdvertisingName(String advertisingName) {
		this.advertisingName = advertisingName;
	}
	public String getAdvertisingUrl() {
		return advertisingUrl;
	}
	public void setAdvertisingUrl(String advertisingUrl) {
		this.advertisingUrl = advertisingUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Advertising [id=" + id + ", advertisingName=" + advertisingName + ", imgUrl=" + imgUrl
				+ ", advertisingUrl=" + advertisingUrl + ", status=" + status + "]";
	}
	public Advertising(int id, String advertisingName, String imgUrl, String advertisingUrl, String status) {
		super();
		this.id = id;
		this.advertisingName = advertisingName;
		this.imgUrl = imgUrl;
		this.advertisingUrl = advertisingUrl;
		this.status = status;
	}
	public Advertising() {
		super();
	}
	
}
