package com.huae.bean;

public class BannerConfig {
	private Integer id;
	private String b_name;
	private String b_img;
	private String carousel;
	private Integer weight;
	private String b_path;
	
	public String getCarousel() {
		return carousel;
	}
	public void setCarousel(String carousel) {
		this.carousel = carousel;
	}
	public String getB_path() {
		return b_path;
	}
	public void setB_path(String b_path) {
		this.b_path = b_path;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_img() {
		return b_img;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
}
